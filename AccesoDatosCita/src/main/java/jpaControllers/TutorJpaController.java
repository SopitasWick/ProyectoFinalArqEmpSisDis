/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.itson.edu.mx.entidades.PacienteTutor;
import com.itson.edu.mx.entidades.Tutor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaControllers.exceptions.IllegalOrphanException;
import jpaControllers.exceptions.NonexistentEntityException;
import jpaControllers.exceptions.PreexistingEntityException;

/**
 *
 * @author DELL
 */
public class TutorJpaController implements Serializable {

    public TutorJpaController() {
        this.emf=Persistence.createEntityManagerFactory("sistemaCitaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tutor tutor) throws PreexistingEntityException, Exception {
        if (tutor.getPacienteTutorList() == null) {
            tutor.setPacienteTutorList(new ArrayList<PacienteTutor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PacienteTutor> attachedPacienteTutorList = new ArrayList<PacienteTutor>();
            for (PacienteTutor pacienteTutorListPacienteTutorToAttach : tutor.getPacienteTutorList()) {
                pacienteTutorListPacienteTutorToAttach = em.getReference(pacienteTutorListPacienteTutorToAttach.getClass(), pacienteTutorListPacienteTutorToAttach.getIdPacienteTutor());
                attachedPacienteTutorList.add(pacienteTutorListPacienteTutorToAttach);
            }
            tutor.setPacienteTutorList(attachedPacienteTutorList);
            em.persist(tutor);
            for (PacienteTutor pacienteTutorListPacienteTutor : tutor.getPacienteTutorList()) {
                Tutor oldIdTutorOfPacienteTutorListPacienteTutor = pacienteTutorListPacienteTutor.getIdTutor();
                pacienteTutorListPacienteTutor.setIdTutor(tutor);
                pacienteTutorListPacienteTutor = em.merge(pacienteTutorListPacienteTutor);
                if (oldIdTutorOfPacienteTutorListPacienteTutor != null) {
                    oldIdTutorOfPacienteTutorListPacienteTutor.getPacienteTutorList().remove(pacienteTutorListPacienteTutor);
                    oldIdTutorOfPacienteTutorListPacienteTutor = em.merge(oldIdTutorOfPacienteTutorListPacienteTutor);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTutor(tutor.getIdTutor()) != null) {
                throw new PreexistingEntityException("Tutor " + tutor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tutor tutor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tutor persistentTutor = em.find(Tutor.class, tutor.getIdTutor());
            List<PacienteTutor> pacienteTutorListOld = persistentTutor.getPacienteTutorList();
            List<PacienteTutor> pacienteTutorListNew = tutor.getPacienteTutorList();
            List<String> illegalOrphanMessages = null;
            for (PacienteTutor pacienteTutorListOldPacienteTutor : pacienteTutorListOld) {
                if (!pacienteTutorListNew.contains(pacienteTutorListOldPacienteTutor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PacienteTutor " + pacienteTutorListOldPacienteTutor + " since its idTutor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<PacienteTutor> attachedPacienteTutorListNew = new ArrayList<PacienteTutor>();
            for (PacienteTutor pacienteTutorListNewPacienteTutorToAttach : pacienteTutorListNew) {
                pacienteTutorListNewPacienteTutorToAttach = em.getReference(pacienteTutorListNewPacienteTutorToAttach.getClass(), pacienteTutorListNewPacienteTutorToAttach.getIdPacienteTutor());
                attachedPacienteTutorListNew.add(pacienteTutorListNewPacienteTutorToAttach);
            }
            pacienteTutorListNew = attachedPacienteTutorListNew;
            tutor.setPacienteTutorList(pacienteTutorListNew);
            tutor = em.merge(tutor);
            for (PacienteTutor pacienteTutorListNewPacienteTutor : pacienteTutorListNew) {
                if (!pacienteTutorListOld.contains(pacienteTutorListNewPacienteTutor)) {
                    Tutor oldIdTutorOfPacienteTutorListNewPacienteTutor = pacienteTutorListNewPacienteTutor.getIdTutor();
                    pacienteTutorListNewPacienteTutor.setIdTutor(tutor);
                    pacienteTutorListNewPacienteTutor = em.merge(pacienteTutorListNewPacienteTutor);
                    if (oldIdTutorOfPacienteTutorListNewPacienteTutor != null && !oldIdTutorOfPacienteTutorListNewPacienteTutor.equals(tutor)) {
                        oldIdTutorOfPacienteTutorListNewPacienteTutor.getPacienteTutorList().remove(pacienteTutorListNewPacienteTutor);
                        oldIdTutorOfPacienteTutorListNewPacienteTutor = em.merge(oldIdTutorOfPacienteTutorListNewPacienteTutor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tutor.getIdTutor();
                if (findTutor(id) == null) {
                    throw new NonexistentEntityException("The tutor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tutor tutor;
            try {
                tutor = em.getReference(Tutor.class, id);
                tutor.getIdTutor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tutor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<PacienteTutor> pacienteTutorListOrphanCheck = tutor.getPacienteTutorList();
            for (PacienteTutor pacienteTutorListOrphanCheckPacienteTutor : pacienteTutorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tutor (" + tutor + ") cannot be destroyed since the PacienteTutor " + pacienteTutorListOrphanCheckPacienteTutor + " in its pacienteTutorList field has a non-nullable idTutor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tutor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tutor> findTutorEntities() {
        return findTutorEntities(true, -1, -1);
    }

    public List<Tutor> findTutorEntities(int maxResults, int firstResult) {
        return findTutorEntities(false, maxResults, firstResult);
    }

    private List<Tutor> findTutorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tutor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tutor findTutor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tutor.class, id);
        } finally {
            em.close();
        }
    }

    public int getTutorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tutor> rt = cq.from(Tutor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

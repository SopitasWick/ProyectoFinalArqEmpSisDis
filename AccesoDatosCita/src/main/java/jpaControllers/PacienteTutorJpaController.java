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
import com.itson.edu.mx.entidades.Paciente;
import com.itson.edu.mx.entidades.PacienteTutor;
import com.itson.edu.mx.entidades.Tutor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaControllers.exceptions.NonexistentEntityException;
import jpaControllers.exceptions.PreexistingEntityException;

/**
 *
 * @author DELL
 */
public class PacienteTutorJpaController implements Serializable {

    public PacienteTutorJpaController() {
        this.emf=Persistence.createEntityManagerFactory("sistemaCitaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PacienteTutor pacienteTutor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente idPaciente = pacienteTutor.getIdPaciente();
            if (idPaciente != null) {
                idPaciente = em.getReference(idPaciente.getClass(), idPaciente.getIdPaciente());
                pacienteTutor.setIdPaciente(idPaciente);
            }
            Tutor idTutor = pacienteTutor.getIdTutor();
            if (idTutor != null) {
                idTutor = em.getReference(idTutor.getClass(), idTutor.getIdTutor());
                pacienteTutor.setIdTutor(idTutor);
            }
            em.persist(pacienteTutor);
            if (idPaciente != null) {
                idPaciente.getPacienteTutorList().add(pacienteTutor);
                idPaciente = em.merge(idPaciente);
            }
            if (idTutor != null) {
                idTutor.getPacienteTutorList().add(pacienteTutor);
                idTutor = em.merge(idTutor);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPacienteTutor(pacienteTutor.getIdPacienteTutor()) != null) {
                throw new PreexistingEntityException("PacienteTutor " + pacienteTutor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PacienteTutor pacienteTutor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PacienteTutor persistentPacienteTutor = em.find(PacienteTutor.class, pacienteTutor.getIdPacienteTutor());
            Paciente idPacienteOld = persistentPacienteTutor.getIdPaciente();
            Paciente idPacienteNew = pacienteTutor.getIdPaciente();
            Tutor idTutorOld = persistentPacienteTutor.getIdTutor();
            Tutor idTutorNew = pacienteTutor.getIdTutor();
            if (idPacienteNew != null) {
                idPacienteNew = em.getReference(idPacienteNew.getClass(), idPacienteNew.getIdPaciente());
                pacienteTutor.setIdPaciente(idPacienteNew);
            }
            if (idTutorNew != null) {
                idTutorNew = em.getReference(idTutorNew.getClass(), idTutorNew.getIdTutor());
                pacienteTutor.setIdTutor(idTutorNew);
            }
            pacienteTutor = em.merge(pacienteTutor);
            if (idPacienteOld != null && !idPacienteOld.equals(idPacienteNew)) {
                idPacienteOld.getPacienteTutorList().remove(pacienteTutor);
                idPacienteOld = em.merge(idPacienteOld);
            }
            if (idPacienteNew != null && !idPacienteNew.equals(idPacienteOld)) {
                idPacienteNew.getPacienteTutorList().add(pacienteTutor);
                idPacienteNew = em.merge(idPacienteNew);
            }
            if (idTutorOld != null && !idTutorOld.equals(idTutorNew)) {
                idTutorOld.getPacienteTutorList().remove(pacienteTutor);
                idTutorOld = em.merge(idTutorOld);
            }
            if (idTutorNew != null && !idTutorNew.equals(idTutorOld)) {
                idTutorNew.getPacienteTutorList().add(pacienteTutor);
                idTutorNew = em.merge(idTutorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pacienteTutor.getIdPacienteTutor();
                if (findPacienteTutor(id) == null) {
                    throw new NonexistentEntityException("The pacienteTutor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PacienteTutor pacienteTutor;
            try {
                pacienteTutor = em.getReference(PacienteTutor.class, id);
                pacienteTutor.getIdPacienteTutor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pacienteTutor with id " + id + " no longer exists.", enfe);
            }
            Paciente idPaciente = pacienteTutor.getIdPaciente();
            if (idPaciente != null) {
                idPaciente.getPacienteTutorList().remove(pacienteTutor);
                idPaciente = em.merge(idPaciente);
            }
            Tutor idTutor = pacienteTutor.getIdTutor();
            if (idTutor != null) {
                idTutor.getPacienteTutorList().remove(pacienteTutor);
                idTutor = em.merge(idTutor);
            }
            em.remove(pacienteTutor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PacienteTutor> findPacienteTutorEntities() {
        return findPacienteTutorEntities(true, -1, -1);
    }

    public List<PacienteTutor> findPacienteTutorEntities(int maxResults, int firstResult) {
        return findPacienteTutorEntities(false, maxResults, firstResult);
    }

    private List<PacienteTutor> findPacienteTutorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PacienteTutor.class));
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

    public PacienteTutor findPacienteTutor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PacienteTutor.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteTutorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PacienteTutor> rt = cq.from(PacienteTutor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

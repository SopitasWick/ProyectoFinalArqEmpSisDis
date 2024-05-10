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
import com.itson.edu.mx.entidades.CitaPaciente;
import com.itson.edu.mx.entidades.Medico;
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
public class MedicoJpaController implements Serializable {

    public MedicoJpaController() {
        this.emf=Persistence.createEntityManagerFactory("sistemaCitaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medico medico) throws PreexistingEntityException, Exception {
        if (medico.getCitaPacienteList() == null) {
            medico.setCitaPacienteList(new ArrayList<CitaPaciente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CitaPaciente> attachedCitaPacienteList = new ArrayList<CitaPaciente>();
            for (CitaPaciente citaPacienteListCitaPacienteToAttach : medico.getCitaPacienteList()) {
                citaPacienteListCitaPacienteToAttach = em.getReference(citaPacienteListCitaPacienteToAttach.getClass(), citaPacienteListCitaPacienteToAttach.getIdCita());
                attachedCitaPacienteList.add(citaPacienteListCitaPacienteToAttach);
            }
            medico.setCitaPacienteList(attachedCitaPacienteList);
            em.persist(medico);
            for (CitaPaciente citaPacienteListCitaPaciente : medico.getCitaPacienteList()) {
                Medico oldIdMedicoOfCitaPacienteListCitaPaciente = citaPacienteListCitaPaciente.getIdMedico();
                citaPacienteListCitaPaciente.setIdMedico(medico);
                citaPacienteListCitaPaciente = em.merge(citaPacienteListCitaPaciente);
                if (oldIdMedicoOfCitaPacienteListCitaPaciente != null) {
                    oldIdMedicoOfCitaPacienteListCitaPaciente.getCitaPacienteList().remove(citaPacienteListCitaPaciente);
                    oldIdMedicoOfCitaPacienteListCitaPaciente = em.merge(oldIdMedicoOfCitaPacienteListCitaPaciente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMedico(medico.getIdMedico()) != null) {
                throw new PreexistingEntityException("Medico " + medico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medico medico) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico persistentMedico = em.find(Medico.class, medico.getIdMedico());
            List<CitaPaciente> citaPacienteListOld = persistentMedico.getCitaPacienteList();
            List<CitaPaciente> citaPacienteListNew = medico.getCitaPacienteList();
            List<String> illegalOrphanMessages = null;
            for (CitaPaciente citaPacienteListOldCitaPaciente : citaPacienteListOld) {
                if (!citaPacienteListNew.contains(citaPacienteListOldCitaPaciente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain CitaPaciente " + citaPacienteListOldCitaPaciente + " since its idMedico field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<CitaPaciente> attachedCitaPacienteListNew = new ArrayList<CitaPaciente>();
            for (CitaPaciente citaPacienteListNewCitaPacienteToAttach : citaPacienteListNew) {
                citaPacienteListNewCitaPacienteToAttach = em.getReference(citaPacienteListNewCitaPacienteToAttach.getClass(), citaPacienteListNewCitaPacienteToAttach.getIdCita());
                attachedCitaPacienteListNew.add(citaPacienteListNewCitaPacienteToAttach);
            }
            citaPacienteListNew = attachedCitaPacienteListNew;
            medico.setCitaPacienteList(citaPacienteListNew);
            medico = em.merge(medico);
            for (CitaPaciente citaPacienteListNewCitaPaciente : citaPacienteListNew) {
                if (!citaPacienteListOld.contains(citaPacienteListNewCitaPaciente)) {
                    Medico oldIdMedicoOfCitaPacienteListNewCitaPaciente = citaPacienteListNewCitaPaciente.getIdMedico();
                    citaPacienteListNewCitaPaciente.setIdMedico(medico);
                    citaPacienteListNewCitaPaciente = em.merge(citaPacienteListNewCitaPaciente);
                    if (oldIdMedicoOfCitaPacienteListNewCitaPaciente != null && !oldIdMedicoOfCitaPacienteListNewCitaPaciente.equals(medico)) {
                        oldIdMedicoOfCitaPacienteListNewCitaPaciente.getCitaPacienteList().remove(citaPacienteListNewCitaPaciente);
                        oldIdMedicoOfCitaPacienteListNewCitaPaciente = em.merge(oldIdMedicoOfCitaPacienteListNewCitaPaciente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medico.getIdMedico();
                if (findMedico(id) == null) {
                    throw new NonexistentEntityException("The medico with id " + id + " no longer exists.");
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
            Medico medico;
            try {
                medico = em.getReference(Medico.class, id);
                medico.getIdMedico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medico with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<CitaPaciente> citaPacienteListOrphanCheck = medico.getCitaPacienteList();
            for (CitaPaciente citaPacienteListOrphanCheckCitaPaciente : citaPacienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Medico (" + medico + ") cannot be destroyed since the CitaPaciente " + citaPacienteListOrphanCheckCitaPaciente + " in its citaPacienteList field has a non-nullable idMedico field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(medico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medico> findMedicoEntities() {
        return findMedicoEntities(true, -1, -1);
    }

    public List<Medico> findMedicoEntities(int maxResults, int firstResult) {
        return findMedicoEntities(false, maxResults, firstResult);
    }

    private List<Medico> findMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medico.class));
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

    public Medico findMedico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medico> rt = cq.from(Medico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

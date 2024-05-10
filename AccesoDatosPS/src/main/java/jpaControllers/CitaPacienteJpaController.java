/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import entidades.CitaPaciente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpaControllers.exceptions.NonexistentEntityException;
import jpaControllers.exceptions.PreexistingEntityException;

/**
 *
 * @author DELL
 */
public class CitaPacienteJpaController implements Serializable {

    public CitaPacienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("autenticacionPSPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CitaPaciente citaPaciente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(citaPaciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCitaPaciente(citaPaciente.getIdPacientecita()) != null) {
                throw new PreexistingEntityException("CitaPaciente " + citaPaciente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CitaPaciente citaPaciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            citaPaciente = em.merge(citaPaciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = citaPaciente.getIdPacientecita();
                if (findCitaPaciente(id) == null) {
                    throw new NonexistentEntityException("The citaPaciente with id " + id + " no longer exists.");
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
            CitaPaciente citaPaciente;
            try {
                citaPaciente = em.getReference(CitaPaciente.class, id);
                citaPaciente.getIdPacientecita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The citaPaciente with id " + id + " no longer exists.", enfe);
            }
            em.remove(citaPaciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CitaPaciente> findCitaPacienteEntities() {
        return findCitaPacienteEntities(true, -1, -1);
    }

    public List<CitaPaciente> findCitaPacienteEntities(int maxResults, int firstResult) {
        return findCitaPacienteEntities(false, maxResults, firstResult);
    }

    private List<CitaPaciente> findCitaPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CitaPaciente.class));
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

    public CitaPaciente findCitaPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CitaPaciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getCitaPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CitaPaciente> rt = cq.from(CitaPaciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

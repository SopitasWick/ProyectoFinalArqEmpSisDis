/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import entidades.CedulaProfesional;
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
public class CedulaProfesionalJpaController implements Serializable {

    public CedulaProfesionalJpaController() {
        this.emf =  Persistence.createEntityManagerFactory("cedulasaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CedulaProfesional cedulaProfesional) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cedulaProfesional);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCedulaProfesional(cedulaProfesional.getIdCedulaProfesional()) != null) {
                throw new PreexistingEntityException("CedulaProfesional " + cedulaProfesional + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CedulaProfesional cedulaProfesional) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cedulaProfesional = em.merge(cedulaProfesional);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cedulaProfesional.getIdCedulaProfesional();
                if (findCedulaProfesional(id) == null) {
                    throw new NonexistentEntityException("The cedulaProfesional with id " + id + " no longer exists.");
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
            CedulaProfesional cedulaProfesional;
            try {
                cedulaProfesional = em.getReference(CedulaProfesional.class, id);
                cedulaProfesional.getIdCedulaProfesional();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cedulaProfesional with id " + id + " no longer exists.", enfe);
            }
            em.remove(cedulaProfesional);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CedulaProfesional> findCedulaProfesionalEntities() {
        return findCedulaProfesionalEntities(true, -1, -1);
    }

    public List<CedulaProfesional> findCedulaProfesionalEntities(int maxResults, int firstResult) {
        return findCedulaProfesionalEntities(false, maxResults, firstResult);
    }

    private List<CedulaProfesional> findCedulaProfesionalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CedulaProfesional.class));
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

    public CedulaProfesional findCedulaProfesional(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CedulaProfesional.class, id);
        } finally {
            em.close();
        }
    }

    public int getCedulaProfesionalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CedulaProfesional> rt = cq.from(CedulaProfesional.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

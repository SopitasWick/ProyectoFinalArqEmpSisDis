/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import com.itson.edu.mx.entidades.Usuariomedico;
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
public class UsuariomedicoJpaController implements Serializable {

    public UsuariomedicoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("sistemaCitaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuariomedico usuariomedico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuariomedico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuariomedico(usuariomedico.getIdmedico()) != null) {
                throw new PreexistingEntityException("Usuariomedico " + usuariomedico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuariomedico usuariomedico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuariomedico = em.merge(usuariomedico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuariomedico.getIdmedico();
                if (findUsuariomedico(id) == null) {
                    throw new NonexistentEntityException("The usuariomedico with id " + id + " no longer exists.");
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
            Usuariomedico usuariomedico;
            try {
                usuariomedico = em.getReference(Usuariomedico.class, id);
                usuariomedico.getIdmedico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuariomedico with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuariomedico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuariomedico> findUsuariomedicoEntities() {
        return findUsuariomedicoEntities(true, -1, -1);
    }

    public List<Usuariomedico> findUsuariomedicoEntities(int maxResults, int firstResult) {
        return findUsuariomedicoEntities(false, maxResults, firstResult);
    }

    private List<Usuariomedico> findUsuariomedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuariomedico.class));
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

    public Usuariomedico findUsuariomedico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuariomedico.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariomedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuariomedico> rt = cq.from(Usuariomedico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

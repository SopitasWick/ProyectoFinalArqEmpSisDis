/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import com.itson.edu.mx.entidades.Usuariopaciente;
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
public class UsuariopacienteJpaController implements Serializable {

    public UsuariopacienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("sistemaCitaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuariopaciente usuariopaciente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuariopaciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuariopaciente(usuariopaciente.getIdpaciente()) != null) {
                throw new PreexistingEntityException("Usuariopaciente " + usuariopaciente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuariopaciente usuariopaciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuariopaciente = em.merge(usuariopaciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuariopaciente.getIdpaciente();
                if (findUsuariopaciente(id) == null) {
                    throw new NonexistentEntityException("The usuariopaciente with id " + id + " no longer exists.");
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
            Usuariopaciente usuariopaciente;
            try {
                usuariopaciente = em.getReference(Usuariopaciente.class, id);
                usuariopaciente.getIdpaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuariopaciente with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuariopaciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuariopaciente> findUsuariopacienteEntities() {
        return findUsuariopacienteEntities(true, -1, -1);
    }

    public List<Usuariopaciente> findUsuariopacienteEntities(int maxResults, int firstResult) {
        return findUsuariopacienteEntities(false, maxResults, firstResult);
    }

    private List<Usuariopaciente> findUsuariopacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuariopaciente.class));
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

    public Usuariopaciente findUsuariopaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuariopaciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariopacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuariopaciente> rt = cq.from(Usuariopaciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

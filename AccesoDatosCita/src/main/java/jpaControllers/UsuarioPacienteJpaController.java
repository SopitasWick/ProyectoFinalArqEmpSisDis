/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import com.itson.edu.mx.entidades.UsuarioPaciente;
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
public class UsuarioPacienteJpaController implements Serializable {

    public UsuarioPacienteJpaController() {
          this.emf=Persistence.createEntityManagerFactory("sistemaCitaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioPaciente usuarioPaciente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioPaciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioPaciente(usuarioPaciente.getIdUsuarioPaciente()) != null) {
                throw new PreexistingEntityException("UsuarioPaciente " + usuarioPaciente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioPaciente usuarioPaciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioPaciente = em.merge(usuarioPaciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarioPaciente.getIdUsuarioPaciente();
                if (findUsuarioPaciente(id) == null) {
                    throw new NonexistentEntityException("The usuarioPaciente with id " + id + " no longer exists.");
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
            UsuarioPaciente usuarioPaciente;
            try {
                usuarioPaciente = em.getReference(UsuarioPaciente.class, id);
                usuarioPaciente.getIdUsuarioPaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioPaciente with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioPaciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
//VAMOS A TENER UN USUARIO PARA MEDICO Y OTRO PARA EL PACIENTE
    public List<UsuarioPaciente> findUsuarioPacienteEntities() {
        return findUsuarioPacienteEntities(true, -1, -1);
    }

    public List<UsuarioPaciente> findUsuarioPacienteEntities(int maxResults, int firstResult) {
        return findUsuarioPacienteEntities(false, maxResults, firstResult);
    }

    private List<UsuarioPaciente> findUsuarioPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioPaciente.class));
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

    public UsuarioPaciente findUsuarioPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioPaciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioPaciente> rt = cq.from(UsuarioPaciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

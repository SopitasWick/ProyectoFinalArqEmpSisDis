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
import entidades.Consulta;
import entidades.ExpedientePaciente;
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
public class ExpedientePacienteJpaController implements Serializable {

    public ExpedientePacienteJpaController() {
         this.emf = Persistence.createEntityManagerFactory("com.itson.edu.mx_AccesoDatosExp_jar_1.0-PRUEBACONCEPTOPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ExpedientePaciente expedientePaciente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta idConsulta = expedientePaciente.getIdConsulta();
            if (idConsulta != null) {
                idConsulta = em.getReference(idConsulta.getClass(), idConsulta.getIdConsulta());
                expedientePaciente.setIdConsulta(idConsulta);
            }
            em.persist(expedientePaciente);
            if (idConsulta != null) {
                idConsulta.getExpedientePacienteList().add(expedientePaciente);
                idConsulta = em.merge(idConsulta);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findExpedientePaciente(expedientePaciente.getIdExpediente()) != null) {
                throw new PreexistingEntityException("ExpedientePaciente " + expedientePaciente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ExpedientePaciente expedientePaciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ExpedientePaciente persistentExpedientePaciente = em.find(ExpedientePaciente.class, expedientePaciente.getIdExpediente());
            Consulta idConsultaOld = persistentExpedientePaciente.getIdConsulta();
            Consulta idConsultaNew = expedientePaciente.getIdConsulta();
            if (idConsultaNew != null) {
                idConsultaNew = em.getReference(idConsultaNew.getClass(), idConsultaNew.getIdConsulta());
                expedientePaciente.setIdConsulta(idConsultaNew);
            }
            expedientePaciente = em.merge(expedientePaciente);
            if (idConsultaOld != null && !idConsultaOld.equals(idConsultaNew)) {
                idConsultaOld.getExpedientePacienteList().remove(expedientePaciente);
                idConsultaOld = em.merge(idConsultaOld);
            }
            if (idConsultaNew != null && !idConsultaNew.equals(idConsultaOld)) {
                idConsultaNew.getExpedientePacienteList().add(expedientePaciente);
                idConsultaNew = em.merge(idConsultaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = expedientePaciente.getIdExpediente();
                if (findExpedientePaciente(id) == null) {
                    throw new NonexistentEntityException("The expedientePaciente with id " + id + " no longer exists.");
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
            ExpedientePaciente expedientePaciente;
            try {
                expedientePaciente = em.getReference(ExpedientePaciente.class, id);
                expedientePaciente.getIdExpediente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The expedientePaciente with id " + id + " no longer exists.", enfe);
            }
            Consulta idConsulta = expedientePaciente.getIdConsulta();
            if (idConsulta != null) {
                idConsulta.getExpedientePacienteList().remove(expedientePaciente);
                idConsulta = em.merge(idConsulta);
            }
            em.remove(expedientePaciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ExpedientePaciente> findExpedientePacienteEntities() {
        return findExpedientePacienteEntities(true, -1, -1);
    }

    public List<ExpedientePaciente> findExpedientePacienteEntities(int maxResults, int firstResult) {
        return findExpedientePacienteEntities(false, maxResults, firstResult);
    }

    private List<ExpedientePaciente> findExpedientePacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ExpedientePaciente.class));
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

    public ExpedientePaciente findExpedientePaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ExpedientePaciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getExpedientePacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ExpedientePaciente> rt = cq.from(ExpedientePaciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

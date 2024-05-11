/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import entidades.Consulta;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.ExpedientePaciente;
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
public class ConsultaJpaController implements Serializable {

    public ConsultaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.itson.edu.mx_AccesoDatosExp_jar_1.0-PRUEBACONCEPTOPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consulta consulta) throws PreexistingEntityException, Exception {
        if (consulta.getExpedientePacienteList() == null) {
            consulta.setExpedientePacienteList(new ArrayList<ExpedientePaciente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ExpedientePaciente> attachedExpedientePacienteList = new ArrayList<ExpedientePaciente>();
            for (ExpedientePaciente expedientePacienteListExpedientePacienteToAttach : consulta.getExpedientePacienteList()) {
                expedientePacienteListExpedientePacienteToAttach = em.getReference(expedientePacienteListExpedientePacienteToAttach.getClass(), expedientePacienteListExpedientePacienteToAttach.getIdExpediente());
                attachedExpedientePacienteList.add(expedientePacienteListExpedientePacienteToAttach);
            }
            consulta.setExpedientePacienteList(attachedExpedientePacienteList);
            em.persist(consulta);
            for (ExpedientePaciente expedientePacienteListExpedientePaciente : consulta.getExpedientePacienteList()) {
                Consulta oldIdConsultaOfExpedientePacienteListExpedientePaciente = expedientePacienteListExpedientePaciente.getIdConsulta();
                expedientePacienteListExpedientePaciente.setIdConsulta(consulta);
                expedientePacienteListExpedientePaciente = em.merge(expedientePacienteListExpedientePaciente);
                if (oldIdConsultaOfExpedientePacienteListExpedientePaciente != null) {
                    oldIdConsultaOfExpedientePacienteListExpedientePaciente.getExpedientePacienteList().remove(expedientePacienteListExpedientePaciente);
                    oldIdConsultaOfExpedientePacienteListExpedientePaciente = em.merge(oldIdConsultaOfExpedientePacienteListExpedientePaciente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsulta(consulta.getIdConsulta()) != null) {
                throw new PreexistingEntityException("Consulta " + consulta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consulta consulta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta persistentConsulta = em.find(Consulta.class, consulta.getIdConsulta());
            List<ExpedientePaciente> expedientePacienteListOld = persistentConsulta.getExpedientePacienteList();
            List<ExpedientePaciente> expedientePacienteListNew = consulta.getExpedientePacienteList();
            List<String> illegalOrphanMessages = null;
            for (ExpedientePaciente expedientePacienteListOldExpedientePaciente : expedientePacienteListOld) {
                if (!expedientePacienteListNew.contains(expedientePacienteListOldExpedientePaciente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ExpedientePaciente " + expedientePacienteListOldExpedientePaciente + " since its idConsulta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ExpedientePaciente> attachedExpedientePacienteListNew = new ArrayList<ExpedientePaciente>();
            for (ExpedientePaciente expedientePacienteListNewExpedientePacienteToAttach : expedientePacienteListNew) {
                expedientePacienteListNewExpedientePacienteToAttach = em.getReference(expedientePacienteListNewExpedientePacienteToAttach.getClass(), expedientePacienteListNewExpedientePacienteToAttach.getIdExpediente());
                attachedExpedientePacienteListNew.add(expedientePacienteListNewExpedientePacienteToAttach);
            }
            expedientePacienteListNew = attachedExpedientePacienteListNew;
            consulta.setExpedientePacienteList(expedientePacienteListNew);
            consulta = em.merge(consulta);
            for (ExpedientePaciente expedientePacienteListNewExpedientePaciente : expedientePacienteListNew) {
                if (!expedientePacienteListOld.contains(expedientePacienteListNewExpedientePaciente)) {
                    Consulta oldIdConsultaOfExpedientePacienteListNewExpedientePaciente = expedientePacienteListNewExpedientePaciente.getIdConsulta();
                    expedientePacienteListNewExpedientePaciente.setIdConsulta(consulta);
                    expedientePacienteListNewExpedientePaciente = em.merge(expedientePacienteListNewExpedientePaciente);
                    if (oldIdConsultaOfExpedientePacienteListNewExpedientePaciente != null && !oldIdConsultaOfExpedientePacienteListNewExpedientePaciente.equals(consulta)) {
                        oldIdConsultaOfExpedientePacienteListNewExpedientePaciente.getExpedientePacienteList().remove(expedientePacienteListNewExpedientePaciente);
                        oldIdConsultaOfExpedientePacienteListNewExpedientePaciente = em.merge(oldIdConsultaOfExpedientePacienteListNewExpedientePaciente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = consulta.getIdConsulta();
                if (findConsulta(id) == null) {
                    throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.");
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
            Consulta consulta;
            try {
                consulta = em.getReference(Consulta.class, id);
                consulta.getIdConsulta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ExpedientePaciente> expedientePacienteListOrphanCheck = consulta.getExpedientePacienteList();
            for (ExpedientePaciente expedientePacienteListOrphanCheckExpedientePaciente : expedientePacienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Consulta (" + consulta + ") cannot be destroyed since the ExpedientePaciente " + expedientePacienteListOrphanCheckExpedientePaciente + " in its expedientePacienteList field has a non-nullable idConsulta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(consulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consulta> findConsultaEntities() {
        return findConsultaEntities(true, -1, -1);
    }

    public List<Consulta> findConsultaEntities(int maxResults, int firstResult) {
        return findConsultaEntities(false, maxResults, firstResult);
    }

    private List<Consulta> findConsultaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consulta.class));
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

    public Consulta findConsulta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consulta.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consulta> rt = cq.from(Consulta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

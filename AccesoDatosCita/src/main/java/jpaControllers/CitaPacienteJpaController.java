/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaControllers;

import com.itson.edu.mx.entidades.CitaPaciente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.itson.edu.mx.entidades.Medico;
import com.itson.edu.mx.entidades.Paciente;
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
public class CitaPacienteJpaController implements Serializable {

    public CitaPacienteJpaController() {
        this.emf=Persistence.createEntityManagerFactory("sistemaCitaPU");
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
            Medico idMedico = citaPaciente.getIdMedico();
            if (idMedico != null) {
                idMedico = em.getReference(idMedico.getClass(), idMedico.getIdMedico());
                citaPaciente.setIdMedico(idMedico);
            }
            Paciente idPaciente = citaPaciente.getIdPaciente();
            if (idPaciente != null) {
                idPaciente = em.getReference(idPaciente.getClass(), idPaciente.getIdPaciente());
                citaPaciente.setIdPaciente(idPaciente);
            }
            em.persist(citaPaciente);
            if (idMedico != null) {
                idMedico.getCitaPacienteList().add(citaPaciente);
                idMedico = em.merge(idMedico);
            }
            if (idPaciente != null) {
                idPaciente.getCitaPacienteList().add(citaPaciente);
                idPaciente = em.merge(idPaciente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCitaPaciente(citaPaciente.getIdCita()) != null) {
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
            CitaPaciente persistentCitaPaciente = em.find(CitaPaciente.class, citaPaciente.getIdCita());
            Medico idMedicoOld = persistentCitaPaciente.getIdMedico();
            Medico idMedicoNew = citaPaciente.getIdMedico();
            Paciente idPacienteOld = persistentCitaPaciente.getIdPaciente();
            Paciente idPacienteNew = citaPaciente.getIdPaciente();
            if (idMedicoNew != null) {
                idMedicoNew = em.getReference(idMedicoNew.getClass(), idMedicoNew.getIdMedico());
                citaPaciente.setIdMedico(idMedicoNew);
            }
            if (idPacienteNew != null) {
                idPacienteNew = em.getReference(idPacienteNew.getClass(), idPacienteNew.getIdPaciente());
                citaPaciente.setIdPaciente(idPacienteNew);
            }
            citaPaciente = em.merge(citaPaciente);
            if (idMedicoOld != null && !idMedicoOld.equals(idMedicoNew)) {
                idMedicoOld.getCitaPacienteList().remove(citaPaciente);
                idMedicoOld = em.merge(idMedicoOld);
            }
            if (idMedicoNew != null && !idMedicoNew.equals(idMedicoOld)) {
                idMedicoNew.getCitaPacienteList().add(citaPaciente);
                idMedicoNew = em.merge(idMedicoNew);
            }
            if (idPacienteOld != null && !idPacienteOld.equals(idPacienteNew)) {
                idPacienteOld.getCitaPacienteList().remove(citaPaciente);
                idPacienteOld = em.merge(idPacienteOld);
            }
            if (idPacienteNew != null && !idPacienteNew.equals(idPacienteOld)) {
                idPacienteNew.getCitaPacienteList().add(citaPaciente);
                idPacienteNew = em.merge(idPacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = citaPaciente.getIdCita();
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
                citaPaciente.getIdCita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The citaPaciente with id " + id + " no longer exists.", enfe);
            }
            Medico idMedico = citaPaciente.getIdMedico();
            if (idMedico != null) {
                idMedico.getCitaPacienteList().remove(citaPaciente);
                idMedico = em.merge(idMedico);
            }
            Paciente idPaciente = citaPaciente.getIdPaciente();
            if (idPaciente != null) {
                idPaciente.getCitaPacienteList().remove(citaPaciente);
                idPaciente = em.merge(idPaciente);
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

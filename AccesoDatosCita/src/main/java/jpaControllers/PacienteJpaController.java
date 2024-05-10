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
import com.itson.edu.mx.entidades.Paciente;
import java.util.ArrayList;
import java.util.List;
import com.itson.edu.mx.entidades.UsuarioPaciente;
import com.itson.edu.mx.entidades.PacienteTutor;
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
public class PacienteJpaController implements Serializable {

    public PacienteJpaController() {
        this.emf=Persistence.createEntityManagerFactory("sistemaCitaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) throws PreexistingEntityException, Exception {
        if (paciente.getCitaPacienteList() == null) {
            paciente.setCitaPacienteList(new ArrayList<CitaPaciente>());
        }
        if (paciente.getUsuarioPacienteList() == null) {
            paciente.setUsuarioPacienteList(new ArrayList<UsuarioPaciente>());
        }
        if (paciente.getPacienteTutorList() == null) {
            paciente.setPacienteTutorList(new ArrayList<PacienteTutor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CitaPaciente> attachedCitaPacienteList = new ArrayList<CitaPaciente>();
            for (CitaPaciente citaPacienteListCitaPacienteToAttach : paciente.getCitaPacienteList()) {
                citaPacienteListCitaPacienteToAttach = em.getReference(citaPacienteListCitaPacienteToAttach.getClass(), citaPacienteListCitaPacienteToAttach.getIdCita());
                attachedCitaPacienteList.add(citaPacienteListCitaPacienteToAttach);
            }
            paciente.setCitaPacienteList(attachedCitaPacienteList);
            List<UsuarioPaciente> attachedUsuarioPacienteList = new ArrayList<UsuarioPaciente>();
            for (UsuarioPaciente usuarioPacienteListUsuarioPacienteToAttach : paciente.getUsuarioPacienteList()) {
                usuarioPacienteListUsuarioPacienteToAttach = em.getReference(usuarioPacienteListUsuarioPacienteToAttach.getClass(), usuarioPacienteListUsuarioPacienteToAttach.getIdUsuarioPaciente());
                attachedUsuarioPacienteList.add(usuarioPacienteListUsuarioPacienteToAttach);
            }
            paciente.setUsuarioPacienteList(attachedUsuarioPacienteList);
            List<PacienteTutor> attachedPacienteTutorList = new ArrayList<PacienteTutor>();
            for (PacienteTutor pacienteTutorListPacienteTutorToAttach : paciente.getPacienteTutorList()) {
                pacienteTutorListPacienteTutorToAttach = em.getReference(pacienteTutorListPacienteTutorToAttach.getClass(), pacienteTutorListPacienteTutorToAttach.getIdPacienteTutor());
                attachedPacienteTutorList.add(pacienteTutorListPacienteTutorToAttach);
            }
            paciente.setPacienteTutorList(attachedPacienteTutorList);
            em.persist(paciente);
            for (CitaPaciente citaPacienteListCitaPaciente : paciente.getCitaPacienteList()) {
                Paciente oldIdPacienteOfCitaPacienteListCitaPaciente = citaPacienteListCitaPaciente.getIdPaciente();
                citaPacienteListCitaPaciente.setIdPaciente(paciente);
                citaPacienteListCitaPaciente = em.merge(citaPacienteListCitaPaciente);
                if (oldIdPacienteOfCitaPacienteListCitaPaciente != null) {
                    oldIdPacienteOfCitaPacienteListCitaPaciente.getCitaPacienteList().remove(citaPacienteListCitaPaciente);
                    oldIdPacienteOfCitaPacienteListCitaPaciente = em.merge(oldIdPacienteOfCitaPacienteListCitaPaciente);
                }
            }
            for (UsuarioPaciente usuarioPacienteListUsuarioPaciente : paciente.getUsuarioPacienteList()) {
                Paciente oldIdPacienteOfUsuarioPacienteListUsuarioPaciente = usuarioPacienteListUsuarioPaciente.getIdPaciente();
                usuarioPacienteListUsuarioPaciente.setIdPaciente(paciente);
                usuarioPacienteListUsuarioPaciente = em.merge(usuarioPacienteListUsuarioPaciente);
                if (oldIdPacienteOfUsuarioPacienteListUsuarioPaciente != null) {
                    oldIdPacienteOfUsuarioPacienteListUsuarioPaciente.getUsuarioPacienteList().remove(usuarioPacienteListUsuarioPaciente);
                    oldIdPacienteOfUsuarioPacienteListUsuarioPaciente = em.merge(oldIdPacienteOfUsuarioPacienteListUsuarioPaciente);
                }
            }
            for (PacienteTutor pacienteTutorListPacienteTutor : paciente.getPacienteTutorList()) {
                Paciente oldIdPacienteOfPacienteTutorListPacienteTutor = pacienteTutorListPacienteTutor.getIdPaciente();
                pacienteTutorListPacienteTutor.setIdPaciente(paciente);
                pacienteTutorListPacienteTutor = em.merge(pacienteTutorListPacienteTutor);
                if (oldIdPacienteOfPacienteTutorListPacienteTutor != null) {
                    oldIdPacienteOfPacienteTutorListPacienteTutor.getPacienteTutorList().remove(pacienteTutorListPacienteTutor);
                    oldIdPacienteOfPacienteTutorListPacienteTutor = em.merge(oldIdPacienteOfPacienteTutorListPacienteTutor);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaciente(paciente.getIdPaciente()) != null) {
                throw new PreexistingEntityException("Paciente " + paciente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getIdPaciente());
            List<CitaPaciente> citaPacienteListOld = persistentPaciente.getCitaPacienteList();
            List<CitaPaciente> citaPacienteListNew = paciente.getCitaPacienteList();
            List<UsuarioPaciente> usuarioPacienteListOld = persistentPaciente.getUsuarioPacienteList();
            List<UsuarioPaciente> usuarioPacienteListNew = paciente.getUsuarioPacienteList();
            List<PacienteTutor> pacienteTutorListOld = persistentPaciente.getPacienteTutorList();
            List<PacienteTutor> pacienteTutorListNew = paciente.getPacienteTutorList();
            List<String> illegalOrphanMessages = null;
            for (CitaPaciente citaPacienteListOldCitaPaciente : citaPacienteListOld) {
                if (!citaPacienteListNew.contains(citaPacienteListOldCitaPaciente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain CitaPaciente " + citaPacienteListOldCitaPaciente + " since its idPaciente field is not nullable.");
                }
            }
            for (UsuarioPaciente usuarioPacienteListOldUsuarioPaciente : usuarioPacienteListOld) {
                if (!usuarioPacienteListNew.contains(usuarioPacienteListOldUsuarioPaciente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain UsuarioPaciente " + usuarioPacienteListOldUsuarioPaciente + " since its idPaciente field is not nullable.");
                }
            }
            for (PacienteTutor pacienteTutorListOldPacienteTutor : pacienteTutorListOld) {
                if (!pacienteTutorListNew.contains(pacienteTutorListOldPacienteTutor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PacienteTutor " + pacienteTutorListOldPacienteTutor + " since its idPaciente field is not nullable.");
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
            paciente.setCitaPacienteList(citaPacienteListNew);
            List<UsuarioPaciente> attachedUsuarioPacienteListNew = new ArrayList<UsuarioPaciente>();
            for (UsuarioPaciente usuarioPacienteListNewUsuarioPacienteToAttach : usuarioPacienteListNew) {
                usuarioPacienteListNewUsuarioPacienteToAttach = em.getReference(usuarioPacienteListNewUsuarioPacienteToAttach.getClass(), usuarioPacienteListNewUsuarioPacienteToAttach.getIdUsuarioPaciente());
                attachedUsuarioPacienteListNew.add(usuarioPacienteListNewUsuarioPacienteToAttach);
            }
            usuarioPacienteListNew = attachedUsuarioPacienteListNew;
            paciente.setUsuarioPacienteList(usuarioPacienteListNew);
            List<PacienteTutor> attachedPacienteTutorListNew = new ArrayList<PacienteTutor>();
            for (PacienteTutor pacienteTutorListNewPacienteTutorToAttach : pacienteTutorListNew) {
                pacienteTutorListNewPacienteTutorToAttach = em.getReference(pacienteTutorListNewPacienteTutorToAttach.getClass(), pacienteTutorListNewPacienteTutorToAttach.getIdPacienteTutor());
                attachedPacienteTutorListNew.add(pacienteTutorListNewPacienteTutorToAttach);
            }
            pacienteTutorListNew = attachedPacienteTutorListNew;
            paciente.setPacienteTutorList(pacienteTutorListNew);
            paciente = em.merge(paciente);
            for (CitaPaciente citaPacienteListNewCitaPaciente : citaPacienteListNew) {
                if (!citaPacienteListOld.contains(citaPacienteListNewCitaPaciente)) {
                    Paciente oldIdPacienteOfCitaPacienteListNewCitaPaciente = citaPacienteListNewCitaPaciente.getIdPaciente();
                    citaPacienteListNewCitaPaciente.setIdPaciente(paciente);
                    citaPacienteListNewCitaPaciente = em.merge(citaPacienteListNewCitaPaciente);
                    if (oldIdPacienteOfCitaPacienteListNewCitaPaciente != null && !oldIdPacienteOfCitaPacienteListNewCitaPaciente.equals(paciente)) {
                        oldIdPacienteOfCitaPacienteListNewCitaPaciente.getCitaPacienteList().remove(citaPacienteListNewCitaPaciente);
                        oldIdPacienteOfCitaPacienteListNewCitaPaciente = em.merge(oldIdPacienteOfCitaPacienteListNewCitaPaciente);
                    }
                }
            }
            for (UsuarioPaciente usuarioPacienteListNewUsuarioPaciente : usuarioPacienteListNew) {
                if (!usuarioPacienteListOld.contains(usuarioPacienteListNewUsuarioPaciente)) {
                    Paciente oldIdPacienteOfUsuarioPacienteListNewUsuarioPaciente = usuarioPacienteListNewUsuarioPaciente.getIdPaciente();
                    usuarioPacienteListNewUsuarioPaciente.setIdPaciente(paciente);
                    usuarioPacienteListNewUsuarioPaciente = em.merge(usuarioPacienteListNewUsuarioPaciente);
                    if (oldIdPacienteOfUsuarioPacienteListNewUsuarioPaciente != null && !oldIdPacienteOfUsuarioPacienteListNewUsuarioPaciente.equals(paciente)) {
                        oldIdPacienteOfUsuarioPacienteListNewUsuarioPaciente.getUsuarioPacienteList().remove(usuarioPacienteListNewUsuarioPaciente);
                        oldIdPacienteOfUsuarioPacienteListNewUsuarioPaciente = em.merge(oldIdPacienteOfUsuarioPacienteListNewUsuarioPaciente);
                    }
                }
            }
            for (PacienteTutor pacienteTutorListNewPacienteTutor : pacienteTutorListNew) {
                if (!pacienteTutorListOld.contains(pacienteTutorListNewPacienteTutor)) {
                    Paciente oldIdPacienteOfPacienteTutorListNewPacienteTutor = pacienteTutorListNewPacienteTutor.getIdPaciente();
                    pacienteTutorListNewPacienteTutor.setIdPaciente(paciente);
                    pacienteTutorListNewPacienteTutor = em.merge(pacienteTutorListNewPacienteTutor);
                    if (oldIdPacienteOfPacienteTutorListNewPacienteTutor != null && !oldIdPacienteOfPacienteTutorListNewPacienteTutor.equals(paciente)) {
                        oldIdPacienteOfPacienteTutorListNewPacienteTutor.getPacienteTutorList().remove(pacienteTutorListNewPacienteTutor);
                        oldIdPacienteOfPacienteTutorListNewPacienteTutor = em.merge(oldIdPacienteOfPacienteTutorListNewPacienteTutor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getIdPaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
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
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getIdPaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<CitaPaciente> citaPacienteListOrphanCheck = paciente.getCitaPacienteList();
            for (CitaPaciente citaPacienteListOrphanCheckCitaPaciente : citaPacienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the CitaPaciente " + citaPacienteListOrphanCheckCitaPaciente + " in its citaPacienteList field has a non-nullable idPaciente field.");
            }
            List<UsuarioPaciente> usuarioPacienteListOrphanCheck = paciente.getUsuarioPacienteList();
            for (UsuarioPaciente usuarioPacienteListOrphanCheckUsuarioPaciente : usuarioPacienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the UsuarioPaciente " + usuarioPacienteListOrphanCheckUsuarioPaciente + " in its usuarioPacienteList field has a non-nullable idPaciente field.");
            }
            List<PacienteTutor> pacienteTutorListOrphanCheck = paciente.getPacienteTutorList();
            for (PacienteTutor pacienteTutorListOrphanCheckPacienteTutor : pacienteTutorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the PacienteTutor " + pacienteTutorListOrphanCheckPacienteTutor + " in its pacienteTutorList field has a non-nullable idPaciente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

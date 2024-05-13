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
private EntityManagerFactory emf = null;
    public PacienteJpaController() {
        this.emf=Persistence.createEntityManagerFactory("sistemaCitaPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   public void create(Paciente paciente) throws PreexistingEntityException, Exception {
    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(paciente);
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

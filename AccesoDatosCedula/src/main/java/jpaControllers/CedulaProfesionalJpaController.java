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

    public CedulaProfesional findCedulaProfesional(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CedulaProfesional.class, id);
        } finally {
            em.close();
        }
    }
}

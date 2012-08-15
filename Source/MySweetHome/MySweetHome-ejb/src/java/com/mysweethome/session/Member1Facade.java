/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.Member1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LongVu
 */
@Stateless
public class Member1Facade extends AbstractFacade<Member1> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
        @Override
    public void create(Member1 member) {
        em.persist(member);
    }

    @Override
    public void edit(Member1 member) {
        em.merge(member);
    }

    @Override
    public void remove(Member1 member) {
        em.remove(em.merge(member));
    }  

    public Member1Facade() {
        super(Member1.class);
    }
        
    public Member1 getUserName(String username) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByUserName");
            query.setParameter("userName", username);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public Member1 getPassWord(String pass) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByPassword");
            query.setParameter("password", pass);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }   
    
}

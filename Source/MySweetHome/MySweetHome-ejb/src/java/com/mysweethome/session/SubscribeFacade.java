/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.Subscribe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LongVu
 */
@Stateless
public class SubscribeFacade extends AbstractFacade<Subscribe> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubscribeFacade() {
        super(Subscribe.class);
    }
    
    @Override
    public void create(Subscribe subscribe) {
        em.persist(subscribe);
    }

    @Override
    public void edit(Subscribe subscribe) {
        em.merge(subscribe);
    }

    @Override
    public void remove(Subscribe subscribe) {
        em.remove(em.merge(subscribe));
    }  
}

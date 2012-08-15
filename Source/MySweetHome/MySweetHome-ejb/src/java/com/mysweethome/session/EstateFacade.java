/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.Estate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LongVu
 */
@Stateless
public class EstateFacade extends AbstractFacade<Estate> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstateFacade() {
        super(Estate.class);
    }
 
    @Override
    public void create(Estate estate) {
        em.persist(estate);
    }

    @Override
    public void edit(Estate estate) {
        em.merge(estate);
    }

    @Override
    public void remove(Estate estate) {
        em.remove(em.merge(estate));
    }  
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.FAQs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LongVu
 */
@Stateless
public class FAQsFacade extends AbstractFacade<FAQs> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FAQsFacade() {
        super(FAQs.class);
    }
    
    @Override
    public void create(FAQs faq) {
        em.persist(faq);
    }

    @Override
    public void edit(FAQs faq) {
        em.merge(faq);
    }

    @Override
    public void remove(FAQs faq) {
        em.remove(em.merge(faq));
    }  
}

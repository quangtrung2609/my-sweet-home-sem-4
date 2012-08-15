/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.TransactionDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LongVu
 */
@Stateless
public class TransactionDetailsFacade extends AbstractFacade<TransactionDetails> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionDetailsFacade() {
        super(TransactionDetails.class);
    }
    
    @Override
    public void create(TransactionDetails transactiondetails) {
        em.persist(transactiondetails);
    }

    @Override
    public void edit(TransactionDetails transactiondetails) {
        em.merge(transactiondetails);
    }

    @Override
    public void remove(TransactionDetails transactiondetails) {
        em.remove(em.merge(transactiondetails));
    }  
}

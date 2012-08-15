/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.TypeOfMember;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LongVu
 */
@Stateless
public class TypeOfMemberFacade extends AbstractFacade<TypeOfMember> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeOfMemberFacade() {
        super(TypeOfMember.class);
    }
    
    @Override
    public void create(TypeOfMember typeofmember) {
        em.persist(typeofmember);
    }

    @Override
    public void edit(TypeOfMember typeofmember) {
        em.merge(typeofmember);
    }

    @Override
    public void remove(TypeOfMember typeofmember) {
        em.remove(em.merge(typeofmember));
    }  
    
}

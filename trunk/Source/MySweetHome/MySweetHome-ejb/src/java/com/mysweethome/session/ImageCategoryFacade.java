/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.ImageCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LongVu
 */
@Stateless
public class ImageCategoryFacade extends AbstractFacade<ImageCategory> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImageCategoryFacade() {
        super(ImageCategory.class);
    }
    
    @Override
    public void create(ImageCategory imagecategory) {
        em.persist(imagecategory);
    }

    @Override
    public void edit(ImageCategory imagecategory) {
        em.merge(imagecategory);
    }

    @Override
    public void remove(ImageCategory imagecategory) {
        em.remove(em.merge(imagecategory));
    }  
}

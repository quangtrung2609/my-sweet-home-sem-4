/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Image_Category", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImageCategory.findAll", query = "SELECT i FROM ImageCategory i"),
    @NamedQuery(name = "ImageCategory.findByImageCategoryID", query = "SELECT i FROM ImageCategory i WHERE i.imageCategoryID = :imageCategoryID"),
    @NamedQuery(name = "ImageCategory.findByImage1", query = "SELECT i FROM ImageCategory i WHERE i.image1 = :image1"),
    @NamedQuery(name = "ImageCategory.findByImage2", query = "SELECT i FROM ImageCategory i WHERE i.image2 = :image2"),
    @NamedQuery(name = "ImageCategory.findByImage3", query = "SELECT i FROM ImageCategory i WHERE i.image3 = :image3"),
    @NamedQuery(name = "ImageCategory.findByImage4", query = "SELECT i FROM ImageCategory i WHERE i.image4 = :image4"),
    @NamedQuery(name = "ImageCategory.findByImage5", query = "SELECT i FROM ImageCategory i WHERE i.image5 = :image5"),
    @NamedQuery(name = "ImageCategory.findByImage6", query = "SELECT i FROM ImageCategory i WHERE i.image6 = :image6")})
public class ImageCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Image_Category_ID", nullable = false, length = 30)
    private String imageCategoryID;
    @Size(max = 200)
    @Column(name = "Image_1", length = 200)
    private String image1;
    @Size(max = 200)
    @Column(name = "Image_2", length = 200)
    private String image2;
    @Size(max = 200)
    @Column(name = "Image_3", length = 200)
    private String image3;
    @Size(max = 200)
    @Column(name = "Image_4", length = 200)
    private String image4;
    @Size(max = 200)
    @Column(name = "Image_5", length = 200)
    private String image5;
    @Size(max = 200)
    @Column(name = "Image_6", length = 200)
    private String image6;
    @OneToMany(mappedBy = "imageCategoryID")
    private List<Estate> estateList;

    public ImageCategory() {
    }

    public ImageCategory(String imageCategoryID) {
        this.imageCategoryID = imageCategoryID;
    }

    public String getImageCategoryID() {
        return imageCategoryID;
    }

    public void setImageCategoryID(String imageCategoryID) {
        this.imageCategoryID = imageCategoryID;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getImage6() {
        return image6;
    }

    public void setImage6(String image6) {
        this.image6 = image6;
    }

    @XmlTransient
    public List<Estate> getEstateList() {
        return estateList;
    }

    public void setEstateList(List<Estate> estateList) {
        this.estateList = estateList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageCategoryID != null ? imageCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageCategory)) {
            return false;
        }
        ImageCategory other = (ImageCategory) object;
        if ((this.imageCategoryID == null && other.imageCategoryID != null) || (this.imageCategoryID != null && !this.imageCategoryID.equals(other.imageCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.ImageCategory[ imageCategoryID=" + imageCategoryID + " ]";
    }
    
}

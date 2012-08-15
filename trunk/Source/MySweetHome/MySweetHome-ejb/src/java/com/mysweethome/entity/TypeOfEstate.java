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
@Table(name = "TypeOfEstate", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeOfEstate.findAll", query = "SELECT t FROM TypeOfEstate t"),
    @NamedQuery(name = "TypeOfEstate.findByTypeOfEstateID", query = "SELECT t FROM TypeOfEstate t WHERE t.typeOfEstateID = :typeOfEstateID"),
    @NamedQuery(name = "TypeOfEstate.findByTypeOfEstateName", query = "SELECT t FROM TypeOfEstate t WHERE t.typeOfEstateName = :typeOfEstateName")})
public class TypeOfEstate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TypeOfEstate_ID", nullable = false, length = 30)
    private String typeOfEstateID;
    @Size(max = 200)
    @Column(name = "TypeOfEstate_Name", length = 200)
    private String typeOfEstateName;
    @OneToMany(mappedBy = "typeOfEstateID")
    private List<Estate> estateList;

    public TypeOfEstate() {
    }

    public TypeOfEstate(String typeOfEstateID) {
        this.typeOfEstateID = typeOfEstateID;
    }

    public String getTypeOfEstateID() {
        return typeOfEstateID;
    }

    public void setTypeOfEstateID(String typeOfEstateID) {
        this.typeOfEstateID = typeOfEstateID;
    }

    public String getTypeOfEstateName() {
        return typeOfEstateName;
    }

    public void setTypeOfEstateName(String typeOfEstateName) {
        this.typeOfEstateName = typeOfEstateName;
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
        hash += (typeOfEstateID != null ? typeOfEstateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeOfEstate)) {
            return false;
        }
        TypeOfEstate other = (TypeOfEstate) object;
        if ((this.typeOfEstateID == null && other.typeOfEstateID != null) || (this.typeOfEstateID != null && !this.typeOfEstateID.equals(other.typeOfEstateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.TypeOfEstate[ typeOfEstateID=" + typeOfEstateID + " ]";
    }
    
}

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
@Table(name = "TypeOfMember", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeOfMember.findAll", query = "SELECT t FROM TypeOfMember t"),
    @NamedQuery(name = "TypeOfMember.findByTypeOfMemberID", query = "SELECT t FROM TypeOfMember t WHERE t.typeOfMemberID = :typeOfMemberID"),
    @NamedQuery(name = "TypeOfMember.findByTypeName", query = "SELECT t FROM TypeOfMember t WHERE t.typeName = :typeName")})
public class TypeOfMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TypeOfMemberID", nullable = false, length = 30)
    private String typeOfMemberID;
    @Size(max = 200)
    @Column(name = "TypeName", length = 200)
    private String typeName;
    @OneToMany(mappedBy = "typeOfMemberID")
    private List<Member1> member1List;

    public TypeOfMember() {
    }

    public TypeOfMember(String typeOfMemberID) {
        this.typeOfMemberID = typeOfMemberID;
    }

    public String getTypeOfMemberID() {
        return typeOfMemberID;
    }

    public void setTypeOfMemberID(String typeOfMemberID) {
        this.typeOfMemberID = typeOfMemberID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @XmlTransient
    public List<Member1> getMember1List() {
        return member1List;
    }

    public void setMember1List(List<Member1> member1List) {
        this.member1List = member1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeOfMemberID != null ? typeOfMemberID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeOfMember)) {
            return false;
        }
        TypeOfMember other = (TypeOfMember) object;
        if ((this.typeOfMemberID == null && other.typeOfMemberID != null) || (this.typeOfMemberID != null && !this.typeOfMemberID.equals(other.typeOfMemberID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.TypeOfMember[ typeOfMemberID=" + typeOfMemberID + " ]";
    }
    
}

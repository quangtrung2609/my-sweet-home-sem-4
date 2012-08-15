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
@Table(name = "Contact_Details", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactDetails.findAll", query = "SELECT c FROM ContactDetails c"),
    @NamedQuery(name = "ContactDetails.findByContactDetailsID", query = "SELECT c FROM ContactDetails c WHERE c.contactDetailsID = :contactDetailsID"),
    @NamedQuery(name = "ContactDetails.findByContactName", query = "SELECT c FROM ContactDetails c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "ContactDetails.findByContactAddress", query = "SELECT c FROM ContactDetails c WHERE c.contactAddress = :contactAddress"),
    @NamedQuery(name = "ContactDetails.findByContactEmail", query = "SELECT c FROM ContactDetails c WHERE c.contactEmail = :contactEmail"),
    @NamedQuery(name = "ContactDetails.findByContactTelephone", query = "SELECT c FROM ContactDetails c WHERE c.contactTelephone = :contactTelephone")})
public class ContactDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Contact_Details_ID", nullable = false, length = 30)
    private String contactDetailsID;
    @Size(max = 200)
    @Column(name = "Contact_Name", length = 200)
    private String contactName;
    @Size(max = 200)
    @Column(name = "Contact_Address", length = 200)
    private String contactAddress;
    @Size(max = 100)
    @Column(name = "Contact_Email", length = 100)
    private String contactEmail;
    @Size(max = 50)
    @Column(name = "Contact_Telephone", length = 50)
    private String contactTelephone;
    @OneToMany(mappedBy = "contactDetailsID")
    private List<Estate> estateList;

    public ContactDetails() {
    }

    public ContactDetails(String contactDetailsID) {
        this.contactDetailsID = contactDetailsID;
    }

    public String getContactDetailsID() {
        return contactDetailsID;
    }

    public void setContactDetailsID(String contactDetailsID) {
        this.contactDetailsID = contactDetailsID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
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
        hash += (contactDetailsID != null ? contactDetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactDetails)) {
            return false;
        }
        ContactDetails other = (ContactDetails) object;
        if ((this.contactDetailsID == null && other.contactDetailsID != null) || (this.contactDetailsID != null && !this.contactDetailsID.equals(other.contactDetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.ContactDetails[ contactDetailsID=" + contactDetailsID + " ]";
    }
    
}

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
@Table(name = "Subscribe", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscribe.findAll", query = "SELECT s FROM Subscribe s"),
    @NamedQuery(name = "Subscribe.findBySubscribeID", query = "SELECT s FROM Subscribe s WHERE s.subscribeID = :subscribeID"),
    @NamedQuery(name = "Subscribe.findBySubscribeName", query = "SELECT s FROM Subscribe s WHERE s.subscribeName = :subscribeName"),
    @NamedQuery(name = "Subscribe.findByFeePerDay", query = "SELECT s FROM Subscribe s WHERE s.feePerDay = :feePerDay")})
public class Subscribe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Subscribe_ID", nullable = false, length = 30)
    private String subscribeID;
    @Size(max = 100)
    @Column(name = "Subscribe_Name", length = 100)
    private String subscribeName;
    @Size(max = 20)
    @Column(name = "Fee_Per_Day", length = 20)
    private String feePerDay;
    @OneToMany(mappedBy = "subscribeID")
    private List<Estate> estateList;

    public Subscribe() {
    }

    public Subscribe(String subscribeID) {
        this.subscribeID = subscribeID;
    }

    public String getSubscribeID() {
        return subscribeID;
    }

    public void setSubscribeID(String subscribeID) {
        this.subscribeID = subscribeID;
    }

    public String getSubscribeName() {
        return subscribeName;
    }

    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName;
    }

    public String getFeePerDay() {
        return feePerDay;
    }

    public void setFeePerDay(String feePerDay) {
        this.feePerDay = feePerDay;
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
        hash += (subscribeID != null ? subscribeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscribe)) {
            return false;
        }
        Subscribe other = (Subscribe) object;
        if ((this.subscribeID == null && other.subscribeID != null) || (this.subscribeID != null && !this.subscribeID.equals(other.subscribeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.Subscribe[ subscribeID=" + subscribeID + " ]";
    }
    
}

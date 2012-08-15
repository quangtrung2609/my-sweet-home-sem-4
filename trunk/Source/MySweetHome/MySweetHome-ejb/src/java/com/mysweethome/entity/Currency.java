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
@Table(name = "Currency", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findByCurrencyID", query = "SELECT c FROM Currency c WHERE c.currencyID = :currencyID"),
    @NamedQuery(name = "Currency.findByCurrencyName", query = "SELECT c FROM Currency c WHERE c.currencyName = :currencyName"),
    @NamedQuery(name = "Currency.findByVNDRate", query = "SELECT c FROM Currency c WHERE c.vNDRate = :vNDRate")})
public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Currency_ID", nullable = false, length = 30)
    private String currencyID;
    @Size(max = 200)
    @Column(name = "Currency_Name", length = 200)
    private String currencyName;
    @Size(max = 20)
    @Column(name = "VND_Rate", length = 20)
    private String vNDRate;
    @OneToMany(mappedBy = "currencyID")
    private List<Estate> estateList;

    public Currency() {
    }

    public Currency(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getVNDRate() {
        return vNDRate;
    }

    public void setVNDRate(String vNDRate) {
        this.vNDRate = vNDRate;
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
        hash += (currencyID != null ? currencyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.currencyID == null && other.currencyID != null) || (this.currencyID != null && !this.currencyID.equals(other.currencyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.Currency[ currencyID=" + currencyID + " ]";
    }
    
}

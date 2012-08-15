/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Transaction_Details", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionDetails.findAll", query = "SELECT t FROM TransactionDetails t"),
    @NamedQuery(name = "TransactionDetails.findByTransID", query = "SELECT t FROM TransactionDetails t WHERE t.transID = :transID"),
    @NamedQuery(name = "TransactionDetails.findByTransTime", query = "SELECT t FROM TransactionDetails t WHERE t.transTime = :transTime"),
    @NamedQuery(name = "TransactionDetails.findByTransMoney", query = "SELECT t FROM TransactionDetails t WHERE t.transMoney = :transMoney"),
    @NamedQuery(name = "TransactionDetails.findByTransDetail", query = "SELECT t FROM TransactionDetails t WHERE t.transDetail = :transDetail")})
public class TransactionDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Trans_ID", nullable = false, length = 30)
    private String transID;
    @Size(max = 30)
    @Column(name = "Trans_Time", length = 30)
    private String transTime;
    @Size(max = 30)
    @Column(name = "Trans_Money", length = 30)
    private String transMoney;
    @Size(max = 1073741823)
    @Column(name = "Trans_Detail", length = 1073741823)
    private String transDetail;
    @JoinColumn(name = "UserName", referencedColumnName = "UserName")
    @ManyToOne
    private Member1 userName;

    public TransactionDetails() {
    }

    public TransactionDetails(String transID) {
        this.transID = transID;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(String transMoney) {
        this.transMoney = transMoney;
    }

    public String getTransDetail() {
        return transDetail;
    }

    public void setTransDetail(String transDetail) {
        this.transDetail = transDetail;
    }

    public Member1 getUserName() {
        return userName;
    }

    public void setUserName(Member1 userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transID != null ? transID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionDetails)) {
            return false;
        }
        TransactionDetails other = (TransactionDetails) object;
        if ((this.transID == null && other.transID != null) || (this.transID != null && !this.transID.equals(other.transID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.TransactionDetails[ transID=" + transID + " ]";
    }
    
}

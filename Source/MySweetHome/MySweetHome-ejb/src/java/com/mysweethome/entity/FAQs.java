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
@Table(name = "FAQs", catalog = "MySweetHome", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FAQs.findAll", query = "SELECT f FROM FAQs f"),
    @NamedQuery(name = "FAQs.findByFAQsID", query = "SELECT f FROM FAQs f WHERE f.fAQsID = :fAQsID"),
    @NamedQuery(name = "FAQs.findByQuestion", query = "SELECT f FROM FAQs f WHERE f.question = :question"),
    @NamedQuery(name = "FAQs.findByAnswer", query = "SELECT f FROM FAQs f WHERE f.answer = :answer")})
public class FAQs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FAQs_ID", nullable = false, length = 50)
    private String fAQsID;
    @Size(max = 250)
    @Column(name = "Question", length = 250)
    private String question;
    @Size(max = 1073741823)
    @Column(name = "Answer", length = 1073741823)
    private String answer;

    public FAQs() {
    }

    public FAQs(String fAQsID) {
        this.fAQsID = fAQsID;
    }

    public String getFAQsID() {
        return fAQsID;
    }

    public void setFAQsID(String fAQsID) {
        this.fAQsID = fAQsID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fAQsID != null ? fAQsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FAQs)) {
            return false;
        }
        FAQs other = (FAQs) object;
        if ((this.fAQsID == null && other.fAQsID != null) || (this.fAQsID != null && !this.fAQsID.equals(other.fAQsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysweethome.entity.FAQs[ fAQsID=" + fAQsID + " ]";
    }
    
}

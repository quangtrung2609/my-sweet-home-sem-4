/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Member1;
import com.mysweethome.session.Member1Facade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author LongVu
 */
@ManagedBean(name="MemberMBean")
@SessionScoped
public class MemberMBean {
    @EJB
    private Member1Facade member1Facade;
    private Member1 member;

    public Member1 getMember() {
        return member;
    }

    public void setMember(Member1 member) {
        this.member = member;
    }

    /**
     * Creates a new instance of MemberMBean
     */
    public MemberMBean() {
        member = new Member1();
        member1Facade= new Member1Facade();
    }
    
    
    public boolean insertMember(){
        member.getAddress();
        member.getUserName();
        
        member1Facade.create(member);
        
        
        return true;
    }
}

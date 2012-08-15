/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.Member1;
import com.mysweethome.session.Member1Facade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LongVu
 */
@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {
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
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        member= new Member1();
        member1Facade= new Member1Facade();
    }
    
    public String doLogin() {
        String result = "Login failed";        
        
        String username=member.getUserName();
        String password=member.getPassword();
        
        Member1 mem = member1Facade.getUserName(username);
        if (mem != null) {            
            if (mem.getPassword().equals(password)) {
                FacesContext context = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
                session.setAttribute("user", username);                

                String role= mem.getRole();                                
                session.setAttribute("role", role);
                
                result="Login succesful";
            } else {
                FacesContext face = FacesContext.getCurrentInstance();
                face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password incorect", "<span>Please input Password</span>"));
                result = "Password incorrect";
            }
        } else {
            FacesContext face = FacesContext.getCurrentInstance();
            face.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username incorect", "<span>Please input User Name</span>"));
            result = "Username incorrect";
        }
        return result;
    }
    
    public void doLogout() throws IOException{
        FacesContext faces = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) faces.getExternalContext().getSession(false);
        session.removeAttribute("user");
        session.removeAttribute("role");
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect("../faces/login.xhtml");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.helper;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author PC
 */
public class MailConfig {
    private String email="email";
    private String pass="password";
    
    public static Properties config(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        return props;
    }
    
    public Message createMessage(String from, String to, String subject, String body) throws MessagingException{
        Session session = Session.getDefaultInstance(config(),
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, pass);
                    }
                });
        Message message = null;
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
        } catch (AddressException ex) {
            Logger.getLogger(MailConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    public boolean sendEmail(Message message){
        try {
            Transport.send(message);
            return true;
        } catch (MessagingException ex) {
            Logger.getLogger(MailConfig.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}

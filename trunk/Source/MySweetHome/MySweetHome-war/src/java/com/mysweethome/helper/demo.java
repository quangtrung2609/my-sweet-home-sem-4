/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysweethome.helper.MailConfig;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

/**
 *
 * @author PC
 */
public class demo {
    public static void main(String[] args) {
        try {
            String from="quanghuy9289@gmail.com";
            String to="quanghuy090289@gmail.com";
            String subject="Testing Subject";
            String body="Dear Huy,\n\n Wellcome to my website!";
            MailConfig config=new MailConfig();
            Message message=config.createMessage(from, to, subject, body);
            if(config.sendEmail(message)){
                System.out.println("Done");
            }
            else{
                System.out.println("Failed");
            }
        } catch (MessagingException ex) {
            Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

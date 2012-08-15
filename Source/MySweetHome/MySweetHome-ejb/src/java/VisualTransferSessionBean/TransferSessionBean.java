/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualTransferSessionBean;

import com.mysweethome.entity.Account;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LongVu
 */
@Stateless
@LocalBean
public class TransferSessionBean {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Resource
    private EJBContext context;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Boolean doAuthentication(String acc_number, String password) {
        boolean status=false;
        Account acc= em.find(Account.class, acc_number);
        String pass= acc.getAccountPassword();
        
        if(pass.equals(password)){
            status=true;
        }
        
        return status;
    }

    public String doTransfer(String acc_number, String password, String transferTo, String balance) {
        
        String result = "Transfer failed";
        //check login
        boolean isLogin = doAuthentication(acc_number, password);
        if (isLogin==true) {
            //find "from" account
            Account acc1= em.find(Account.class, acc_number);            
            // find "to" account
            Account acc2 = em.find(Account.class, transferTo);
            if (Double.parseDouble(balance) > Double.parseDouble(acc1.getAccountBalance())) {
                context.setRollbackOnly();
                result = "Your balance is not enough to transfer";
            } else {
                // sub money from account 1
                double credit1 = Double.parseDouble(acc1.getAccountBalance());
                credit1 -= Double.parseDouble(balance);
                acc1.setAccountBalance(String.valueOf(credit1));
                
                persist(acc1);

                // plus money to account cus2
                double credit2 = Double.parseDouble(acc2.getAccountBalance());
                credit2 += Double.parseDouble(balance);
                acc2.setAccountBalance(String.valueOf(credit2));
                
                persist(acc2);

                result = "Transfer successful";
            }
        }else
            result="Login failed";
        
        return result;
    }
    
    
    
}

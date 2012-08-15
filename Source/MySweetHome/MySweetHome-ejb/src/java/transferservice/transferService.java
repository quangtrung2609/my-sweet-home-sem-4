/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transferservice;

import VisualTransferSessionBean.TransferSessionBean;
import com.mysweethome.session.Member1Facade;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author LongVu
 */
@WebService(serviceName = "transferService")
@Stateless()
public class transferService {
    @EJB
    private Member1Facade member1Facade;
    @EJB
    private TransferSessionBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "doTransfer")
    public String doTransfer(@WebParam(name = "acc_number") String acc_number, @WebParam(name = "password") String password, @WebParam(name = "transferTo") String transferTo, @WebParam(name = "balance") String balance) {
        return ejbRef.doTransfer(acc_number, password, transferTo, balance);
    }

    /**
     * Web service operation
     */ 
    
}

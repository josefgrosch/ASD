

package com.addepar.example02;

import com.addepar.asd.ASD;
import com.addepar.asd.ASDMissingValuesException;
import com.addepar.asd.ASDReply;
import com.addepar.asd.ServiceMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josef.grosch
 */
public class Example02 {

    public static void main(String[] args) {
        
        String accountId = "123456789012";
        String clientName = "PicklesUnlimited";
        String clientId   = "666";
        String arcadeName = "Big_Pink.arc";
        String serviceName = "pickles";
        String connectionString = "http://pickles.picklesunlimited.com/"+serviceName;
        
        ServiceMessage sm = new ServiceMessage();
        sm.setAccountId(accountId);
        sm.setClientName(clientName);
        sm.setClientId(clientId);
        sm.setArcadeName(arcadeName);
        sm.setServiceName(serviceName);
        sm.setConnectionString(connectionString);
        
        try {
            ASD asd = new ASD(sm);
            
            ASDReply ascr = asd.registerService(sm);
        } catch (ASDMissingValuesException ex) {
            Logger.getLogger(Example02.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(0);
    }   // End of main
}   // End of class Example02

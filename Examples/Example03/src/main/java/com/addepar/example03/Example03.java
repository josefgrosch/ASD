
package com.addepar.example03;

import com.addepar.asd.ASD;
import com.addepar.asd.ASDMissingValuesException;
import com.addepar.asd.ASDReply;
import com.addepar.asd.ServiceMessage;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josef Grosch < josef.grosch@addepar.com >
 */
public class Example03 {

    public static void main(String[] args) {
        List<String> Services = Arrays.asList("aoatvb2smsdb",      "aoatvb2testdb",
                                              "apilb",             "comp-server",
                                              "factortags",        "iverson",
                                              "maxwell",           "memcache",
                                              "reportgeneration",  "rest-api-global-tasks",
                                              "rest-api-server",   "securitymaster",
                                              "snapshots",         "taxlot-data",
                                              "transactions",      "taxlot");
        
        ServiceMessage sm = new ServiceMessage();

        Iterator<String> serviceIterator = Services.iterator();
        while (serviceIterator.hasNext()) {
            String serviceName = serviceIterator.next();
            String accountId = "123456789012";
            String clientName = "PicklesUnlimited";
            String clientId   = "666";
            String arcadeName = "Big_Pink.arc";
            String connStr  = "http://pickles.picklesunlimited.com/"+serviceName;
            String connectionString = connStr;
        
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
                Logger.getLogger(Example03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(0);
    }   // End of main
}   // End of class Example03

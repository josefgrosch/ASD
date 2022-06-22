
package com.addepar.example04;

import com.addepar.asd.ASD;
import com.addepar.asd.ASDReply;
import com.addepar.asd.ServiceMessage;
import com.addepar.asd.Utility;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program demos how find a registered service
 * 
 * @author Josef Grosch < josef.grosch@addepar.com >
 */
public class Example04 {

    public static void main(String [] args) {
        StringBuilder sb = new StringBuilder();
        Utility u = new Utility();
        
        ServiceMessage sm = u.initTestMessage();
        
        String paraName = sm.getParameterKey();
        paraName = paraName.replace("/service-status.json", "");
        
        ASD asd = new ASD();
        ASDReply asdr = null;
        
        try {
            asdr = asd.getParameterValue(sm);
        } catch (Exception ex) {
            Logger.getLogger(Example04.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String value = asdr.getConnectionString();
        String statusCode = asdr.getStatusCode();
        
        sb.append("The status code returned is : ").append(statusCode);
        sb.append("\n");
        sb.append("The connection string for the service ");
        sb.append(paraName).append(" is ").append(value);
        
        System.out.println(sb.toString());
        
        System.exit(0);
    }   // End of main
}   // End of class Example04

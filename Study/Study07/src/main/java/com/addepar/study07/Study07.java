package com.addepar.study07;

import com.addepar.asd.ASD;
import com.addepar.asd.ASDReply;
import com.addepar.asd.ASDKeyNotFoundException;
import com.addepar.asd.ServiceMessage;
import com.addepar.asd.Utility;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josef.grosch
 */
public class Study07 {

    public static void main(String[] args) {
        int i  = 0;
        ServiceMessage sm = Utility.initTestMessage();
        sm.setArcadeName("little_red.arc");
        sm.updateParameterKey();
        
        String paraName = sm.getParameterKey();
        
        ASD asd = new ASD();
        ASDReply asdr = null;
        
        try {
            asdr = asd.getParameterValue(sm);
        } catch (ASDKeyNotFoundException ex) {
            int j = 0;
            Logger.getLogger(Study07.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String value = asdr.getConnectionString();
        String statusCode = asdr.getStatusCode();
        int queryStatus = asdr.getQueryStatus();
                                                                                                                                                                                                                                                                                                                                                                                                                                                       System.exit(0);;
        System.exit(0);
    }   // End of main
}   // End of Study07
    


package com.addepar.example08;

import com.addepar.asd.ASD;
import com.addepar.asd.ASDReply;
import com.addepar.asd.ServiceMessage;
import com.addepar.asd.Utility;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Demos how to delete a key
 * 
 * @author Josef Grosch < josef.grosch@addepar.com >
 */
public class Example08 {

    public static void main(String [] args) {
        int i = 0;
        
        try {
            ServiceMessage sm = Utility.initTestMessage();
            ASD asd = new ASD(sm);
            
            ASDReply asdr = asd.unregisterService(sm);
            
        }   // End of try block
        catch (Exception ex) {
            Logger.getLogger(Example08.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        System.exit(0);
    }   // End of main
}   // End of class Example08

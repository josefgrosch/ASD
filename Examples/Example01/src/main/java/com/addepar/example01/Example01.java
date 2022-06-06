
package com.addepar.example01;

import com.addepar.asd.ASD;
import com.addepar.asd.ASDMissingValuesException;
import com.addepar.asd.ServiceMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program demostrates how to work with a ServiceMessage. A ServiceMessage
 * is a class that contains the data required to manipulate an AWS Parameter
 * Store key/value pair.
 * 
 * This example shows how to initlize a ServiceMessage.
 * 
 * @author Josef Grosch < josef.grosch@addepar.com >
 */
public class Example01 {

    public static void main(String[] args) {
        //
        // Basic data as Strings
        //
        String accountId = "123456789012";
        String clientName = "PicklesUnlimited";
        String clientId   = "666";
        String arcadeName = "Big_Pink";
        String serviceName = "pickles";
        String connectionString = "http://pickles.picklesunlimited.com";
    
        ServiceMessage sm1 = new ServiceMessage();
        sm1.setAccountId(accountId);
        sm1.setClientName(clientName);
        sm1.setClientId(clientId);
        sm1.setArcadeName(arcadeName);
        sm1.setServiceName(serviceName);
        sm1.setConnectionString(connectionString);
        String json1 = sm1.toJson();
        
        ASD asd1 = new ASD();
        
        try {
            ASD asd2 = new ASD(sm1);
        } catch (ASDMissingValuesException ex) {
            Logger.getLogger(Example01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(0);
    }   // End of main
}   // End of class Example01

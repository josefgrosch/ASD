
package com.addepar.example01;

import com.addepar.asd.ASD;
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

    public static void main(String [] args) {
        //
        // Basic data as Strings
        //
        String accountId = "123456789012";
        String clientName = "PicklesUnlimited";
        String clientId   = "666";
        String arcadeName = "Big_Pink";
        String serviceName = "pickles";
        String connectionString = "http://pickles.picklesunlimited.com";
    
        //com.addepar.asd.ServiceMessage sm1 = new com.addepar.asd.ServiceMessage();
        ServiceMessage sm1 = new ServiceMessage();
        sm1.setAccountId(accountId);
        sm1.setClientName(clientName);
        sm1.setClientId(clientId);
        sm1.setArcadeName(arcadeName);
        sm1.setServiceName(serviceName);
        sm1.setConnectionString(connectionString);
        String json1 = sm1.toJson();
        
        //
        // This is a naked ASD object ie. All the fields are blank
        //
        ASD asd1 = new ASD();
        //String outJson1 = asd1.toJson();
        System.out.println("\nEmpty ASD");
        //System.out.println(outJson1);
        
        //
        // This ASD object has all its fields fully populated by
        // passing it a populted ServiceMessage
        //
        try {
            ASD asd2 = new ASD(sm1);
            String outJson2 = asd2.toJson();
            System.out.println("\nFully populated ASD");
            System.out.println(outJson2);
        } catch (Exception ex) {
            Logger.getLogger(Example01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(0);
    }   // End of main
}   // End of class Example01

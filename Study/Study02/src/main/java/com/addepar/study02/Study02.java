/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.addepar.study02;

import com.addepar.asd.ASD;
import com.addepar.asd.ASDReply;
import com.addepar.asd.ServiceMessage;

/**
 *
 * @author josef.grosch
 */
public class Study02 {

    public static void main(String[] args) {

        ServiceMessage sm = new ServiceMessage();
        
        sm.setAccountId("023960176222");
        sm.setArcadeName("big_bad_john.arc");
        sm.setServiceName("flux_capacitor");
        sm.setConnectionString("http://www.example.com");
        
        ASD asd = new ASD();
        
        ASDReply asdr = asd.registerService(sm);
        
        System.exit(0);
    }
}

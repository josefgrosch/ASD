/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.addepar.study10;

import com.addepar.asd.ServiceMessage;
import com.addepar.asd.Utility;

/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com
 */
public class Study10 {

    public static void main(String[] args) {
        int i = 0;
        
        ServiceMessage sm1 = new ServiceMessage();
        
        ServiceMessage sm2 = Utility.initTestMessage();
        
        String outJson = sm2.toJson();
        System.out.println(outJson);
        
        System.exit(0);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.addepar.study09;

import com.addepar.asd.ServiceMessage;
import com.addepar.asd.Utility;



/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com
 */
public class Study09 {

    public static void main(String[] args) {
        int i  = 0;
        ServiceMessage sm = new ServiceMessage();
        //Utility u = new Utility();
        ServiceMessage sm2 = Utility.initTestMessage();
        
        String outString = sm2.toJson();
        
        System.out.println(outString);
        
        System.exit(0);
    }
}

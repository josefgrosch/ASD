/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.addepar.study13;

import com.addepar.asd.Utility;
import com.amazonaws.regions.Region;

/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com
 */
public class Study13 {

    public static void main(String[] args) {
        Utility u = new Utility();
        Region region = u.determineThisRegion();
        
        System.exit(0);
    }   // End of main
}   // End of class Study13

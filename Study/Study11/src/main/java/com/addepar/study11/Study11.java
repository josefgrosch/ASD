
package com.addepar.study11;

import com.addepar.asd.Common;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com
 */
public class Study11 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //Common com = new Common();
        
        ArrayList al = Common.AWS_REGIONS;
        Iterator it = al.iterator();
        
        while (it.hasNext()) {
            String region = (String) it.next();
            System.out.println("Region : " + region);
        }
        
        System.exit(0);
    }
}



package com.addepar.study12;

import com.addepar.asd.ASD;
import com.addepar.asd.ASDFilter;
import com.addepar.asd.ServiceMessage;
import com.addepar.asd.Utility;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com
 */
public class Study12 {

    public static void main(String[] args) {
        int i = 0;
        
        ServiceMessage sm = Utility.initTestMessage();
        String value = sm.getParameterKey();
        String [] bits = value.split("/");
        int bitsCount = bits.length;
        
        ASDFilter asdf = new ASDFilter(sm);
        
        HashMap hm = asdf.getFilterElements();
        
        ASD asd = new ASD();
        
        //ArrayList al = asd.listAllParameterKeys();
        
        ArrayList al2 = asd.listAllParameterKeysFiltered(asdf);
        
        System.exit(0);
    }   // End of main
}   // End of class Study12

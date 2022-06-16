/**************************************************************************
**
**                             < ASDReply.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : ASDReply.java
**
**  Author       : Addepar Infrastructure Platform Tools Team 
**                          
**  Date         : 31 May 2022
**
**  Version      : 1.0
**
**  Modification : Some
**
**  Application  :
**
**  Functions    :
**
**  Description  :
**
**  Notes        :
**
**
**************************************************************************/


/**************************************************************************
**
**                               Copyright
**
**                   (C) Copyright 2022 Addepar, Inc.
**                         <iptools@addepar.com>
**
**                          All Rights Reserved
**
**************************************************************************/


/**************************************************************************
**
**                                Package
**
**************************************************************************/
package com.addepar.asd;


/**************************************************************************
**
**                                Imports
**
**************************************************************************/
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com 
 */
public class Utility {
    
    /**
     * 
     * @return 
     */
    public static ServiceMessage initTestMessage() {
        String accountId = "123456789012";
        String clientName = "PicklesUnlimited";
        String clientId   = "666";
        String arcadeName = "Big_Pink.arc";
        String serviceName = "memcache";
        String connectionString = "http://pickles.picklesunlimited.com";
    
        ServiceMessage sm1 = new ServiceMessage();
        sm1.setAccountId(accountId);
        sm1.setClientName(clientName);
        sm1.setClientId(clientId);
        sm1.setArcadeName(arcadeName);
        sm1.setServiceName(serviceName);
        sm1.setConnectionString(connectionString);
        
        String pKey = Common.genParameterKey(sm1);
        sm1.setParameterKey(pKey);
        
        return sm1;
    }   // End of initTestMessage
     
    /**
     * 
     * @param fileName
     * @return
     * @throws URISyntaxException 
     */
    public File getFileFromResource(String fileName) 
            throws URISyntaxException {

        File fObj = null;
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            fObj = new File(resource.toURI());
        }
        
        return fObj;
    }   // End of getFileFromResource
}


/**************************************************************************
**
**                          < End of ASDReply.java >
**
**************************************************************************/

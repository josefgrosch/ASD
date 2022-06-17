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
 * @author Josef Grosch (josef.grosch@addepar.com)
 */
public class Utility {
    
    /**
     * 
     * The method <b>initTestMessage</b> creates and populates a 
     * {@link com.addepar.asd.ServiceMessage ServiceMessage} with know dummy 
     * data for the purpose of testing.
     * 
     * @return A ServiceMessage fully populated with dummy test data. 
     */
    public static ServiceMessage initTestMessage() {
        String accountId = "123456789012";
        String clientName = "PicklesUnlimited";
        String clientId   = "666";
        String arcadeName = "Big_Pink.arc";
        String serviceName = "memcache";
        String serviceStatus = "dead";
        String connectionString = "http://pickles.picklesunlimited.com";
    
        ServiceMessage sm = new ServiceMessage();
        sm.setAccountId(accountId);
        sm.setClientName(clientName);
        sm.setClientId(clientId);
        sm.setArcadeName(arcadeName);
        sm.setServiceName(serviceName);
        sm.setServiceStatus(serviceStatus);
        
        sm.setConnectionString(connectionString);
        
        String pKey = Common.genParameterKey(sm);
        sm.setParameterKey(pKey);
        
        return sm;
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

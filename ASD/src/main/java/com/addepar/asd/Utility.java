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


/**
 *
 * @author Josef Grosch < josef.grosch@addepar.com >
 */
public class Utility {
    
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
    }
}


/**************************************************************************
**
**                          < End of ASDReply.java >
**
**************************************************************************/

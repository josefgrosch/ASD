/**************************************************************************
**
**                             < ServiceMessage.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : ServiceMessage.java
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
 * @author josef.grosch
 */
public class ServiceMessage {

    private String serviceName = "";
    
    private boolean register = false;
    
    private boolean deregister = false;
    
    private boolean locate = false;
    
    private boolean status = false;
    
    private String arcadeName = "";
    
    /**
     * 
     */
    public ServiceMessage() {
        super();
    }
    
    /**
     * 
     * @param serviceName
     * @param arcadeName
     * @param register
     * @param deregister
     * @param locate 
     */
    public ServiceMessage(
            String  serviceName,
            String  arcadeName,
            boolean register,
            boolean deregister,
            boolean locate) {
        
        this();
        
        this.serviceName = serviceName;
        this.arcadeName  = arcadeName;
        this.register    = register;
        this.deregister  = deregister;
        this.locate      = locate;
    }
}   // End of class ServiceMessage


/**************************************************************************
**
**                          < End of ServiceMessage.java >
**
**************************************************************************/

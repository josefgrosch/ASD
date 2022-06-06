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
import software.amazon.awssdk.services.ssm.model.PutParameterResponse;


/**
 *
 * @author Josef Grosch < josef.grosch@addepar.com >
 */
public class ASDReply {
    
    /**
     * 
     */
    private PutParameterResponse ppr = null;
    
    /**
     * 
     */
    public ASDReply() {
        super();
    }   // End of default class constructor
    
    /**
     * 
     * @param ppr 
     */
    public ASDReply(PutParameterResponse ppr) {
        this();
        
        this.ppr = ppr;
    }   // End of class constructor - PutParameterResponse
    
    //
    // Get methods
    //
    
    /**
     * 
     * @return 
     */
    public PutParameterResponse getPprResponse() {
        return this.ppr;
    }
    
    //
    // Set methods
    //
    
    /**
     * 
     * @param ppr 
     */
    public void setPprResponse(PutParameterResponse ppr) {
        this.ppr = ppr;
    }
}   // End of class


/**************************************************************************
**
**                          < End of ASDReply.java >
**
**************************************************************************/

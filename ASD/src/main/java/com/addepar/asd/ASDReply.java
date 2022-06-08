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
import software.amazon.awssdk.services.ssm.model.SsmResponseMetadata;
import software.amazon.awssdk.http.*;


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
    private SsmResponseMetadata rm = null;
    
    /**
     * 
     */
    private SdkHttpFullResponse ht = null;

    /**
     * 
     */
    private String connStr = "";
    
    /**
     * 
     */
    private String statusCode = "";
    
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
    
    /**
     * 
     * @return 
     */
    public SsmResponseMetadata getResponseMetadata() {
        return this.rm;
    }

    /**
     * 
     * @return 
     */
    private SdkHttpFullResponse getFullResponse() {
        return this.ht;
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

    /**
     * 
     * @param rm 
     */
    public void setResponseMetadate(SsmResponseMetadata rm) {
        this.rm = rm;
    }

    /**
     * 
     * @param ht 
     */
    public void setFullResponse(SdkHttpFullResponse ht) {
        this.ht = ht;
    }

}   // End of class


/**************************************************************************
**
**                          < End of ASDReply.java >
**
**************************************************************************/

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
**  Version      : 0.0.1
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
 * @author Josef Grosch (josef.grosch@addepar.com)
<<<<<<< HEAD
=======
 * @version 0.0.1
>>>>>>> dev
 */
public class ASDReply {
    
    /**
     * 
     */
    private PutParameterResponse ppr = null;

    /**
     * 
     */
    private SsmResponseMetadata responseMetadata = null;
    
    /**
     * 
     */
    private SdkHttpFullResponse fullResponse = null;

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
    private String msg = "";
    
    /**
     * 
     */
    private String key = "";
    
    /**
     * 
     */
    private int queryStatus = Common.OK;
    
    //
    // Constructors
    //
    
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
        return this.responseMetadata;
    }

    /**
     * 
     * @return 
     */
    public SdkHttpFullResponse getFullResponse() {
        return this.fullResponse;
    }

    /**
     * 
     * @return 
     */
    public String getConnectionString() {
        return this.connStr;
    }
    
    /**
     * 
     * @return 
     */
    public String getStatusCode() {
        return this.statusCode;
    }
    
    /**
     * 
     * @return 
     */
    public String getMsg() {
        return this.msg;
    }
    
    /**
     * 
     * @return 
     */
    public String getKey() {
        return this.key;
    }
    
    /**
     * 
     * @return 
     */
    public int getQueryStatus() {
        return this.queryStatus;
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
        this.responseMetadata = rm;
    }

    /**
     * 
     * @param fr
     */
    public void setFullResponse(SdkHttpFullResponse fr) {
        this.fullResponse = fr;
    }

    /**
     * 
     * @param connStr 
     */
    public void setConnectionString(String connStr) {
        this.connStr = connStr;
    }
    
    /**
     * 
     * @param statusCode 
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    
    /**
     * 
     * @param msg 
     */
    public void setMsg(String msg) {
        this.msg = msg;
        
    }

    /**
     * 
     * @param key 
     */
    public void setKey(String key) {
        this.key = key;
    }
    
    /**
     * 
     * @param queryStatus 
     */
    public void setQueryStatus(int queryStatus) {
        this.queryStatus = queryStatus;
    }
}   // End of class


/**************************************************************************
**
**                          < End of ASDReply.java >
**
**************************************************************************/

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
import org.json.JSONException;
import org.json.JSONObject;

// ASD/023960176222/joes_pretty_good_ISP/dead_sky.arc/iverson.json
// ASD/\<AWS account ID\>/\<client\>/\<arcade\>/\<service\>.json

/**
 * 
 * 
 * 
 * @author Josef Grosch < josef.grosch@addepar.com >
 */
public class ServiceMessage {
   

    /**
     * 
     */
    private String accountId = "";
    
    /**
     * 
     */
    private String clientName = "";
    
    /**
     * 
     */
    private String clientId   = "";
    
    /**
     * 
     */
    private String arcadeName = "";
    
    /**
     * 
     */
    private String serviceName = "";
    
    /**
     * 
     */
    private String connectionString = "";
    
    /**
     * 
     */
    private String parameterKey = "";

    /**
     * 
     */
    private boolean serviceStatus = false;
    
    
    //
    // Constructor methods
    //
    
    /**
     * 
     */
    public ServiceMessage() {
        super();
    }   // End of default constructor
    
    /**
     * 
     * @param accountId
     * @param clientName
     * @param arcadeName
     * @param serviceName
     */
    public ServiceMessage(
            String accountId,
            String clientName,
            String arcadeName,
            String serviceName) {
        
        this();
        
        this.accountId   = accountId;
        this.clientName  = clientName;
        this.arcadeName  = arcadeName;
        this.serviceName = serviceName;
        
    }   // End of constructor - parameter

    /**
     * 
     * @param sm 
     */
    public ServiceMessage(ServiceMessage sm) {
        this();
        
        this.accountId   = sm.getAccountId();
        this.clientName  = sm.getClientName();
        this.arcadeName  = sm.getArcadeName();
        this.serviceName = sm.getServiceName();
        
    }   // End of constructor - ServiceMessage
    
    /**
     * 
     * @param jObj 
     */
    public ServiceMessage(JSONObject jObj) {
        this();
        
        try {
            this.accountId   = jObj.getString("account_id");
            this.clientName  = jObj.getString("client_name");
            this.arcadeName  = jObj.getString("arcade_name");
            this.serviceName = jObj.getString("service_name");
        }
        catch(JSONException ex) {
            System.out.println(ex);
        }
    }   // End of constructor - json
    
    //
    // Get methods
    // 
    
    /**
     * 
     * @return 
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * 
     * @return 
     */
    public String getClientName() {
        return this.clientName;
    }
    
    /**
     * 
     * @return 
     */
    public String getClientId() {
        return this.clientId;
    }
    
    /**
     * 
     * @return 
     */
    public String getArcadeName() {
        return this.arcadeName;
    }

    /**
     * 
     * @return 
     */
    public String getServiceName() {
        return this.serviceName;
    }

    /**
     * 
     * @return 
     */
    public String getConnectionString() {
        return this.connectionString;
    }

    /**
     * 
     * @return 
     */
    public String getParameterKey() {
        if (parameterKey.length() == 0) {
            this.parameterKey = Common.genParameterKey(this);
        }
        
        return this.parameterKey;
    }

    /**
     * 
     * @return 
     */
    public boolean getServiceStatus() {
        return this.serviceStatus;
    }

    
    //
    // Set methods
    //
    
    /**
     * 
     * @param accountId 
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * 
     * @param clientName 
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    /**
     * 
     * @param clientId 
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    /**
     * 
     * @param arcadeName 
     */
    public void setArcadeName(String arcadeName) {
        this.arcadeName = arcadeName;
    }

    /**
     * 
     * @param serviceName 
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * 
     * @param connString 
     */
    public void setConnectionString(String connString) {
        this.connectionString = connString;
    }
    
    /**
     * 
     * @param status 
     */
    public void setServiceStatus(boolean status) {
        this.serviceStatus = status;
    }

    //
    // 
    //
    
    /**
     * 
     * @return 
     */
    public String toJson() {
        
        return Common.toJson(this);
    }
}   // End of class ServiceMessage


/**************************************************************************
**
**                          < End of ServiceMessage.java >
**
**************************************************************************/

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
import org.json.JSONException;
import org.json.JSONObject;
import com.addepar.asd.Common;


/**
 * 
 * Key Scheme<br>
 * 
 * /ASD/[AWS account ID]/[client]/[arcade]/[service]/service_status.json<p>
 * 
 * Key Example<br>
 * 
 * /ASD/123456789/pickles_unlimited/big_pink.arc.arc/iverson/service_status.json<p>
 * 
 * 
 * @author Josef Grosch (josef.grosch@addepar.com)
<<<<<<< HEAD
=======
 * @version 0.0.1
>>>>>>> dev
 */
public class ServiceMessage {
   

    /**
     * 
     * The field <b>accountId</b> is used to contain the AWS account ID. This
     * field is mandatory.
     */
    private String accountId = "";
    
    /**
     * 
     * The field <b>clientName</b> is the short client name. The name should
     * be lowercase ASCII with only - or _ between words. This field is 
     * mandatory.
     */
    private String clientName = "";
    
    /**
     * 
     * The field <b>clientId</b> is Addepars internal client Id. This field is
     * optional and not really used.
     */
    private String clientId   = "";
    
    /**
     * 
     * The field <b>arcadeName</b> is the Arcade Name. This field is mandatory.
     */
    private String arcadeName = "";
    
    /**
     * 
     * The field <b>serviceName</b> is the name of the service. This field 
     * is mandatory.
     */
    private String serviceName = "";
    
    /**
     * 
     * The field <b>connectionString</b> is the URL that is used to connect to
     * the service running on a container. This field is mandatory.
     */
    private String connectionString = "";
    
    /**
     * 
     */
    private String parameterKey = "";

    /**
     * 
     */
    private String serviceStatus = "";
    
    /**
     * 
     */
    private int queryStatus = Common.OK;
    
    /**
     * 
     */
    private boolean serviceRegistered = false;
    
    /**
     * 
     */
    private String msg = "";
    
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
     * @param serviceStatus
     */
    public ServiceMessage(
            String accountId,
            String clientName,
            String arcadeName,
            String serviceName,
            String serviceStatus) {
        
        this();
        
        this.accountId     = accountId;
        this.clientName    = clientName;
        this.arcadeName    = arcadeName;
        this.serviceName   = serviceName;
        this.serviceStatus = serviceStatus;
        
        this.addParameterKey(this.accountId, 
                             this.clientName, 
                             this.arcadeName, 
                             this.serviceName);
    }   // End of constructor - parameter

    /**
     * 
     * @param sm 
     */
    public ServiceMessage(ServiceMessage sm) {
        this();
        
        this.accountId     = sm.getAccountId();
        this.clientName    = sm.getClientName();
        this.arcadeName    = sm.getArcadeName();
        this.serviceName   = sm.getServiceName();
        this.serviceStatus = sm.getServiceStatus();
        
        this.addParameterKey(this.accountId, 
                             this.clientName, 
                             this.arcadeName, 
                             this.serviceName);
    }   // End of constructor - ServiceMessage
    
    /**
     * 
     * @param jObj 
     */
    public ServiceMessage(JSONObject jObj) {
        this();
        
        try {
            this.accountId     = jObj.getString("account_id");
            this.clientName    = jObj.getString("client_name");
            this.arcadeName    = jObj.getString("arcade_name");
            this.serviceName   = jObj.getString("service_name");
            this.serviceStatus = jObj.getString("service_status");
            
            this.addParameterKey(this.accountId, 
                                 this.clientName, 
                                 this.arcadeName, 
                                 this.serviceName);
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
            this.parameterKey = Utility.genParameterKey(this);
        }
        
        return this.parameterKey;
    }

    /**
     * 
     * @return 
     */
    public String getServiceStatus() {
        return this.serviceStatus;
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
    public int getQueryStatus() {
        return this.queryStatus;
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
    public void setServiceStatus(String status) {
        this.serviceStatus = status;
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
     * @param parameterKey 
     */
    public void setParameterKey(String parameterKey) {
        this.parameterKey = parameterKey;
    }
    
    /**
     * 
     * @param queryStatus 
     */
    public void setQueryStatus(int queryStatus) {
        this.queryStatus = queryStatus;
    }
    
    //
    // 
    //
    
    /**
     * 
     * @return 
     */
    public String toJson() {
        return Utility.toJson(this);
    }   // End of toJson
    
    /**
     * 
     * @param accountId
     * @param clientName
     * @param arcadeName
     * @param serviceName 
     */
    private void addParameterKey(String accountId,
                                 String clientName,
                                 String arcadeName,
                                 String serviceName) {
        this.parameterKey = Utility.genParameterKey(accountId,
                                                   clientName,
                                                   arcadeName,
                                                   serviceName);
    }   // End of addParameterKey
    
    public void updateParameterKey() {
        this.setParameterKey(Utility.genParameterKey(this));
    }
}   // End of class ServiceMessage


/**************************************************************************
**
**                          < End of ServiceMessage.java >
**
**************************************************************************/

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
import org.json.JSONObject;


/**
 *
 * @author Bob Dobbs
 */
public class ServiceMessage {
    // ASD/023960176222/joes_pretty_good_ISP/dead_sky.arc/iverson.json
    // ASD/<AWS account ID>/<client>/<arcade>/<service>.json

    /*

      {
      "account_name": "",
      "arcade_name": "",
      "service_name": "",
      "connection_string":"",
      "register_service":"",
      "unregister_service":"",
      "locate_service": "",
      "service_status":""
      }

     */
    
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
     * @param serviceName
     * @param arcadeName
     * @param registerService 
     * @param unregisterService 
     * @param locateService 
     */
    public ServiceMessage(
            String  serviceName,
            String  arcadeName,
            boolean registerService,
            boolean unregisterService,
            boolean locateService) {
        
        this();
        
        this.serviceName        = serviceName;
        this.arcadeName         = arcadeName;
        
    }   // End of constructor

    /**
     * 
     * @param sm 
     */
    public ServiceMessage(ServiceMessage sm) {
        this();
        
        this.serviceName        = sm.getServiceName();
        this.arcadeName         = sm.getArcadeName();
        
    }   // End of constructor
    
    /**
     * 
     * @param jStr 
     */
    //public ServiceMessage(String jStr) {
    //    this();
    //}
    
    /**
     * 
     * @param jObj 
     */
    public ServiceMessage(JSONObject jObj) {
        this();
    }
    
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
    public void setAccountName(String accountId) {
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

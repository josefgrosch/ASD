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
 * @author Bob Dobbs
 */
public class ServiceMessage {
    // ASD/023960176222/dead_sky.arc/iverson.json
    // ASD/<account>/<arcade>/<service>.json

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
    private String accountName = "";
    
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
    private boolean registerService = false;
    
    /**
     * 
     */
    private boolean unregisterService = false;
    
    /**
     * 
     */
    private boolean locateService = false;
    
    /**
     * 
     */
    private boolean serviceStatus = false;
    
    
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
        this.registerService    = registerService;
        this.unregisterService  = unregisterService;
        this.locateService      = locateService;
    }   // End of constructor

    /**
     * 
     * @param sm 
     */
    public ServiceMessage(ServiceMessage sm) {
            
        this();
        
        this.serviceName        = sm.getServiceName();
        this.arcadeName         = sm.getArcadeName();
        this.registerService    = sm.getRegisterService();
        this.unregisterService  = sm.getUnregisterService();
        this.locateService      = sm.getLocateService();
    }   // End of constructor
    
    //
    // Get
    // 
    
    /**
     * 
     * @return 
     */
    public String getAccountName() {
        return this.accountName;
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
    public boolean getRegisterService() {
        return this.registerService;
    }

    /**
     * 
     * @return 
     */
    public boolean getUnregisterService() {
        return this.unregisterService;
    }

    /**
     * 
     * @return 
     */
    public boolean getLocateService() {
        return this.locateService;
    }

    /**
     * 
     * @return 
     */
    public boolean getServiceStatus() {
        return this.serviceStatus;
    }

    //
    // Set
    //
    
    /**
     * 
     * @param accountName 
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
     * @param register 
     */
    public void setRegisterService(boolean register) {
        this.registerService = register;
    }

    /**
     * 
     * @param unregister 
     */
    public void setUnregisterService(boolean unregister) {
        this.unregisterService = unregister;
    }

    /**
     * 
     * @param locate 
     */
    public void setLocateService(boolean locate) {
        this.locateService = locate;
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

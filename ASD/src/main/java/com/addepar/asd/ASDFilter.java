
/**************************************************************************
**
**                          < ASDFilter.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : ASDFilter.java
**
**  Author       : Addepar Infrastructure Platform Tools Team 
**                          
**  Date         : 19 Jun 2022
**
**  Version      : 0.0.1
**
**  Modification : 
**
**  Application  :
**
**  Functions    :
**
**  Description  :
**
**  Notes        : This is a template for class files
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

import java.util.HashMap;
import org.json.JSONObject;



/**************************************************************************
**
**                                Imports
**
**************************************************************************/

/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com
 */
public class ASDFilter {

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
     */
    private HashMap <String, String> filterElements = null;
    
    /**
     * 
     */
    public ASDFilter() {
        super();
        
        this.filterElements = new HashMap<>();
    }
    
    /**
     * 
     * @param sm 
     */
    public ASDFilter(ServiceMessage sm) {
        this();
        
        this.accountId   = sm.getAccountId();
        this.clientName  = sm.getClientName();
        this.arcadeName  = sm.getArcadeName();
        this.serviceName = sm.getServiceName();
        
        buildElementMap();
    }   // End of constructor - ServiceMessage
    
    /**
     * 
     * @param jObj 
     */
    public ASDFilter(JSONObject jObj) {
        this();
        
        this.accountId   = jObj.getString("account_id");
        this.clientName  = jObj.getString("client_name");
        this.arcadeName  = jObj.getString("arcade_name");
        this.serviceName = jObj.getString("service_name");
        
        buildElementMap();
    }   // End of constructor - JSONObject
    
    /**
     * 
     * @param parameterKey 
     */
    public ASDFilter(String parameterKey) {
        this();
        
        buildElementMap();
    }   // End of constructor
    
    /**
     * 
     * @param accountId
     * @param clientName
     * @param arcadeName
     * @param serviceName 
     */
    public ASDFilter(String accountId,
                     String clientName,
                     String arcadeName,
                     String serviceName) {
        this();
        
        this.accountId   = accountId;
        this.clientName  = clientName;
        this.arcadeName  = arcadeName;
        this.serviceName = serviceName;
        
        buildElementMap();
    }   // End of constructor - parameters
    
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
    public HashMap getFilterElements() {
        return this.filterElements;
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

    //
    // Methods
    //
    
    /**
     * 
     */
    private void buildElementMap() {

        // Acount ID
        if (this.accountId.length() > 0) {
            filterElements.put("account_id", this.accountId);
        }
        
        // ArcadeName
        if (this.arcadeName.length() > 0) {
            filterElements.put("arcade_name", this.arcadeName);
        }
        
        // Client Name
        if (this.clientName.length() > 0) {
            filterElements.put("client_name", this.clientName);
        }
        
        // Service Name
        if (this.serviceName.length() > 0) {
            filterElements.put("service_Name", this.serviceName);
        }
        
    }   // End of genSearchFilter
}   // End of Class ASDFilter


/**************************************************************************
**
**                       < End of ASDFilter.java >
**
**************************************************************************/



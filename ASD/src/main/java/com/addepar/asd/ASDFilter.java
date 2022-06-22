
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


/**************************************************************************
**
**                                Imports
**
**************************************************************************/
import java.util.HashMap;
import org.json.JSONObject;


/**
 *
 * This class is used to filter out the parameter records from those 
 * contained in the ArrayList returned from the parameter store query. 
 * A ASDFilter that has no fields filled in yeilds all parameters that 
 * start with ASD.

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
    private int filterCount = 0;

    /**
     * 
     */
    public ASDFilter() {
        super();
        
        this.filterElements = new HashMap<>();
    }   // End of base constructor
    
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
        
        String [] bits = parameterKey.split("/");
        int bitsCount = bits.length;
        if (bitsCount == Common.FIELD_COUNT) {
            this.accountId   = bits[Common.ACCOUNT_FIELD];
            this.clientName  = bits[Common.CO_NAME_FIELD];
            this.arcadeName  = bits[Common.ARCADE_FIELD];
            this.serviceName = bits[Common.SERVICE_FIELD];
            
            buildElementMap();
        }   // End of if block
    }   // End of constructor - String
    
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

    public int getFilterCount() {
        return this.filterCount;
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
            this.filterCount++;
        }
        
        // ArcadeName
        if (this.arcadeName.length() > 0) {
            filterElements.put("arcade_name", this.arcadeName);
            this.filterCount++;
        }
        
        // Client Name
        if (this.clientName.length() > 0) {
            filterElements.put("client_name", this.clientName);
            this.filterCount++;
        }
        
        // Service Name
        if (this.serviceName.length() > 0) {
            filterElements.put("service_Name", this.serviceName);
            this.filterCount++;
        }
    }   // End of genSearchFilter
}   // End of Class ASDFilter


/**************************************************************************
**
**                       < End of ASDFilter.java >
**
**************************************************************************/



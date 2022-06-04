/**************************************************************************
**
**                             < ASD.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : ASD.java
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
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.PutParameterRequest;
import software.amazon.awssdk.services.ssm.model.PutParameterResponse;


/**
 *
 * @author Bob Dobbs <bob.dobbs@addepar.com>
 * @version 0.1
 */
public class ASD {
    /**
     * The <b>accountId</b> is the AWS account ID.
     */
    private String accountId   = "";
    
    /**
     * The <b>clientName</b> is the name of Addepar's client.
     */
    private String clientName  = "";

    /**
     * The <b>clientId</b> is the client's ID as assigned by Addepar.
     */
    private String clientId    = "";
    
    /**
     * The <b>arcadeName</b> is the name of the arcade the clients
     * services are running in.
     */
    private String arcadeName  = "";
    
    /**
     * The <b>defaultRegion</b> is the AWS region the arcade is running in.
     */
    private String defaultRegion = "";
    
    //
    // Constructors
    //
    
    /**
     * 
     */
    public ASD() {
        super();
        
        this.arcadeName = System.getenv("ARCADE_NAME");
        if (this.arcadeName == null || this.arcadeName.length() == 0) {
            this.arcadeName = Common.DEFAULT_REGION;
        }
        
        this.defaultRegion = System.getenv("DEFAULT_REGION");
        if (this.defaultRegion == null || this.defaultRegion.length() == 0) {
            this.defaultRegion = Common.DEFAULT_REGION;
        }
        
        System.setProperty("aws.region", this.defaultRegion);
        
    }   // End of default class constructor
    
    /**
     * 
     * @param sm 
     */
    public ASD(ServiceMessage sm) {
        this();
        
        this.accountId  = sm.getAccountId();
        this.arcadeName = sm.getServiceName();
    }   // End of class constuctor with a ServiceMessage
    
    /**
     * 
     * @param arcadeName 
     */
    public ASD(String arcadeName) {
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
    public String getDefaultRegion() {
        return this.defaultRegion;
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
     * @param defaultRegion 
     */
    public void setDefaultRegion(String defaultRegion) {
        this.defaultRegion = defaultRegion;
    }

    //
    // General Methods
    //
    
    /**
     * 
     * @return 
     */
    public ASDReply registerService() {
        ASDReply ar = new ASDReply();
        
        return ar;
    }   // End of registerService
    
    /**
     * 
     * @param sm
     * @return
     * @throws AwsServiceException
     * @throws SdkClientException 
     */
    public ASDReply registerService(ServiceMessage sm) 
        throws AwsServiceException, SdkClientException {
        boolean debug = true;
        ASDReply ar = new ASDReply();
        
        String key = Common.genParameterKey(sm);
        
        
        //String key = sb.toString();
        String value = sm.toJson();
        
        /*
         * TODO - figure out how to take a region string, "us_east_2"
         * and get Region.US_EAST_2
         *
         * Region region = new Region();
         */
        
        SsmClient ssmClient = SsmClient.builder().region(Region.US_EAST_2).build();
        
        PutParameterRequest pr = PutParameterRequest.builder()
                .value(value) 
                .name(key)
                .type("String")
                .dataType("text")
                .overwrite(true)
                .build();
            
        PutParameterResponse ppr = ssmClient.putParameter(pr);  
        
        if (debug) {
            System.out.println(ppr.toString());
        }
        
        ar.setPprResponse(ppr);
        
        return ar;
    }   // End of registerService
    
    /**
     * 
     * @param sm
     * @return 
     */
    public ASDReply unregisterService(ServiceMessage sm) {
        ASDReply ar = new ASDReply();
        
        return ar;
    }   // End of unregisterService
    
    /**
     * 
     * @param sm
     * @return 
     */
    public ASDReply locateService(ServiceMessage sm) {
        ASDReply ar = new ASDReply();
        
        return ar;
    }   // End of locateService
    
    /**
     * 
     * @param sm
     * @return 
     */
    public String getAllRegistedServices(ServiceMessage sm) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("/ASD/");
        sb.append(sm.getAccountId()).append("/");
        sb.append(sm.getArcadeName()).append("/");
        
        String baseArcadeName = sb.toString();
        
        return sb.toString();
    }   // End of getAllRegisteredServices
}   // End of class ASD


/**************************************************************************
**
**                          < End of ASD.java >
**
**************************************************************************/

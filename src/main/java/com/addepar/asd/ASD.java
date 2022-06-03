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

import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.PutParameterRequest;
import software.amazon.awssdk.services.ssm.model.PutParameterResponse;


/**************************************************************************
**
**                                Imports
**
**************************************************************************/


/**
 *
 * @author Bob Dobbs
 */
public class ASD {
    /**
     * The <b>accountName</b> is the AWS 
     */
    private String accountId   = "";
    
    /**
     * 
     */
    private String arcadeName    = "";
    
    /**
     * 
     */
    private String defaultRegion = "";
    
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
    
    /**
     * 
     * @return 
     */
    public String getDefaultRegion() {
        return this.defaultRegion;
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
    public String getAccountId() {
        return this.accountId;
    }
    
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
        StringBuilder sb = new StringBuilder();
                
        sb.append("/ASD/");
        sb.append(sm.getAccountId()).append("/");
        sb.append(sm.getArcadeName()).append("/");
        sb.append(sm.getServiceName()).append("/service-status.json");
        String key = sb.toString();
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
    
    /*
Region region = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        getParaValue(ssmClient, paraName);
        ssmClient.close();
    }

    public static void getParaValue(SsmClient ssmClient, String paraName) {

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name(paraName)
                .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
            System.out.println("The parameter value is "+parameterResponse.parameter().value());

        } catch (SsmException e) {
        System.err.println(e.getMessage());
        System.exit(1);
        }
   }
}
    */
}   // End of class ASD


/**************************************************************************
**
**                          < End of ASD.java >
**
**************************************************************************/

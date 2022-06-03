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

    private String arcadeName     = "";
    private String defaultRegion = "";
    
    /**
     * 
     */
    public ASD() {
        super();
        /*
        this.arcadeName = System.getenv("ARCADE_NAME");
        this.defaultRegion = System.getenv("DEFAULT_REGION");
        if (this.defaultRegion == null || this.defaultRegion.isEmpty()) {
            this.defaultRegion = System.getenv("AWS_DEFAULT_REGION");
        }
        
        if (this.arcadeName.isEmpty()) {
            this.arcadeName = this.defaultRegion;
        }
        
        System.setProperty("aws.region", this.defaultRegion);
        */
    }   // End of default constructor
    
    /*
    public void getServiceMessage(ServiceMessage sm) {
        boolean action = sm.getLocateService();
    }
    */
    
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
     * @param sm
     * @return
     * @throws AwsServiceException
     * @throws SdkClientException 
     */
    public ASDReply register(ServiceMessage sm) 
        throws AwsServiceException, SdkClientException {
        ASDReply ar = new ASDReply();
        StringBuilder sb = new StringBuilder();
                
        sb.append("/ASD/");
        sb.append(sm.getAccountName()).append("/");
        sb.append(sm.getArcadeName()).append("/");
        sb.append(sm.getServiceName()).append("/service-status.json");
        String key = sb.toString();
        String value = sm.toJson();
        
        //Region region = new Region();
        
        
        SsmClient ssmClient = SsmClient.builder().region(Region.US_EAST_2).build();
        
        PutParameterRequest pr = PutParameterRequest.builder()
                .value(value) 
                .name(key)
                .type("String")
                .dataType("text")
                .overwrite(true)
                .build();
            
        PutParameterResponse ppr = ssmClient.putParameter(pr);    
        ar.setPprResponse(ppr);
        
        return ar;
    }   // End of register
    
    /**
     * 
     * @param sm
     * @return 
     */
    public ASDReply unregister(ServiceMessage sm) {
        ASDReply ar = new ASDReply();
        
        return ar;
    }
    
    /**
     * 
     * @param sm
     * @return 
     */
    public ASDReply locate(ServiceMessage sm) {
        ASDReply ar = new ASDReply();
        
        return ar;
    }
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

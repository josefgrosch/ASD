/**************************************************************************
**
**                             < Common.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : Common.java
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
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.DescribeParametersRequest;
import software.amazon.awssdk.services.ssm.model.DescribeParametersResponse;
import software.amazon.awssdk.services.ssm.model.ParameterMetadata;
import software.amazon.awssdk.services.ssm.model.SsmException;


/**
 *
 * @author Josef Grosch (josef.grosch@addepar.com)
 */
public class Common {
    /**
     * 
     *  The <b>DEFAULT_REGION</b> is the default AWS region. This region
     * is used when we fail to find AWS_REGION and/or DEFAULT_REGION in
     * the shell environment.
     */
    public final static String DEFAULT_REGION = "us_east_2";
    
    /**
     * 
     * This static field defines a return value that designates a
     * successful return.
     */
    public final static int OK        = 0; // It all worked out
    
    /**
     * 
     * This static field defines a return value the designaes an
     * unsuccessfule return.
     * 
     */
    public final static int NOT_OK    = 1; // Not so much
    
    /**
     * 
     * This static field defines a value that either indicate a method was 
     * skipped or is to be skipped.
     */
    public final static int SKIP      = 2; // We are skipping this block/func
    
    /**
     * 
     * 
     */
    public final static int NOT_YET   = 3; // This block/func is not ready
    
    /**
     * 
     */
    public final static int FAIL      = 4; // It all went to hell in a handbasket
    
    /**
     * 
     */
    public final static int NOT_FOUND = 5; // Could not find what we were looking for
    
    /**
     * 
     */
    public final static int FOUND     = 6; // Found my keys

    /**
     * 
     */
    public final static ArrayList <String> AWS_REGIONS = 
        new ArrayList<>(Arrays.asList("ap-northeast-1", "ap-northeast-3",
                                            "ap-south-1",     "ap-southeast-1",
                                            "ap-southeast-2", "ca-central-1",
                                            "eu-central-1",   "eu-north-1",
                                            "eu-west-1",      "eu-west-2",
                                            "eu-west-3",      "sa-east-1",
                                            "us-east-1",      "us-east-2",
                                            "us-west-1",      "us-west-2"));
    /**
     * 
     * The method <b>toJson</b> takes a fully populated 
     * {@link com.addepar.asd.ServiceMessage ServiceMessage} and builds a 
     * correctly formatted json string.
     * 
     * @param sm  A fully populated {@link com.addepar.asd.ServiceMessage ServiceMessage}.
     * @return The passed in ServiceMessage as a json string.
     */
    public static String toJson(ServiceMessage sm) {
        JSONObject jObj = new JSONObject();
        
        Instant now = Instant.now();
        String TimeNow = now.toString();
        
        jObj.put("gen_time",           TimeNow);
        jObj.put("account_id",         sm.getAccountId());
        jObj.put("client_name",        sm.getClientName());
        jObj.put("arcade_name",        sm.getArcadeName());
        jObj.put("service_name",       sm.getServiceName());
        jObj.put("connection_string",  sm.getConnectionString());
        jObj.put("service_status",     sm.getServiceStatus());
        jObj.put("service_status",     sm.getServiceStatus());
        jObj.put("msg",                sm.getMsg());
        
        return jObj.toString(4);
    }   // End of toJson

    /**
     * 
     * The method <b>genParameterKey</b> takes selected fields from a full 
     * populated {@link com.addepar.asd.ServiceMessage ServiceMessage} and 
     * formats then into an AWS SSM Parameter key to be used by the ASD class.
     * <p>
     * The fields are;
     * <ul>
     * <li>account ID</li>
     * <li>client name</li>
     * <li>arcade name</li>
     * <li>service name</li>
     * </ul>
     * <p>
     * The following is an example;
     * <p>
     * /ASD/123456789012/joes_pretty_good_bank/real_ripoff/salami_slicer
     * 
     * @param sm A full populated {@link com.addepar.asd.ServiceMessage ServiceMessage}.
     * @return An AWS SSM Parameter key based on the contents of {@link com.addepar.asd.ServiceMessage ServiceMessage}.
     */
    public static String genParameterKey(ServiceMessage sm) {
        StringBuilder sb = new StringBuilder();
                
        sb.append("/ASD/");
        sb.append(sm.getAccountId()).append("/");
        sb.append(sm.getClientName()).append("/");
        sb.append(sm.getArcadeName()).append("/");
        sb.append(sm.getServiceName()).append("/service-status.json");
        
        return sb.toString();
    }   // End of genParameterKey
    
    /**
     * 
     * The method <b>genParameterKey</b> takes the passed in fields and 
     * formats then into an AWS SSM Parameter key to be used by the ASD class.
     * <p>
     * The fields are;
     * <ul>
     * <li>account ID</li>
     * <li>client name</li>
     * <li>arcade name</li>
     * <li>service name</li>
     * </ul>
     * <p>
     * The following is an example;
     * <p>
     * /ASD/123456789012/joes_pretty_good_bank/real_ripoff/salami_slicer
     * 
     * @param accountId The AWS account ID.
     * @param clientName The client name
     * @param arcadeName
     * @param serviceName
     * 
     * @return An AWS SSM Parameter key based on the passed in values.
     */
    public static String genParameterKey(String accountId,
                                         String clientName,
                                         String arcadeName,
                                         String serviceName) {
        
        StringBuilder sb = new StringBuilder();
                
        sb.append("/ASD/");
        sb.append(accountId).append("/");
        sb.append(clientName).append("/");
        sb.append(arcadeName).append("/");
        sb.append(serviceName).append("/service-status.json");
        
        return sb.toString();  
    }
    
}   // End of class Common


/**************************************************************************
**
**                          < End of Common.java >
**
**************************************************************************/

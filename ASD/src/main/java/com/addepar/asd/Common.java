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
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.DescribeParametersRequest;
import software.amazon.awssdk.services.ssm.model.DescribeParametersResponse;
import software.amazon.awssdk.services.ssm.model.ParameterMetadata;
import software.amazon.awssdk.services.ssm.model.SsmException;


/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com 
 */
public class Common {
    /**
     *  The <b>DEFAULT_REGION</b> is the default AWS region. This region
     * is used when we fail to find AWS_REGION and/or DEFAULT_REGION in
     * the shell environment.
     */
    public final static String DEFAULT_REGION = "us_east_2";
    
    /**
     * This static field defines a return value that designates a
     * successful return.
     */
    public final static int OK        = 0; // It all worked out
    
    /**
     * This static field defines a return value the designaes an
     * unsuccessfule return.
     * 
     */
    public final static int NOT_OK    = 1; // Not so much
    
    /**
     * This stat
     */
    public final static int SKIP      = 2; // We are skipping this block/func
    
    /**
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
        jObj.put("msg",                sm.getMsg());
        
        return jObj.toString(4);
    }   // End of toJson

    /**
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
     * @param accountId
     * @param clientName
     * @param arcadeName
     * @param serviceName
     * @return 
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
    
    /**
     * 
     * @param ssmClient
     * @return 
     */
    public static ArrayList getAllParameters(SsmClient ssmClient) {
        ArrayList al = new ArrayList();
        boolean thereIsMore = false;
        
        try {
            DescribeParametersRequest desRequest = DescribeParametersRequest.builder()
                    .maxResults(10)
                    .build();
            
            DescribeParametersResponse desResponse = ssmClient.describeParameters(desRequest);
            String nextToken = desResponse.nextToken();
            if (nextToken != null) {
                thereIsMore = true;
            }
            
            List<ParameterMetadata> params = desResponse.parameters();
            for (ParameterMetadata paraMeta : params) {
                al.add(paraMeta);
            } 
            
            while (thereIsMore) {
                DescribeParametersRequest desRequest2 = DescribeParametersRequest.builder()
                    .maxResults(10)
                    .nextToken(nextToken)
                    .build();
                DescribeParametersResponse desResponse2 = ssmClient.describeParameters(desRequest2);
                nextToken = desResponse2.nextToken();
                if (nextToken != null) {
                    thereIsMore = true;
                } else {
                    thereIsMore = false;
                }
                
                List<ParameterMetadata> params2 = desResponse2.parameters();
                for (ParameterMetadata paraMeta2 : params2) {
                    al.add(paraMeta2);
                }
            }   // End of while loop
        } catch (SsmException e) {
            e.getStackTrace();
        }
        
        return al;
    }   // End of getAllParameters
}   // End of class Common


/**************************************************************************
**
**                          < End of Common.java >
**
**************************************************************************/

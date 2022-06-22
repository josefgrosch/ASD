/**************************************************************************
**
**                             < ASDReply.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : ASDReply.java
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
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Instant;
import org.json.JSONObject;
import software.amazon.awssdk.regions.Region;


/**
 *
 * @author Josef Grosch (josef.grosch@addepar.com)
 */
public class Utility {
    
    /**
     * 
     * The method <b>initTestMessage</b> creates and populates a 
     * {@link com.addepar.asd.ServiceMessage ServiceMessage} with know dummy 
     * data for the purpose of testing.
     * 
     * @return A ServiceMessage fully populated with dummy test data. 
     */
    public static ServiceMessage initTestMessage() {
        String accountId = "123456789012";
        String clientName = "PicklesUnlimited";
        String clientId   = "666";
        String arcadeName = "Big_Pink.arc";
        String serviceName = "memcache";
        String serviceStatus = "dead";
        String connectionString = "http://pickles.picklesunlimited.com";
    
        ServiceMessage sm = new ServiceMessage();
        sm.setAccountId(accountId);
        sm.setClientName(clientName);
        sm.setClientId(clientId);
        sm.setArcadeName(arcadeName);
        sm.setServiceName(serviceName);
        sm.setServiceStatus(serviceStatus);
        
        sm.setConnectionString(connectionString);
        
        String pKey = genParameterKey(sm);
        sm.setParameterKey(pKey);
        
        return sm;
    }   // End of initTestMessage
     
    /**
     * 
     * @param fileName
     * @return
     * @throws URISyntaxException 
     */
    public File getFileFromResource(String fileName) 
            throws URISyntaxException {

        File fObj = null;
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            fObj = new File(resource.toURI());
        }
        
        return fObj;
    }   // End of getFileFromResource
    
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
    }   // End of genParameterKey
    
    /**
     * 
     * @return 
     */
    public static Region determineThisRegion() {
        Region region = null;
        
        return region;
    }   // End of determineRegion
}   // End of class Utility


/**************************************************************************
**
**                          < End of ASDReply.java >
**
**************************************************************************/

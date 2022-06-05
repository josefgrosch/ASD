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
import org.json.JSONObject;


/**
 *
 * @author Bob Dobbs
 */
public class Common {
    /**
     *  The <b>DEFAULT_REGION</b> is the default AWS region. This region
     * is used when we fail to find AWS_REGION and/or DEFAULT_REGION in
     * the shell environment.
     */
    public final static String DEFAULT_REGION = "us_east_2";
    
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
        
        jObj.put("gen_time_epoch",     TimeNow);
        jObj.put("account_id",         sm.getAccountId());
        jObj.put("client_name",        sm.getClientName());
        jObj.put("arcade_name",        sm.getArcadeName());
        jObj.put("service_name",       sm.getServiceName());
        jObj.put("connection_string",  sm.getConnectionString());
        jObj.put("service_status",     sm.getServiceStatus());
        
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
    
}   // End of class Common


/**************************************************************************
**
**                          < End of Common.java >
**
**************************************************************************/

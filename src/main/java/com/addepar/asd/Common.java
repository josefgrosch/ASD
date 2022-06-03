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
     * 
     */
    public final static String DEFAULT_REGION = "us_east_2";
    
    /**
     * 
     */
    //public Common() {
    //    super();
    //}   // End of defailt class constructor
    
    /**
     * 
     * @param sm
     * @return 
     */
    public static String toJson(ServiceMessage sm) {
        JSONObject jObj = new JSONObject();
        
        Instant now = Instant.now();
        String TimeNow = now.toString();
        
        jObj.put("gen_time_epoch",     TimeNow);
        jObj.put("arcade_name",        sm.getArcadeName());
        jObj.put("account_id",         sm.getAccountId());
        jObj.put("arcade_name",        sm.getArcadeName());
        jObj.put("service_name",       sm.getServiceName());
        jObj.put("connection_string",  sm.getConnectionString());
        jObj.put("register_service",   boolToString(sm.getRegisterService()));
        jObj.put("unregister_service", boolToString(sm.getUnregisterService()));
        jObj.put("locate_service",     boolToString(sm.getLocateService()));
        jObj.put("service_status",     sm.getServiceStatus());
        
        return jObj.toString(4);
    }   // End of toJson
    
    /**
     * 
     * @param field
     * @return 
     */
    private static String boolToString(boolean field) {
        String outStr;
        
        if (field == true) {
            outStr = "True";
        } else if (field == false) {
            outStr = "False";
        } else {
            outStr = "False";
        }
        
        return outStr;
    }   // End of boolToString
}   // End of class Common


/**************************************************************************
**
**                          < End of Common.java >
**
**************************************************************************/

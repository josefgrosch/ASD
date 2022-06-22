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
import java.util.ArrayList;
import java.util.Arrays;


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
    public final static int OK = 0; // It all worked out
    
    /**
     * 
     * This static field defines a return value the designaes an
     * unsuccessfule return.
     * 
     */
    public final static int NOT_OK = 1; // Not so much
    
    /**
     * 
     * This static field defines a value that either indicate a method was 
     * skipped or is to be skipped.
     */
    public final static int SKIP = 2; // We are skipping this block/func
    
    /**
     * 
     * 
     */
    public final static int NOT_YET = 3; // This block/func is not ready
    
    /**
     * 
     */
    public final static int FAIL = 4; // It all went to hell in a handbasket
    
    /**
     * 
     */
    public final static int NOT_FOUND = 5; // Could not find what we were looking for
    
    /**
     * 
     */
    public final static int FOUND = 6; // Found my keys

   /**
    * 
    */
    public final static int ASD_FIELD = 1;

    /**
     * 
     */
    public final static int ACCOUNT_FIELD = 2;

    /**
     * 
     */
    public final static int CO_NAME_FIELD = 3;

    /**
     * 
     */
    public final static int ARCADE_FIELD  = 4;

    /**
     * 
     */
    public final static int SERVICE_FIELD = 5;
    
    /**
     * 
     */
    public final static int FIELD_COUNT = 7;
    
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
    
}   // End of class Common


/**************************************************************************
**
**                          < End of Common.java >
**
**************************************************************************/

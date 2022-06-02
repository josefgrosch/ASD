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
        
        this.arcadeName = System.getenv("ARCADE_NAME");
        this.defaultRegion = System.getenv("DEFAULT_REGION");
        if (this.defaultRegion == null || this.defaultRegion.isEmpty()) {
            this.defaultRegion = System.getenv("AWS_DEFAULT_REGION");
        }
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
     */
    public ASDReply register(ServiceMessage sm) {
        ASDReply ar = new ASDReply();
        
        return ar;
    }
    
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
}   // End of class ASD


/**************************************************************************
**
**                          < End of ASD.java >
**
**************************************************************************/

/**************************************************************************
**
**                             < Register.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : Register.java
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
import software.amazon.awssdk.services.ssm.model.PutParameterResponse;


/**
 *
 * @author Bob Dobbs
 */
public class Register {

    /**
     * 
     */
    public Register() {
        super();
    }
    
    /**
     * 
     * @param sm 
     */
    public Register(ServiceMessage sm) {
        this();
    }
    
    /**
     * 
     * @param sm
     * @return 
     */
    public static ASDReply register(ServiceMessage sm) {
        ASDReply asdr = new ASDReply();
        
     PutParameterResponse ppr = null;
        String value = "";
        String key = "";
        /*
        try {    
            SsmClient ssmClient = SsmClient.builder().region(Region.US_EAST_2).build();
        
            PutParameterRequest pr = PutParameterRequest.builder()
                    .value(value) 
                    .name(key)
                    .type("String")
                    .dataType("text")
                    .overwrite(true)
                    .build();
            
            ppr = ssmClient.putParameter(pr);    
        }
        catch (AwsServiceException | SdkClientException e) {
            System.out.println("Something went wrong.\n\n");
            System.out.println(e.getMessage());
        }
        */
        return asdr;
        
    }
}   // End of class Register


/**************************************************************************
**
**                          < End of Register.java >
**
**************************************************************************/

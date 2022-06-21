/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.addepar.study04;

import com.addepar.asd.ASDReply;
import com.addepar.asd.ServiceMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.ParameterNotFoundException;
import software.amazon.awssdk.services.ssm.model.SsmException;

/**
 *
 * @author josef.grosch
 */
public class Study04 {
    public static void main(String[] args) {

        // /ASD/023960176222/big_bad_john.arc/flux_capacitor/service-status.json
       
        List<String> Services = Arrays.asList("aoatvb2smsdb",      "aoatvb2testdb",
                                              "apilb",             "comp-server",
                                              "factortags",        "iverson",
                                              "maxwell",           "memcache",
                                              "reportgeneration",  "rest-api-global-tasks",
                                              "rest-api-server",   "securitymaster",
                                              "snapshots",         "taxlot-data",
                                              "transactions");

        String paraName = "/ASD/1234567890/pickles_inlimites/big_pink.arc/iverson/service-status.json";
        Region region = Region.US_EAST_2;
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        ASDReply asdr = getParaValue(ssmClient, paraName);
        ssmClient.close();
    }   // End of main

    public static ASDReply getParaValue(SsmClient ssmClient, String paraName) {
        StringBuilder sb = new StringBuilder();
        ASDReply asdr = new ASDReply();
        
        ServiceMessage sm = new ServiceMessage();
        String [] bits = paraName.split("/");
        int fieldCount = bits.length;
        
        if (fieldCount == 7) {
            try {
                GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(paraName)
                    .build();

                GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
                sb.append("The parameter value is : ").append(parameterResponse.parameter().value());

            } catch (ParameterNotFoundException ex) {
                sb.append("exception: ").append(ex);
            }
        }   // End of if
        
        return asdr;
    }   // End of getParaValue
}   // End of class Strudy05


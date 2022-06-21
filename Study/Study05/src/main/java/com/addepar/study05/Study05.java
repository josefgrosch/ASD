

package com.addepar.study05;

import com.amazonaws.SdkClientException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.PutParameterRequest;
import software.amazon.awssdk.services.ssm.model.PutParameterResponse;
import com.addepar.asd.ServiceMessage;

/**
 *
 * @author josef.grosch
 */
public class Study05 {

    public static void main(String[] args) {
        List<String> Services = Arrays.asList("aoatvb2smsdb",      "aoatvb2testdb",
                                              "apilb",             "comp-server",
                                              "factortags",        "iverson",
                                              "maxwell",           "memcache",
                                              "reportgeneration",  "rest-api-global-tasks",
                                              "rest-api-server",   "securitymaster",
                                              "snapshots",         "taxlot-data",
                                              "transactions",      "taxlot");
        
        String arcadeName = "dead_sky.arc";
        
        /*
        Iterator<String> serviceIterator = Services.iterator();
        while (serviceIterator.hasNext()) {
        String serviceName = serviceIterator.next();
        newParameter(serviceName, arcadeName);
        }
        */       
        
        for (String serviceName : Services) {
            newParameter(serviceName, arcadeName);
        }
        
        System.exit(0);
    }   // End of main

    public static void newParameter(String serviceName, String arcadeName) {
        //Common comm = new Common();
        // ASD/023960176222/dead_sky.arc/iverson.json
        // ASD/<account>/<arcade>/<service>.json
        //String key = "/ASD/023960176222/dead_sky.arc/taxlots/test3.json";
        
        StringBuilder sb = new StringBuilder();
        sb.append("/ASD/023960176222/").append(arcadeName).append("/");
        sb.append(serviceName).append("/service-status.json");
        String key = sb.toString();
        
        PutParameterResponse ppr = null;
        
        ServiceMessage sm = new ServiceMessage();
        
        
        sm.setAccountId("023960176222");
        sm.setArcadeName(arcadeName);
        sm.setServiceName(serviceName);
        sm.setConnectionString("http://www.example.com");
        String json1 = sm.toJson();
        String str1 = sm.toString();
        
        String value = sm.toJson();
        
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
            System.exit(1);
        }
    }
    /*
    public static String createNewOpsItem(SsmClient ssmClient,
            String title,
            String source,
            String category,
            String severity) {

        try {
            CreateOpsItemRequest opsItemRequest = CreateOpsItemRequest.builder()
                .description("Created by the SSM Java API")
                .title(title)
                .source(source)
                .category(category)
                .severity(severity)
                .build();

            CreateOpsItemResponse itemResponse = ssmClient.createOpsItem(opsItemRequest);
            return itemResponse.opsItemId();

        } catch (SsmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        return "";
    }   // End of createNewOpsItem
*/
}   // End of class Study05

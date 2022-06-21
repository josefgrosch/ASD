

package com.addepar.study01;

import com.addepar.asd.ServiceMessage;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.CreateOpsItemRequest;
import software.amazon.awssdk.services.ssm.model.CreateOpsItemResponse;
import software.amazon.awssdk.services.ssm.model.PutParameterRequest;
import software.amazon.awssdk.services.ssm.model.PutParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

/**
 *
 * @author josef.grosch
 */
public class Study01 {

    public static void main(String[] args) {
        int i = 1;
        
        //Common comm = new Common();
        // ASD/023960176222/dead_sky.arc/iverson.json
        // ASD/<account>/<arcade>/<service>.json
       
        String key = "/ASD/023960176222/dead_sky.arc/taxlots/test3.json";
        PutParameterResponse ppr = null;
        
        ServiceMessage sm = new ServiceMessage();
        
        sm.setAccountId("023960176222");
        sm.setArcadeName("little_john");
        sm.setServiceName("flux_capacitor");
        sm.setConnectionString("http://www.example.com");
        
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
            System.exit(i);
        }
        
        
        System.exit(0);
    }
    
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
}   // End of class

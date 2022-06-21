

package com.addepar.study06;


import com.addepar.asd.Common;
import com.addepar.asd.ServiceMessage;
import com.addepar.asd.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.DescribeParametersRequest;
import software.amazon.awssdk.services.ssm.model.DescribeParametersResponse;
import software.amazon.awssdk.services.ssm.model.ParameterMetadata;
import software.amazon.awssdk.services.ssm.model.SsmException;
import java.util.Iterator;
import java.util.List;

/*
accountId
arcadeName
clientId
clientName
serviceName

defaultRegion
emptyField
flux_capacitor
fullyLoaded
*/

/**
 *
 * @author josef.grosch
 */
public class Study06 {

    public static void main(String[] args) {
        int i = 0;
        ServiceMessage searchMessage = new ServiceMessage();
        
        

        ServiceMessage sm = Utility.initTestMessage();
        HashMap hm = genSearchFilter(sm);
        
        Region region = Region.US_EAST_2;
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
        ArrayList al = getAllParameters(ssmClient);
        Iterator alIterator = al.iterator();
        while (alIterator.hasNext()) {
            ParameterMetadata  pm = (ParameterMetadata) alIterator.next();
           
            String name = pm.name();
            String [] bits = name.split("/");
            
            i++;
        }
        
        ssmClient.close();
        
        System.exit(0);
    }   // End of main

    /**
     * 
     * @return 
     */
    public static ServiceMessage initTestMessage() {
        String accountId = "123456789012";
        String clientName = "PicklesUnlimited";
        String clientId   = "666";
        String arcadeName = "Big_Pink.arc";
        String serviceName = "memcache";
        String connectionString = "http://pickles.picklesunlimited.com";
    
        ServiceMessage sm1 = new ServiceMessage();
        sm1.setAccountId(accountId);
        sm1.setClientName(clientName);
        sm1.setClientId(clientId);
        sm1.setArcadeName(arcadeName);
        sm1.setServiceName(serviceName);
        sm1.setConnectionString(connectionString);
        
        String pKey = Common.genParameterKey(sm1);
        sm1.setParameterKey(pKey);
        
        return sm1;
    }
    
    /**
     * 
     * @param sm
     * @return 
     */
    private static HashMap genSearchFilter(ServiceMessage sm) {
        HashMap <String, String> hm = new HashMap();        
        
        // Acount ID
        if (sm.getAccountId().length() > 0) {
            hm.put("account_id", sm.getAccountId());
        }
        
        // ArcadeName
        if (sm.getArcadeName().length() > 0) {
            hm.put("arcade_name", sm.getArcadeName());
        }
        
        // Client Name
        if (sm.getClientName().length() > 0) {
            hm.put("client_name", sm.getClientName());
        }
        
        // Service Name
        if (sm.getServiceName().length() > 0) {
            hm.put("service_Name", sm.getServiceName());
        }
        
        return hm;
    }   // End of genSearchFilter
    
    //
    // replaced bu Common.getAllParameters
    //
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
            Iterator<ParameterMetadata> paramIterator = params.iterator();
            while (paramIterator.hasNext()) {
                ParameterMetadata paraMeta = paramIterator.next();
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
                                
                Iterator<ParameterMetadata> param2Iterator = params2.iterator();
                while (param2Iterator.hasNext()) {
                    ParameterMetadata paraMeta2 = param2Iterator.next();
                    al.add(paraMeta2);
                }
                int j = 0;
            }   // End of while loop
        } catch (SsmException e) {
            e.getStackTrace();
        }
        
        return al;
    }   // End of describeParams
}   // End of class Study6
    


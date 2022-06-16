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
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.ParameterMetadata;
import software.amazon.awssdk.services.ssm.model.PutParameterRequest;
import software.amazon.awssdk.services.ssm.model.PutParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmResponseMetadata;


/**
 *
 * @author Josef Grosch -- josef.grosch@addepar.com
 * @version 0.1
 */
public class ASD {
    /**
     * The <b>accountId</b> is the AWS account ID.
     */
    private String accountId   = "";
    
    /**
     * The <b>clientName</b> is the name of Addepar's client.
     */
    private String clientName  = "";

    /**
     * The <b>clientId</b> is the client's ID as assigned by Addepar.
     */
    private String clientId    = "";
    
    /**
     * The <b>arcadeName</b> is the name of the arcade the clients
     * services are running in.
     */
    private String arcadeName  = "";
    
    /**
     * 
     */
    private String serviceName = "";
    
    /**
     * The <b>defaultRegion</b> is the AWS region the arcade is running in.
     */
    private String defaultRegion = "";
    
    /**
     *
     */
    private boolean fullyLoaded = true;
    
    /**
     * 
     */
    private String emptyField = "";
    
    /**
     * 
     */
    private ServiceMessage sm = null;
    
    
    private String fluxCapacitor = "";
    
  
    //
    // Constructors
    //
    
    /**
     * 
     */
    public ASD() {
        super();
        
        this.arcadeName = System.getenv("ARCADE_NAME");
        if (this.arcadeName == null || this.arcadeName.length() == 0) {
            //this.arcadeName = Common.DEFAULT_REGION;
            this.arcadeName = "";
        }
        
        this.defaultRegion = System.getenv("DEFAULT_REGION");
        if (this.defaultRegion == null || this.defaultRegion.length() == 0) {
            this.defaultRegion = Common.DEFAULT_REGION;
        }
        
        System.setProperty("aws.region", this.defaultRegion);
        
        String head = System.getenv("EASTER_ISLAND");
        if (head != null) {
            this.fluxCapacitor = writeNoseyString();
        }   // End of Head!
    }   // End of default class constructor
    
    /**
     * 
     * @param sm 
     * @throws java.lang.Exception 
     */
    public ASD(ServiceMessage sm) throws Exception {
        this();
        
        this.sm = sm;

        //
        // Check if the required fields have been populated.
        //
        
        // account id
        if ((this.sm.getAccountId().length() > 0) || 
            (this.fullyLoaded == true)) {
            this.accountId  = this.sm.getAccountId();
        } else {
            this.fullyLoaded = false;
            this.emptyField = "account id";
        }

        // client id
        if ((this.sm.getClientId().length() > 0) || 
           (this.fullyLoaded == true)) {
            this.clientId  = this.sm.getClientId();
        } else {
            this.fullyLoaded = false;
            this.emptyField = "cliend id";
        }

        // client name
        if ((this.sm.getClientName().length() > 0) || 
           (this.fullyLoaded == true)) {
            this.clientName  = this.sm.getClientName();
        } else {
            this.fullyLoaded = false;
            this.emptyField = "client name";
        }

        // arcade name
        if ((this.sm.getArcadeName().length() > 0) || 
           (this.fullyLoaded == true)) {
            this.arcadeName  = this.sm.getArcadeName();
        } else {
            this.fullyLoaded = false;
            this.emptyField = "arcade name";
        }

        // service name
        if ((this.sm.getServiceName().length() > 0) || 
           (this.fullyLoaded == true)) {
            this.serviceName  = this.sm.getServiceName();
        } else {
            this.fullyLoaded = false;
            this.emptyField = "service name";
        }

        // If there are empty fields, that is a problem.
        if (this.fullyLoaded == false) {
            throw new Exception("Field "+this.emptyField+ "is empty. Try again");
        }
    
        if (this.fluxCapacitor.length() > 0) {
            this.sm.setMsg(this.fluxCapacitor);
        }
    }   // End of class constuctor with a ServiceMessage
    
    /**
     * 
     * @param jObject 
     */
    public  ASD(JSONObject jObject) {
        this();
    }   // End of constructor - json object
    
    //
    // Get methods
    //

    /**
     * 
     * @return 
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * 
     * @return 
     */
    public String getClientName() {
        return this.clientName;
    }

    /**
     * 
     * @return 
     */
    public String getClientId() {
        return this.clientId;
        
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
     * @return 
     */
    public String getDefaultRegion() {
        return this.defaultRegion;
    }

    /**
     * 
     * @return 
     */
    public String getServiceName() {
        return this.serviceName;
    }
    
    //
    // Set methods
    //

    /**
     * 
     * @param accountId 
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * 
     * @param clientName 
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 
     * @param clientId 
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    /**
     * 
     * @param arcadeName 
     */
    public void setArcadeName(String arcadeName) {
        this.arcadeName = arcadeName;
    }

    /**
     * 
     * @param defaultRegion 
     */
    public void setDefaultRegion(String defaultRegion) {
        this.defaultRegion = defaultRegion;
    }

    /**
     * 
     * @param serviceName 
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    //
    // General Methods
    //
    
    /**
     * 
     * @return 
     */
    public ASDReply registerService() {
        ASDReply asdr = new ASDReply();
        
        return asdr;
    }   // End of registerService
    
    /**
     * 
     * @param sm
     * @return
     * @throws AwsServiceException
     * @throws SdkClientException 
     */
    public ASDReply registerService(ServiceMessage sm) 
        throws AwsServiceException, SdkClientException {
        boolean debug = true;
        ASDReply asdr = new ASDReply();
        
        String key   = Common.genParameterKey(sm);
        String value = sm.toJson();
        
        /*
         * TODO - figure out how to take a region string, "us_east_2"
         * and get Region.US_EAST_2
         *
         * Region region = new Region();
         */
        
        SsmClient ssmClient = SsmClient.builder().region(Region.US_EAST_2).build();
        
        PutParameterRequest pr = PutParameterRequest.builder()
                .value(value) 
                .name(key)
                .type("String")
                .dataType("text")
                .overwrite(true)
                .build();
            
        PutParameterResponse ppr = ssmClient.putParameter(pr);  
        
        if (debug) {
            System.out.println(ppr.toString());
        }
        
        asdr.setPprResponse(ppr);
        if (this.fluxCapacitor.length() > 0) {
            asdr.setMsg(this.fluxCapacitor);
        }
        
        return asdr;
    }   // End of registerService
    
    /**
     * 
     * @param sm
     * @return 
     */
    public ASDReply unregisterService(ServiceMessage sm) {
        ASDReply asdr = null;
        
        try {
            asdr = this.getParameterValue(sm);
            String key = sm.getParameterKey();
            int i = 0;
            
            //DeleteParameterRequest dpr = new DeleteParameterRequest.Builder.name(key).toBuilder();
          
            /*
            AWSCredentialsProvider credentials = InstanceProfileCredentialsProvider.getInstance();
            AWSSimpleSystemsManagement simpleSystemsManagementClient =
            AWSSimpleSystemsManagementClientBuilder.standard().withCredentials(credentials)
                .withRegion(Regions.getCurrentRegion().getName()).build();
    
            DeleteParameterRequest parameterRequest = new DeleteParameterRequest().withName(key);

            simpleSystemsManagementClient.deleteParameter(parameterRequest);
            */
        } catch (ASDKeyNotFoundException ex) {
            Logger.getLogger(ASD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return asdr;
    }   // End of unregisterService
    
   
    
    /**
     * 
     * @param sm
     * @return
     * @throws ASDKeyNotFoundException 
     */
    public ASDReply getParameterValue(ServiceMessage sm) throws ASDKeyNotFoundException  {
        ASDReply asdr = new ASDReply();
        String paraName = sm.getParameterKey();
        GetParameterResponse parameterResponse = null;
        
        try {
        Region region = Region.US_EAST_2;
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build(); 
       
        GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name(paraName)
                .build();

        parameterResponse = ssmClient.getParameter(parameterRequest);

        String jStr = parameterResponse.parameter().value();
        if (parameterResponse.parameter().value().length() <= 0) {
            throw new ASDKeyNotFoundException("Key "+paraName+" not found.");
        }
        
        JSONObject jObj = new JSONObject(jStr);
        String connStr = jObj.getString("connection_string");
        asdr.setConnectionString(connStr);
        
        SsmResponseMetadata ssmM = parameterResponse.responseMetadata();
        asdr.setResponseMetadate(ssmM);
        
        String statusCode = String.valueOf(parameterResponse
                .sdkHttpResponse().statusCode());
        asdr.setStatusCode(statusCode);

        ssmClient.close();
        } catch (AwsServiceException | SdkClientException ex) {
            System.out.println(ex.getMessage());
        }
        
        if (this.fluxCapacitor.length() > 0) {
            asdr.setMsg(this.fluxCapacitor);
        }
        return asdr;
    }   // End of getParameterValue
        
   
    /**
     * 
     * @param sm
     * @return 
     */
    public ASDReply locateServices(ServiceMessage sm) {
        ASDReply asdr = new ASDReply();
        Region region = Region.US_EAST_2;
        
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        ArrayList al = Common.getAllParameters(ssmClient);
        Iterator alIterator = al.iterator();
        while (alIterator.hasNext()) {
            ParameterMetadata  pm = (ParameterMetadata) alIterator.next();
        }
        
        ssmClient.close();
        
        if (this.fluxCapacitor.length() > 0) {
            asdr.setMsg(this.fluxCapacitor);
        }
        
        return asdr;
    }   // End of locateService
    
    /**
     * 
     * @param sm
     * @return 
     */
    public String getAllRegistedServices(ServiceMessage sm) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("/ASD/");
        sb.append(sm.getAccountId()).append("/");
        sb.append(sm.getArcadeName()).append("/");
        
        String baseArcadeName = sb.toString();
        
        return sb.toString();
    }   // End of getAllRegisteredServices
    
    /**
     * 
     * @return 
     */
    public String toJson() {
        ServiceMessage localSm = null;
        
        if (this.sm == null) {
            
        } else {
            localSm = this.sm;
        }
        
        String outStr = Common.toJson(localSm);
        return outStr;
    }
    
    /*
    public String writeNoseyStringTest() {
        return this.writeNoseyString();
    }
    */
    
    private String writeNoseyString() {
        //this.flux_capacitor = true;
        //StringBuilder sb = new StringBuilder();
        String outStr = "";
        try {
            File f = getFileFromResource("quotes.json");
            String content = FileUtils.readFileToString(f, "UTF-8");
            
            JSONObject jObj = new JSONObject(content);
            JSONArray arr = jObj.getJSONArray("quotes");
            
            int arrSize = arr.length();
            Random random = new Random();
            int maxRandom = 20000;
            int minRandom = 0;
            
            int randomNum = random.nextInt(maxRandom - minRandom) + minRandom;
            int index = (randomNum % arrSize);
            String oStr = arr.getString(index);
            
            outStr = oStr;
            
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(ASD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return outStr;
    }   // End of writeNoseyString
    
    
    /**
     * 
     * @param fileName
     * @return
     * @throws URISyntaxException 
     */
    private File getFileFromResource(String fileName) 
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
}   // End of class ASD


/**************************************************************************
**
**                          < End of ASD.java >
**
**************************************************************************/

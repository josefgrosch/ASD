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
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.PutParameterRequest;
import software.amazon.awssdk.services.ssm.model.PutParameterResponse;
import com.addepar.asd.ASDMissingValuesException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.ParameterMetadata;
import software.amazon.awssdk.services.ssm.model.SsmException;
import software.amazon.awssdk.services.ssm.model.SsmResponseMetadata;

/**
 *
 * @author Josef Grosch < josef.grosch@addepar.com >
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
    
    
    private boolean flux_capacitor = false;
    
  
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
            this.arcadeName = Common.DEFAULT_REGION;
        }
        
        this.defaultRegion = System.getenv("DEFAULT_REGION");
        if (this.defaultRegion == null || this.defaultRegion.length() == 0) {
            this.defaultRegion = Common.DEFAULT_REGION;
        }
        
        System.setProperty("aws.region", this.defaultRegion);
        
        String head = System.getenv("EASTER_ISLAND");
        if (head != null) {
            //writeNoseyString();
            int i = 0;
        }   // End of Head!
    }   // End of default class constructor
    
    /**
     * 
     * @param sm 
     * @throws com.addepar.asd.ASDMissingValuesException 
     */
    public ASD(ServiceMessage sm) throws ASDMissingValuesException {
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
            throw new ASDMissingValuesException("Field "+this.emptyField+ "is empty. Try again");
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

    //
    // General Methods
    //
    
    /**
     * 
     * @return 
     */
    public ASDReply registerService() {
        ASDReply ar = new ASDReply();
        
        return ar;
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
        ASDReply ar = new ASDReply();
        
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
        
        ar.setPprResponse(ppr);
        
        return ar;
    }   // End of registerService
    
    /**
     * 
     * @param sm
     * @return 
     */
    public ASDReply unregisterService(ServiceMessage sm) {
        ASDReply ar = new ASDReply();
        
        return ar;
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
        //System.out.println("The parameter value is "+parameterResponse.parameter().value());

        String connStr = parameterResponse.parameter().value();
        SsmResponseMetadata ssmM = parameterResponse.responseMetadata();
        String statusCode = String.valueOf(parameterResponse.sdkHttpResponse().statusCode());


        ssmClient.close();
        } catch (AwsServiceException | SdkClientException ex) {
            System.out.println(ex.getMessage());
        }
        
        if (parameterResponse.parameter().value().length() <= 0) {
            throw new ASDKeyNotFoundException("Key "+paraName+" not found.");
        }
        
        return asdr;
    }   // End of lo
        
   
    /**
     * 
     * @param sm
     * @return 
     */
    public ASDReply locateServices(ServiceMessage sm) {
        ASDReply ar = new ASDReply();
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
        
        return ar;
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
    private void writeNoseyString() {
        this.flux_capacitor = true;
        StringBuilder sb = new StringBuilder();
        try {
            //JSONParser parser = new JSONParser();
            URL resource = getClass().getClassLoader().getResource("quotes.json");
            if (resource == null) {   
                throw new IllegalArgumentException("file not found!");
            } else {
                
                Object obj = parser.parse(new FileReader(new File(resource.getFile())));
                JSONObject jsonObject = (JSONObject)obj;
         
                // failed if files have whitespaces or special characters
                // File qFile = new File(resource.getFile());
                // return new File(resource.toURI());
                
                JSONArray arr = jsonObject.getJSONArray("quotes");
                int arrSize = arr.length();

                Random random = new Random();
                int maxRandom = 20000;
                int minRandom = 0;
        
                int randomNum = random.nextInt(maxRandom - minRandom) + minRandom;
                int index = (randomNum % arrSize);
                sb.append("<!--\n\n");
                String oStr = arr.getString(index);
                sb.append("    ");
                sb.append(oStr);
                sb.append("\n\n    -->\n");
                String qStr = sb.toString();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ASD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ASD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
}   // End of class ASD


/**************************************************************************
**
**                          < End of ASD.java >
**
**************************************************************************/

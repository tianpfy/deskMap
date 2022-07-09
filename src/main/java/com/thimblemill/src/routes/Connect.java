
package com.thimblemill.src.routes;

import com.amazonaws.partitions.model.Region;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thimblemill.src.interfaces.Connectable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connect implements Connectable{
    
    public String getSecret() throws JsonProcessingException, IOException {
    
String secretName = "arn:aws:secretsmanager:ap-southeast-2:487507401318:secret:berylbrown-bjPxWg";
    String region = "ap-southeast-2";

    AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
                                    .withRegion(region)
                                    .build();
    
    String secret = null, decodedBinarySecret;
    GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                    .withSecretId(secretName);
    GetSecretValueResult getSecretValueResult = null;
  
        getSecretValueResult = client.getSecretValue(getSecretValueRequest);

    if (getSecretValueResult.getSecretString() != null) {
        secret = getSecretValueResult.getSecretString();
    }
    else {
        decodedBinarySecret = new String(Base64.getDecoder().decode(getSecretValueResult.getSecretBinary()).array());
    }
ObjectMapper mapper = new ObjectMapper();
Map mapa = mapper.readValue(secret, Map.class);
String source = (String) mapa.get("nquser");


return source ;
}   
    
    
    
   public Connection getConnection() throws SQLException, IOException {
 Properties props = new Properties(); 
     String url = null;
    props.setProperty("escapeSyntaxCallMode", "callIfNoReturn");
        try {
           
            url = getSecret();
        
           
        } catch (IOException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            return DriverManager.getConnection(url,props); 
              }} ;


   


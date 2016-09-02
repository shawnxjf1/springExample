package com.lakala.soa.examples.rest.bsfit.client;

//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alibaba.fastjson.JSONObject;




/**
 * ClassName:RestClient <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@SuppressWarnings("unused")
public class BsfitRestClient {
	
	public static void main(String[] args) {

		//getFindbyname("http://localhost:8080/fksys/services/rest/bsfit/findByName.json",MediaType.APPLICATION_JSON_TYPE);

		//getFindStatus("http://localhost:8080/fksys/services/rest/bsfit/findStatus.json",MediaType.APPLICATION_JSON_TYPE);
		
		//getTestNameList("http://localhost:8080/fksys/services/rest/bsfit/testfindByNameList.json",MediaType.APPLICATION_JSON_TYPE);
		
	//getFindbyname("http://10.7.111.182:8899/fksys/services/rest/bsfit/findByName.json",MediaType.APPLICATION_JSON_TYPE);
		getFindbyname("http://10.1.98.61:8889/fksys/services/rest/bsfit/findByName.json",MediaType.APPLICATION_JSON_TYPE);

	    //getFindStatus("http://10.1.98.61:8889/fksys/services/rest/bsfit/findStatus.json",MediaType.APPLICATION_JSON_TYPE);

		
		//getTestNameList1("http://localhost:8080/fksys/services/ajax/bsfit/testfindByNameList.json",MediaType.APPLICATION_JSON_TYPE);
		
    }

    
    private static void getFindbyname(String url, MediaType mediaType) {
        System.out.println("Getting  via " + url);
        
        JSONObject jsonObject=new JSONObject();
	     jsonObject.put("uniqueId", "24234234");
	     //jsonObject.put("uniqueId", "110102195602132390");
	     jsonObject.put("tag", "certificate");
	     System.out.println(jsonObject.toString());

//        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
	     Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
       // Response response = target.request().post(Entity.entity(nameListClient, mediaType)); 
        Response response=target.request().post(Entity.json(jsonObject));//.put(Entity.json(jsonObject));
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
    }
   
    
    private static void getFindStatus(String url, MediaType mediaType) {
        System.out.println("Getting  via " + url);
        
        JSONObject jsonObject=new JSONObject();
	     jsonObject.put("uniqueId", "110102195602132390");
	     jsonObject.put("tag", "certificate");
	     System.out.println(jsonObject.toString());

//        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
	     Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
       // Response response = target.request().post(Entity.entity(nameListClient, mediaType)); 
        Response response=target.request().post(Entity.json(jsonObject));//.put(Entity.json(jsonObject));
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
    }
    
    
    private static void getTestNameList(String url, MediaType mediaType) {
        System.out.println("Getting  via " + url);

	     Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response=target.request().post(null);
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
    }
    
    //http
	private static void getTestNameList1(String url, MediaType mediaType) {
        System.out.println("Getting  via " + url);

	     Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response=target.request().post(null);
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
    }
   
}

package main.java.webservices;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;


public class GetMethod {
	
	
public static String getUsers(String url) {
	
	
	RestAssured.baseURI = url;
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get();
 
	if(response.getStatusCode()!=200)
		return null;
	
	ResponseBody body = response.getBody();
	
	return body.asString();
	
	   
	}

}
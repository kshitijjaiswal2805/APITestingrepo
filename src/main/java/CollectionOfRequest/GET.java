package CollectionOfRequest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GET {
	
	
	
	@Test
	public void TC1() {
		
		//base url
		RestAssured.baseURI="http://localhost:3000";
		//to get details in console
		given().get("/posts").then().statusCode(200).log().all();
		
		//send request and get the response 
		Response Resp = given().get("/posts/1").then().statusCode(200).extract().response();
		//Response is sin json format
		//change response to string 
		
		assertEquals(Resp.getStatusCode(), 200);
		assertEquals(Resp.jsonPath().getString("id"),"1");	
		assertEquals(Resp.jsonPath().getString("title"),"Title1");
		
	}

}

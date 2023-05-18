package CollectionOfRequest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class pbl {
	
	


@Test
 public void test_ListUsers() {
  RestAssured.useRelaxedHTTPSValidation();
  Response response =RestAssured.get("https://reqres.in/api/users?page=2");
  System.out.println(response.getStatusCode());
  System.out.println(response.getTime());
  System.out.println(response.getBody().asString());
  System.out.println(response.getStatusLine());
  System.out.println(response.getHeader("content-type"));
   int statusCode = response.getStatusCode();
  assertEquals(statusCode, 200);
 }
}
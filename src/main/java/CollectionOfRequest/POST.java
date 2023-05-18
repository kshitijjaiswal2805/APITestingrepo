package CollectionOfRequest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POST {

	@Test
	public void TC1() {
		// base url
		RestAssured.baseURI = "http://localhost:3000";
		//
		//entering response for the post request 
		Response Resp1 = given().contentType(ContentType.JSON)
				.body("{\n" + "    \"id\":6,\n" 
							+ "    \"title\":\"title6\",\n" 
							+ "    \"author\":\"6th\"\n" 
							+ "}")
				.when().post("/posts");
		
		//response code for post 
		assertEquals(Resp1.statusCode(), 201);

		// send request and get the response
		Response Resp2 = given().get("/posts/6").then().extract().response();
		// Response is sin Json format
		// change response to string

		assertEquals(Resp2.getStatusCode(), 200);
		assertEquals(Resp2.jsonPath().getString("id"), "6");
		assertEquals(Resp2.jsonPath().getString("title"), "title6");
	}

}

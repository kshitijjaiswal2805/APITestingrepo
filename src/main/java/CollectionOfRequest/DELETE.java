package CollectionOfRequest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DELETE {
	public static String title = GetRandomString();

	@Test

	public void TC1() {
		// base url
		RestAssured.baseURI = "http://localhost:3000";
		//

		Response Resp1 = given().contentType(ContentType.JSON).body(
				"{\n"
				+ "    \n"
				+ "    \"title\":\""+title+"\"\n"
				+ "   \n"
				+ "}")
				.when().post("/posts");

		assertEquals(Resp1.statusCode(), 201);
		given().get("/posts").then().log().all();

		String NewlyAddedPostID = Resp1.jsonPath().getString("id");

		// deleting the data
		Response RespOfDeletion = given().delete("/posts/" + NewlyAddedPostID +" ");
		// verifying if the above data is deleted
		assertEquals(RespOfDeletion.statusCode(), 200);
		System.out.println("the deletion code is :" + NewlyAddedPostID + "");

	}

	public static String GetRandomString() {
		Random random = new Random();
		String NewTitle = "New_" + random.nextInt();
		return NewTitle;

	}
	
	
//	body(
//			"{\n" 
//					+ "    \"id\":6,\n" 
//					+ "    \"title\":\"" 
//					+ title 
//					+ "\",\n" 
//					+ "    \"author\":\"6th\"\n" + "}")
}

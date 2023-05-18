package CollectionOfRequest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PATCH {
	public static String Randomtitle = GetRandomString();

	@Test

	public void TC1() {
		// base url
		RestAssured.baseURI = "http://localhost:3000";
		//

		Response Resp1 = given().contentType(ContentType.JSON).body(
				"{\n"
				+ "    \n"
				+ "    \"title\":\""+Randomtitle+"\"\n"
				+ "   \n"
				+ "}")
				.when().patch("/posts/2");

		assertEquals(Resp1.statusCode(), 200);
		assertEquals(Resp1.jsonPath().get("title"), Randomtitle);
	
	}

	public static String GetRandomString() {
		Random random = new Random();
		String NewTitle = "New_" + random.nextInt();
		return NewTitle;

	}
	
}

package practice_V2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class RA_02_Section5_Validating_Response {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.Data())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat()
		// Validating Response 
		
		.statusCode(200)
		.body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)");

	}

}

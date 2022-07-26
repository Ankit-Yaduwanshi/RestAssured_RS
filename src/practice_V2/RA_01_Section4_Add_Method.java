package practice_V2;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class RA_01_Section4_Add_Method {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.Data())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);

	}

}

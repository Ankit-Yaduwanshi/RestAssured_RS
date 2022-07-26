import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import genericUtility.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class RestAssured_2_JsonPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String Resp=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.AddPlace()).
		when().post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).body("status", equalTo("OK"))
		.header("server", "Apache/2.4.18 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println(Resp);
		
		JsonPath jp = new JsonPath(Resp);
		String place = jp.getString("place_id");
		System.out.println(place);

	}

}

package practice_V2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RA_03_Section5_ADD_PUT_GET {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// Usig ADD api to add place
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.Data())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
	
		// Using Update Api to change address
		String newAdd = "70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAdd+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get API to validate address updated with given value or not
		String GetResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().extract().response().asString();
		
		JsonPath js1 = new JsonPath(GetResponse);
		String actualAdd = js1.getString("address");
		System.out.println(actualAdd);
		
		Assert.assertEquals(newAdd, actualAdd);
		
		
		
		
		
	}

}

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import genericUtility.Payload;
import genericUtility.ReUseableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RestAssured_3_Add_Update_Get {

	public static void main(String[] args) {
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
		String placeId = jp.getString("place_id");
		System.out.println(placeId);
		
		System.out.println("-------------------Update Request--------------------");
		String NewAddress = "New 11 Kaialsh Nagar-111, BHOPAL";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.UpdatePlace(placeId, NewAddress)).
		when().put("/maps/api/place/update/json").
		then().log().all().assertThat().body("msg", equalTo("Address successfully updated"));
		
		System.out.println("-------------------Get Request--------------------");
		String AddResp = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("/maps/api/place/get/json").
		then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath jpa = ReUseableMethods.rawToJson(AddResp);  //java used here so making it generic
		
		String addres = jpa.getString("address");
		System.out.println(addres);
		
		Assert.assertEquals(addres, NewAddress);
	}

}

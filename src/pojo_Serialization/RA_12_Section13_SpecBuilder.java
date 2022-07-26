package pojo_Serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RA_12_Section13_SpecBuilder {

	public static void main(String[] args) {
RestAssured.baseURI = "https://rahulshettyacademy.com";

//cresting object to add keys:

	AddPlace p = new AddPlace();
	p.setAccuracy(50);
	p.setAddress("24 abcd, col 89");
	p.setLanguage("Eng");
	p.setPhone_number("3434-543-544");
	p.setWebsite("ankit.yad");
	p.setName("Ankit");
	
	List<String> list_types = new ArrayList<>();
	list_types.add("ash shdh");
	list_types.add("holaa");
	p.setTypes(list_types);
	
	Location l = new Location();
	l.setLat(12.34);
	l.setLng(65.98);
	p.setLocation(l);
	
	
		Response res = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(p)
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response();

	}

}

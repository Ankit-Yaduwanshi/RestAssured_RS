package pojo_Serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RA_11_Section12_Serialization {

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
	list_types.add("holaaa");
	p.setTypes(list_types);
	
	Location l = new Location();
	l.setLat(12.34);
	l.setLng(65.98);
	p.setLocation(l);
	
	//Using RequestSpecBuilder:
	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
			 .setContentType(ContentType.JSON).build();
	
		RequestSpecification res = given().spec(req)
		.body(p);
		
	//Using ResponseSpecBuilder
	ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		Response response = res.when().post("maps/api/place/add/json")
		.then().spec(resp).extract().response();
		//.log().all().assertThat().statusCode(200).extract().response();
		
		String stringResponse = response.asString();
		System.out.println(stringResponse);

	}

}

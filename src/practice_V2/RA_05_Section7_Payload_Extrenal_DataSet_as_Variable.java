package practice_V2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import genericUtility.Payload;
import genericUtility.ReUseableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RA_05_Section7_Payload_Extrenal_DataSet_as_Variable {

	@Test
	public static void Payload_External_DataSet_making_as_Variable() {
	// One TC - 1 time run - with new data set - change value in JSON payload by making dataset as Variable
		RestAssured.baseURI = "http://216.10.245.166";
		
		String Resp = given().log().all().header("Content-Type", "application/json")
				
			.body(Payload.AddBook("zaszsx", "2457756"))
			.when().post("/Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
		
		JsonPath js = new JsonPath(Resp);
		String Id= js.get("ID");
		System.out.println(Id);
		
		// deleting the same records as well
		given().log().all().header("Content-Type", "application/json")
		.body(Payload.DeleteBook(Id))
		.when().delete("/Library/DeleteBook.php")
		.then().log().all();
	}
	
}

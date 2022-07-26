package practice_V2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RA_06_Section7_Multiple_DataSet_DataProvider_Parameterization {

	@Test (dataProvider="postBook")
	public void Payload_External_DataSet_making_as_Variable(String isbn, String aisle) {
	// One TC - multiple time run - with new data set - change value in JSON payload 	
	//using DataProvider Annotations TestNg feature
	// no. of arrays in DataProvider Object[][] 2d array make TC run that many time 	
		RestAssured.baseURI = "http://216.10.245.166";
		
		String Resp = given().log().all().header("Content-Type", "application/json")
				
			.body(Payload.AddBook(isbn, aisle))
			.when().post("/Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
			
			JsonPath js = new JsonPath(Resp);
			String Id= js.get("ID");
			System.out.println(Id);	
			
			given().log().all().header("Content-Type", "application/json")
			.body(Payload.DeleteBook(Id))
			.when().delete("/Library/DeleteBook.php")
			.then().log().all();
	}
	@DataProvider(name="postBook")
	public  Object[][] getData() {
		return new Object[][] {{"asae112", "313"},
								{"poswswa", "433"}};
	}
}

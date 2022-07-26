import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.Payload;
import genericUtility.ReUseableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class RestAssured_5_LibraryAPI_DynamicJson_ParameterizeMultiDataDP {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String Resp = given().log().all().header("Content-Type", "application/json")

			//Dynamic JSON Payload with external data
			//.body(Payload.AddBook("apoe1", "1209"))
				
			//Parameterize multiple data sets using TestNG DataProvider	
			.body(Payload.AddBook(isbn, aisle))
			.when().post("/Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();

		JsonPath js = ReUseableMethods.rawToJson(Resp);
		String Id= js.get("ID");
		
		// deleting the same records as well
		given().log().all().header("Content-Type", "application/json")
		.body(Payload.DeleteBook(Id))
		.when().delete("/Library/DeleteBook.php")
		.then().log().all();
		
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		//array is collection of elements
		//mutlidimensional array is a collection of  array
		return new Object[][] {{"asae1", "313"},{"posw", "433"}};
	}
}

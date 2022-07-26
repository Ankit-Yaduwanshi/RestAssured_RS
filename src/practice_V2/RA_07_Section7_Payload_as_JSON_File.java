package practice_V2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RA_07_Section7_Payload_as_JSON_File {

	@Test
	public void addBook_Using_JSON_File() throws IOException {
		RestAssured.baseURI = "http://216.10.245.166";
		
		given().log().all().header("Content-Type", "application/json")
		// 1Task-content of the file to String -> 2java Methods- content of file can be converted into byte 
		//->3byte data to string which body method accepts
		.body(new String(Files.readAllBytes(Paths.get("D:\\Eclipse_Workspace\\eclipse-workspace\\RestAssured\\src\\genericUtility\\testData.json"))))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.body("Msg", equalTo("successfully added"));
	}
}

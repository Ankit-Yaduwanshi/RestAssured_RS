import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class RestAssured_6_Data_JsonFile {
 
	@Test
	public void addBook() throws IOException {
		
RestAssured.baseURI = "http://216.10.245.166";
		
		given().log().all().header("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\win\\eclipse-workspace\\RestAssured\\src\\genericUtility\\testData.json"))))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.body("Msg", equalTo("successfully added"));
	}
}

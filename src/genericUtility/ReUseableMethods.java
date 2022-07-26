package genericUtility;

import io.restassured.path.json.JsonPath;

public class ReUseableMethods {

	public static JsonPath rawToJson(String Response) {
		
		JsonPath jp = new JsonPath(Response);		
		return jp;
	}

}

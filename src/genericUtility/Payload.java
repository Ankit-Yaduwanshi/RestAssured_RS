package genericUtility;

public class Payload {

	public static String AddPlace() {
		String body ="{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Ankit 7\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, Bhopal\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shsiteop\"\r\n" + 
				"  ],\r\n" +
				"  \"website\": \"http://ankityaduwanshi.com\",\r\n" + 
				"  \"language\": \"English-IN\"\r\n" + 
				"}\r\n" + 
				"";
		return body;
	}
	
	public static String UpdatePlace(String placeId, String NewAddress) {
		String body ="{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+NewAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"";
		return body;
	}
	
	public static String CoursePrice() {
		return"{\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"},\r\n" + 
				"\"courses\": [\r\n" + 
				"{\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\"price\": 50,\r\n" + 
				"\"copies\": 6\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\"price\": 40,\r\n" + 
				"\"copies\": 4\r\n" + 
				"},\r\n" +
				"{\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\"price\": 45,\r\n" + 
				"\"copies\": 10\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"Java\",\r\n" + 
				"\"price\": 40,\r\n" + 
				"\"copies\": 4\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"Appiun\",\r\n" + 
				"\"price\": 45,\r\n" + 
				"\"copies\": 10\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
	
	public static String AddBook(String isbn, String aisle) {
		String addb = "{\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"Johny foe\"\r\n" + 
				"}\r\n" + 
				"";
		return addb;
		
	}
	
	public static String DeleteBook(String Id) {
		String del = "{\r\n" + 
				"\"ID\" : \""+Id+"\"\r\n" + 
				"}";
		return del;
		
	}
}

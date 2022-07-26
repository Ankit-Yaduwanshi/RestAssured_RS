import org.testng.Assert;

import genericUtility.Payload;
import io.restassured.path.json.JsonPath;

public class RestAssured_4_ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath jp = new JsonPath(Payload.CoursePrice());
		
//		1. Print No of courses returned by API	
		int count = jp.getInt("courses.size()");
		System.out.println(count);
		
//		2.Print Purchase Amount
		System.out.println(jp.getString("dashboard.purchaseAmount"));
		
//		3. Print Title of the first course
		String co = jp.get("courses[0].title");
		System.out.println(co);
		System.out.println(jp.getString("courses[0].title"));  		//get() method wont work in SYSO use getString()
		System.out.println(jp.get("courses[0].title").toString());	//or either use .toString() method
		
//		4. Print All course titles and their respective Prices
		for(int i=0;i<count;i++) {
		String cor = jp.get("courses["+i+"].title");
		int pr = jp.get("courses["+i+"].price");
		System.out.println("Course name is: "+cor+" Price is: "+pr );
		}
		
		
//		5. Print no of copies sold by RPA Course
		for(int i=0;i<count;i++) {
			String cor = jp.get("courses["+i+"].title");
			int cop = jp.get("courses["+i+"].copies");
			
			if(cor.equalsIgnoreCase("RPA")) {
				System.out.println("No. of copies sold by RSA is : "+cop);
			break;
			}
			}
		
//		6. Verify if Sum of all Course prices matches with Purchase Amount
		int sum=0;
		for(int i=0;i<count;i++) {
			String cor = jp.get("courses["+i+"].title");
			int pri = jp.get("courses["+i+"].price");
			int cop = jp.get("courses["+i+"].copies");
			int amt = pri*cop;
			sum = sum+amt;		
			 if(cor.equalsIgnoreCase("RPA")) 
			 {break;}
			}
		 System.out.println("Total amount is : "+sum);
		 int PurAmt = jp.getInt("dashboard.purchaseAmount");
		 Assert.assertEquals(sum, PurAmt);
		 
	}

}

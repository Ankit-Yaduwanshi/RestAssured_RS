package practice_V2;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class RA_04_Section6_Complex_Resp_Payload {
	public static void main(String[] args) {
		JsonPath js = new JsonPath(Payload.courses);
		
		//1. Print No of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//2.Print Purchase Amount
		String purchaseAmount = js.getString("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		//3. Print Title of the first course
		String titleFirstCourse =  js.getString("courses.title[0]");
		System.out.println(titleFirstCourse);
		
		//4. Print All course titles and their respective Prices
		for(int i=0;i<count;i++) {
			String title = js.getString("courses.title["+i+"]");
			int price = js.getInt("courses.price["+i+"]");
			System.out.println("course title is :"+title+" and price is :"+price);
		}
		
		//5. Print no of copies sold by RPA Course
		//ANS - first we need to find where RPA is present by index, for that we will traverse courses array
		for(int i=0;i<count;i++) {
			String title = js.getString("courses.title["+i+"]");
			if(title.equals("RPA")) {
				System.out.println("copies sold for title :"+title+"  is :"+js.get("courses.copies["+i+"]").toString());
				break;
			}
		}
		//6. Verify if sum of all the courses matches with the purchase amount
		int sum=0;
		for(int i=0;i<count;i++) {
			String cor = js.get("courses["+i+"].title");
			int pri = js.get("courses["+i+"].price");
			int cop = js.get("courses["+i+"].copies");
			int amt = pri*cop;
			sum = sum+amt;
			System.out.println(sum);
			Assert.assertEquals(sum, purchaseAmount);

	}

}
}

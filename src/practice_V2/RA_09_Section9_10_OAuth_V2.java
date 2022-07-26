package practice_V2;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.response.ResponseBody;


public class RA_09_Section9_10_OAuth_V2 {



public static void main(String[] args) throws InterruptedException {

//Step 1: Get Access Code using Google Auth- u get URL which have code, paste that url here
//	Base URI: https://accounts.google.com/o/oauth2/v2/auth
//	Query Param:
//		Scope :	https://www.googleapis.com/auth/userinfo.email
//		Authorization server url :	https://accounts.google.com/o/oauth2/v2/auth
//		Client ID :	692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com
//		redirect URL/Callback URL :	https://rahulshettyacademy.com/getCourse.php
//		response_type : code
	
//https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php	

String url ="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWggmT8SUsF0lKuaf-rRA6XS5GUBQrI99zTQsf-OfB7GM_pFw2DNFBouyO6GY1cFXg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none#";

//Step 2: run Rqst which will give access token based on the CODE
			String partialcode=url.split("code=")[1];
			String code=partialcode.split("&scope")[0];
			System.out.println(code);
			String response =given() 
                .urlEncodingEnabled(false).queryParams("code",code)
                   .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                        .queryParams("grant_type", "authorization_code")
                        .queryParams("state", "verifyfjdss")
                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

                     // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")                  
                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                        .when().log().all()
                        .post("https://www.googleapis.com/oauth2/v4/token").then().log().all().extract().response().asString();

			JsonPath jsonPath = new JsonPath(response);
			    String accessToken = jsonPath.getString("access_token");
			    System.out.println(accessToken);
			    
//Step 3: Using Access Token hitting actual request
			String r2=    given().contentType("application/json").
			queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
			.when().get("https://rahulshettyacademy.com/getCourse.php").asString();
			
			System.out.println(r2);



}



}


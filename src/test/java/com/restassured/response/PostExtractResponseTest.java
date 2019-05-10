package com.restassured.response;

import org.testng.annotations.Test;

import com.restassured.utill.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostExtractResponseTest {
	
	@Test
	public void verifyPostExtract() {
		RestAssured.baseURI=util.baseURI2;
		
		Response rs = given().
		       queryParam("key", "qaclick123").
		body(util.body).
		when().
		post("/maps/api/place/add/json").
		then(). 
		assertThat().
		statusCode(util.RESPONSE_STATUS_CODE_200).and().contentType(ContentType.JSON).
		and().  
		body("status",equalTo("OK")).
		
		//extract
		
		extract().response();
		String responseString= rs.asString();
		System.out.println(responseString);
		
		//Get "place_id from response
		
		JsonPath js = new JsonPath(responseString); 
		String place_id = js.get("status");
		System.out.println(place_id);
	

}
}

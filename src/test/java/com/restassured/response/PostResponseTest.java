package com.restassured.response;

import org.testng.annotations.Test;

import com.restassured.utill.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostResponseTest {
	
	@Test
	public void verifyPost() {
		RestAssured.baseURI=util.baseURI2;
		
		given().
		       queryParam("key", "qaclick123").
		body(util.body).
		when().
		post("/maps/api/place/add/json").
		then(). 
		assertThat().
		statusCode(util.RESPONSE_STATUS_CODE_200).and().contentType(ContentType.JSON).
		and().  
		body("status",equalTo("OK"));
		
	

}
}

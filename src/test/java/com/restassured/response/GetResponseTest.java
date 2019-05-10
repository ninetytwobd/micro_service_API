package com.restassured.response;

import org.testng.annotations.Test;

import com.restassured.utill.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetResponseTest {
	
	@Test
	public void verifyGet() {
		RestAssured.baseURI=util.baseURI;
		
		given().
		       param("page","2").
		when().
		       get("/api/users"). 
		then().
		       assertThat().
		statusCode(util.RESPONSE_STATUS_CODE_200).and().contentType(ContentType.JSON). 
		       body("data[0].first_name",equalTo(util.First_name)). 
		body("data[0].last_name",equalTo(util.Last_name)). 
		       body("data[0].email",equalTo("eve.holt@reqres.in")). 
		body("data[0].avatar",equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg")). 
		       header("X-Powered-By","Express");
	}
	

}

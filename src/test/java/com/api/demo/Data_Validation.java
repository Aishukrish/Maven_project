package com.api.demo;

import org.junit.Test;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Data_Validation {
	@Test
	public void data_validation() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request= RestAssured.given();
		Response response=request.get("api/users/2");
		String string=response.asString();
		System.out.println(string);
		int actual_Code=response.getStatusCode();
		Assert.assertEquals(200, actual_Code);
		System.out.println("Data Validation");
		
	}

}

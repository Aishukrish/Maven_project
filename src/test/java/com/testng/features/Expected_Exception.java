package com.testng.features;

import org.testng.annotations.Test;

public class Expected_Exception {
	@Test(expectedExceptions = ArithmeticException.class)
	private void calculate() {
		int a=10;
		System.out.println(a/0);
		System.out.println("Display the Output");
	}

}

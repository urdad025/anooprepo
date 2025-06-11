package javaOOS;

import org.testng.annotations.*;


public class PS {

	public void doThis() {

		System.out.println("I am doThis method from PS class");
	}

	@BeforeTest
	public void beforeTestRun() {

		System.out.println("Run me First");
	}
	
	@AfterTest
	public void afterTestRun() {

		System.out.println("Run me After");
	}

}

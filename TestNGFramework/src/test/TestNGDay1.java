package test;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDay1 {

	@Test(groups = { "Smoke" })
	public void demo1() {

		System.out.println("hello World Demo 1");
	}

	@Test
	public void demo2() {

		System.out.println("hello World Demo 2");
	}

	@BeforeTest
	public void preCondition() {

		System.out.println("Before Test");
	}

	@AfterTest
	public void postCondition() {

		System.out.println("After Test");
	}

	@BeforeSuite
	public void beforeSuit() {

		System.out.println("Before Suit");
	}

	@AfterSuite
	public void afterSuit() {

		System.out.println("After Suit");
	}

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("****Before Method");
	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("****After Method");
	}

	@Parameters({ "url", "uname" })
//	@Test
	public void parameterTest(String googleURL, String user) {

		System.out.println(googleURL);
		System.out.println(user);
	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getData() {

		// create a data set -> 3 set of user name and password.
		Object[][] data = new Object[3][2];
		data[0][0] = "user1";
		data[0][1] = "pass1";
		data[1][0] = "user2";
		data[1][1] = "pass2";
		data[2][0] = "user3";
		data[2][1] = "pass3";
		return data;
	}

	@Test(dataProvider = "loginCredentials")
	public void pickDataProvider(String uname, String password) {

		System.out.println(uname);
		System.out.println(password);

	}

	@Test
	public void methodForTestFail() {
		Assert.assertTrue(true);
	}

}

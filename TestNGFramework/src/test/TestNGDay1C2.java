package test;


import org.testng.annotations.*;

public class TestNGDay1C2 {

	@Test
	public void webLoginBank() {

		System.out.println("Web Login Bank");

	}

	@Test(groups= {"Smoke"})
	public void mobLoginbank() {

		System.out.println("Mob Login Bank");

	}

	@Test
	public void apiLoginbank() {

		System.out.println("Api Login Bank");

	}
	@BeforeClass
	public void beforeClass() {

		System.out.println("****Before Class TestNGDay1C2");

	}
	@AfterClass
	public void afterClass() {

		System.out.println("***After Class TestNGDay1C2");

	}
	
	@Parameters({"url","uname"}) @Test
	public void parameterTest(String googleURL, String user) {

		System.out.println(googleURL);
		System.out.println(user);
	}
}
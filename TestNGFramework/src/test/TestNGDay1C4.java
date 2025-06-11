package test;

import org.testng.annotations.*;

public class TestNGDay1C4 {
	
	@Test(groups= {"Smoke"})
	public void webLoginHome() {

		System.out.println("Web Login Home");

}
	
	@Test
	public void mobLoginHome() {

		System.out.println("Mob Login Home");

}
	
	@Test
	public void apiLoginHome() {

		System.out.println("Api Login Home");

}
	
	@Parameters({"url","uname"}) @Test
	public void parameterTest(String googleURL, String user) {

		System.out.println(googleURL);
		System.out.println(user);
	}

}

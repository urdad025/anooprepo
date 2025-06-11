package test;

import org.testng.annotations.*;

public class TestNGDay1C3 {

	@Test(groups= {"Smoke"})
	public void webLoginCar() {

		System.out.println("Web Login Car");
	}

	@Test(timeOut=4000)
	public void mobLoginCar() {

		System.out.println("Mob Login Car");
	}

	@Test
	public void apiLoginCar() {

		System.out.println("Api Login Car");
	}
	
	@Test(enabled=true)
	public void chromeLogincar() {

		System.out.println("Chrome Login Car");
	}
	
	@Parameters({"url","uname"}) @Test
	public void parameterTest(String googleURL, String user) {

		System.out.println(googleURL);
		System.out.println(user);
	}
}

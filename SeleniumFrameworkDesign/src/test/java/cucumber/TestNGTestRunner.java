package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="anooppandey.stepDefinitions",monochrome=true,
tags="@Regression",
plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	

}


//Cucumber cannot run by its own. It need testNG or Junit to run.
package anooppandey.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anooppandey.TestComponents.BaseTest;
import anooppandey.TestComponents.Retry;

import anooppandey.pageobjects.MyCart;
import anooppandey.pageobjects.ProductCatalouge;

public class ErrorValidationsTest extends BaseTest {

	@Test (dataProvider = "getData", retryAnalyzer=Retry.class )
	public void loginErrorValidation(HashMap<String, String> input) throws InterruptedException, IOException {

		landingPage.loginApplication(input.get("email"), input.get("wrongpwd"));
		Assert.assertEquals(landingPage.getErrorMessage().trim(), "Incorrect email or password.");

	}

	@Test(groups= {"ErrorHandling"}, dataProvider = "getData")
	public void productErrorValidation(HashMap<String, String> input) throws InterruptedException, IOException {


		ProductCatalouge productCatalouge = landingPage.loginApplication(input.get("email"), input.get("password"));
		productCatalouge.addProductToCart(input.get("productName"));
		MyCart myCart = productCatalouge.goToCart();
		
		

		Boolean match = myCart.prodMatchIncart(input.get("productName"));  // -- need from property file
		Assert.assertTrue(match);

	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataMap(
				System.getProperty("user.dir") + "//src//test//java//anooppandey//data//PurchaseOrder.json");

		return new Object[][] { { data.get(0) },{ data.get(1)} };
	}
	

}

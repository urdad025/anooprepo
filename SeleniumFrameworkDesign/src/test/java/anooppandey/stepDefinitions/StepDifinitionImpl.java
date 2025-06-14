package anooppandey.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import anooppandey.TestComponents.BaseTest;
import anooppandey.pageobjects.CheckOutPage;
import anooppandey.pageobjects.ConfirmationPage;
import anooppandey.pageobjects.LandingPage;
import anooppandey.pageobjects.MyCart;
import anooppandey.pageobjects.ProductCatalouge;
import io.cucumber.java.en.*;

public class StepDifinitionImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalouge productCatalouge;
	ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce page")
	public void I_Landed_on_Ecommerce_Page() throws IOException {

		landingPage = launchApplication();

	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_password(String username, String password) {

		productCatalouge = landingPage.loginApplication(username, password);
	}

	@When("^I add product (.+) from cart$")
	public void add_product_to_cart(String productName) throws InterruptedException {

		productCatalouge.addProductToCart(productName);

	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) throws InterruptedException {

		MyCart myCart = productCatalouge.goToCart();
		Boolean match = myCart.prodMatchIncart(productName);
		Assert.assertTrue(match);

		CheckOutPage checkOutPage = myCart.goToCheckout();

		checkOutPage.selectCountry("India");
		confirmationPage = checkOutPage.submitOrder();
	}

	@Then("{string} message is displayed on confirmarion page")
	public void message_displayed_confirmationPage(String string) {

		String confirmMsg = confirmationPage.getMessage();
		System.out.println(confirmMsg);
		Assert.assertTrue(confirmMsg.trim().equalsIgnoreCase(string));
		System.out.println("submitOrder completed successfully");
		driver.close();

	}

	@Then("{string} message is displayed.")
	public void message_is_displayed(String string) {

		Assert.assertEquals(landingPage.getErrorMessage().trim(), string);
		driver.close();
	}

}

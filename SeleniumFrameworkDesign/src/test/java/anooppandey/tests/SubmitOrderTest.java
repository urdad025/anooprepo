package anooppandey.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anooppandey.TestComponents.BaseTest;
import anooppandey.pageobjects.CheckOutPage;
import anooppandey.pageobjects.ConfirmationPage;
import anooppandey.pageobjects.MyCart;
import anooppandey.pageobjects.OrderHistory;
import anooppandey.pageobjects.ProductCatalouge;

public class SubmitOrderTest extends BaseTest {

	// String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

		// String countryName = "India";

		ProductCatalouge productCatalouge = landingPage.loginApplication(input.get("email"), input.get("password"));
		productCatalouge.addProductToCart(input.get("productName"));
		MyCart myCart = productCatalouge.goToCart();

		Boolean match = myCart.prodMatchIncart(input.get("productName"));
		Assert.assertTrue(match);

		CheckOutPage checkOutPage = myCart.goToCheckout();

		checkOutPage.selectCountry(input.get("countryName"));
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();

		String confirmMsg = confirmationPage.getMessage();

		System.out.println(confirmMsg);
		Assert.assertTrue(confirmMsg.trim().equalsIgnoreCase("Thankyou for the order."));
		 System.out.println("submitOrder completed successfully");

	}

	@Test(dependsOnMethods = { "submitOrder" }, dataProvider = "getData")
	public void orderHistorytest(HashMap<String, String> input) throws InterruptedException {

		ProductCatalouge productCatalouge = landingPage.loginApplication(input.get("email"), input.get("password"));

		OrderHistory orderHistory = productCatalouge.goToOrderHistory();
		Thread.sleep(2000);
		Boolean match = orderHistory.verifyPlacedorder(input.get("productName"));
		Assert.assertTrue(match);
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataMap(
				System.getProperty("user.dir") + "//src//test//java//anooppandey//data//PurchaseOrder.json");

		return new Object[][] { { data.get(0) },{ data.get(1) } };
	}

	// data Provided by HashMap --> Section moved to DataReader.java class to read
	// from PurchaseOrder.json
	/*
	 * @DataProvider
	 * public Object[][] getData() {
	 * 
	 * HashMap<String, String> map = new HashMap<String, String>();
	 * map.put("email","jackreacher007@gmail.com");
	 * map.put("password", "Jack@1234");
	 * map.put("productName", "ZARA COAT 3");
	 * map.put("countryName", "India");
	 * 
	 * HashMap<String, String> map1 = new HashMap<String, String>();
	 * map1.put("email", "yodaso7633@frisbook.com"); map1.put("password",
	 * "Test@1122"); map1.put("productName", "ADIDAS ORIGINAL");
	 * map1.put("countryName", "India");
	 * 
	 * return new Object[][] { { map }, { map1 } }; }
	 */

	// When data provided by Object Array
	/*
	 * 
	 * @DataProvider public Object[][] getData() {
	 * 
	 * 
	 * 
	 * return new Object[][] { {"jackreacher007@gmail.com","","" }, {
	 * "yodaso7633@frisbook.com","","" } }; }
	 */

}

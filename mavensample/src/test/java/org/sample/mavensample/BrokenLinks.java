package org.sample.mavensample;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, IOException {

		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		
		SoftAssert soft=new SoftAssert();
		

		TrustManager[] trustAllCertificates = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		try {
			// Set the default SSL context to trust all certificates
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCertificates, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			e.printStackTrace();
		}

	

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		System.out.println(links.size());

		for (WebElement x : links) {

		//	System.out.println(x.getText() + "----" + x.getDomAttribute("href"));

			String link = x.getDomAttribute("href");

			if (link == null || link.isEmpty() || link.startsWith("#") || link.startsWith("javascript")) {
				//System.out.println("Skipping invalid link: " + link);
				continue;
			} else {

				HttpURLConnection conn = (HttpURLConnection) new URL(link).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int respcode = conn.getResponseCode();
				System.out.println(x.getText()+"***************"+respcode);
				
				//Assert.assertTrue(respcode<400, "The Link with Text "+x.getText()+"is brokrn with code"+ respcode);
				
			/*	if (respcode>400) {
					System.out.println("The Link with Text "+x.getText()+"is brokrn with code"+ respcode);
					Assert.assertTrue(false);*/ //replaced it with the one line code above
				
		
				soft.assertTrue(respcode<400, "The Link with Text "+x.getText()+" is broken with code "+ respcode);	
				
				}
			}
		
		soft.assertAll();
		driver.close();
	}
}

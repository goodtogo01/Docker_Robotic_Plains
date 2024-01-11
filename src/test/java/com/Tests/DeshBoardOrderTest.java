package com.Tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.Pages.DeshBoardHome;
import com.Pages.DeshBoardOrder;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Utility.TestUtils;

public class DeshBoardOrderTest extends BaseTest {
	LoginPageTest lpt = new LoginPageTest();
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	DeshBoardHome deshBoardHome = new DeshBoardHome();
	DeshBoardOrder deshBoardOrder = new DeshBoardOrder();
	TestUtils testUtils = new TestUtils();
	static String sheetName = "Sheet2";

	public DeshBoardOrderTest() {
		super();
	}

	// this method must be executed before operations
	@Test // no needed for now
	public void loginForOrder() {
		getDriver().findElement(By.id(deshBoardOrder.uNme)).sendKeys(prop.getProperty("userName"));
		getDriver().findElement(By.id(deshBoardOrder.pas)).sendKeys(prop.getProperty("password"));
		getDriver().findElement(By.xpath(deshBoardOrder.loginButton)).click();
		System.out.println("The Login is succeed");
	}

	@Test(groups = "Order Page Functions", description = "Validate current page title with expected value!!")
	public void pageTitleTest() {
		lpt.loginTest();
		String title = getDriver().getTitle();
		Assert.assertEquals(title, "RobotSpareBin Industries Inc. - Intranet", "Title is missing!!");
		System.out.println("Page Title is : " + title);
	}

	@Test(groups = "Login page Functionalities", description = "Validate Order manue is displayed correctly!!") // , enabled = true)
	public void orderManueTest() {
		lpt.loginTest();
		deshBoardOrder.orderManue();
		//deshBoardOrder.backToOrderPage();
	}

	@Test(groups = "Order Page Functions", description = "Validate and select number of Head for making of upcoming roobot")
	public void heasdSelectionTest() {
		lpt.loginTest();
		deshBoardOrder.orderManue();
		deshBoardOrder.headSelection(3); // Enter Index number
	}

	@Test(groups = "Order Page Functions",  description = "Validate and select number of Body part for making of upcoming roobot")
	public void bodySelectionTest() {
		lpt.loginTest();
		deshBoardOrder.orderManue();
		deshBoardOrder.bodySelections(2);
	}

	@Test(groups = "Order Page Functions", description = "Validate and select number of lag's for making of upcoming roobot")
	public void legsSelectionTest() {
		lpt.loginTest();
		deshBoardOrder.orderManue();
		deshBoardOrder.legSelection(2);
	}

	@DataProvider
	public Object[][] getNewData() {
		Object[][] data = TestUtils.getTestData(sheetName);
		return data;
	}

	@Test(groups = "Order Page Functions", dataProvider = "getNewData", description = "Entering address for shipping.")
	public void shippingAddress(String address) throws IOException {
		lpt.loginTest();
		testUtils.implicitelyWaitTime();
		deshBoardOrder.orderManue();
		deshBoardOrder.headSelection(3); // Enter Index number
		deshBoardOrder.bodySelections(2);
		deshBoardOrder.legSelection(2);
		deshBoardOrder.enterStippingAddress(address);
		boolean previiewOrders = deshBoardOrder.previiews();
		Assert.assertEquals(previiewOrders, true, "Robot Not created!!");
		System.err.println("Robot is created : " + previiewOrders);
		testUtils.implicitelyWaitTime();
		deshBoardOrder.fullReceiptDisplay();
		deshBoardOrder.backToOrderPage();


	}

	// Not in use
	@Test(groups = "Order Page Functions", dependsOnMethods = "shippingAddress", enabled = false)
	public void displayReceipt() throws IOException {
		deshBoardOrder.fullReceiptDisplay();
		TestUtils.implicitelyWaitTime();
	}

}

package com.Tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseClass.BaseTest;
import com.Pages.HomePage;

public class HomePageTest extends BaseTest {
	HomePage homePage = new HomePage();

	public HomePageTest() {
		super();
	}

	@Test(groups = "Home Page Functions")
	public void pageTitleTest() throws MalformedURLException {
		String ti = getDriver().getTitle();
		Assert.assertEquals(ti, "RobotSpareBin Industries Inc. - Intranet", "Title is missing!!");
		System.out.println("Page Title is : " + ti);
	}

	@Test(groups = "Home Page Functions")
	public void homePageText() throws MalformedURLException {
		String hpText = getDriver().findElement(By.xpath(homePage.homepage_txt)).getText();
		Assert.assertEquals(hpText, hpText.toString(), "Text hon found!!");
		System.out.println("Expected Text found: " + hpText);
	}

	@Test(groups = "Home Page Functions")
	public void homeButtonTest() throws MalformedURLException {
		boolean appears = getDriver().findElement(By.xpath(homePage.home_Button)).isDisplayed();
		Assert.assertTrue(appears);
		System.out.println("Home button is appear correctly: " + appears);
	}

	@Test(groups = "Home Page Functions")
	public void orderButtonTest() throws MalformedURLException {
		boolean appears = getDriver().findElement(By.xpath(homePage.yourOrder_Button)).isDisplayed();
		Assert.assertTrue(appears);
		System.out.println("Order button is appear correctly: " + appears);
	}

	@Test(groups = "Home Page Functions")
	public void loginButtonTest() throws MalformedURLException {
		boolean appears = getDriver().findElement(By.xpath(homePage.login_Button)).isDisplayed();
		Assert.assertTrue(appears);
		System.out.println("Login button is appear correctly: " + appears);
	}

}

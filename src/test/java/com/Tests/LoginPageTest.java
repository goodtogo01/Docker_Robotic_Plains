package com.Tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseClass.BaseTest;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Utility.TestUtils;

public class LoginPageTest extends BaseTest {
	LoginPage loginPage = new LoginPage();
	TestUtils testUtils = new TestUtils();

	public LoginPageTest() {
		super();
	}

	@Test(groups = "Home Page Functions")
	public void pageTitleTest() throws MalformedURLException {
		String title = getDriver().getTitle();
		Assert.assertEquals(title, "RobotSpareBin Industries Inc. - Intranet", "Title is missing!!");
		System.out.println("Page Title is : " + title);
	}

	@Test(groups = "Login page Functionalities")
	public void loginTest() {
		getDriver().findElement(By.id(loginPage.uNme)).sendKeys(prop.getProperty("userName"));
		getDriver().findElement(By.id(loginPage.pas)).sendKeys(prop.getProperty("password"));
		getDriver().findElement(By.xpath(loginPage.loginButton)).click();
		System.out.println("The Login is succeed");

	}

	@SuppressWarnings("static-access")
	@Test(groups = "Login page Functionalities")
	public void displayNameTest() {
		loginTest();
		testUtils.implicitelyWaitTime();
		String name = getDriver().findElement(By.xpath(loginPage.displayUserName)).getText();
		Assert.assertEquals(name, "maria", "Expected user not found!!");
		System.out.println("Display name found as : " + name);
	}
}

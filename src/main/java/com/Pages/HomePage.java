package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseTest;

public class HomePage extends BaseTest {
	// Locators collection
	public String homepage_txt = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]";

	public String home_Button = "//a[contains(text(),'Home')]";

	public String yourOrder_Button = "//a[contains(text(),'Order your robot!')]";

	public String login_Button="//button[contains(text(),'Log in')]";

}
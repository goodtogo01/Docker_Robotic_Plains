package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.BaseClass.BaseTest;

public class LoginPage extends BaseTest {
	// Locators collection
	public String uNme = "username";

	public String pas = "password";

	public String loginButton = "//button[contains(text(),'Log in')]";

	public String displayUserName = "//span[contains(text(),'maria')]";

	public String logoutButton = "//button[@id='logout']";

}

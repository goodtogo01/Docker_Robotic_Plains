package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseTest;

public class DeshBoardHome extends BaseTest {
	// Locators collectios

	public String homeButton = "//a[contains(text(),'Home')]";
	public String firstName = "//input[@id='firstname']";
	public String lastName = "//input[@id='lastname']";
	public String amounts = "//input[@id='salesresult']";

	public String submitButton = "//button[contains(text(),'Submit')]";
	public String showPerformance = "//button[contains(text(),'Show performance')]";

	// Initializing Page Factory

//		public DeshBoardHome() {
//			PageFactory.initElements((WebDriver) driver, this);
//		}

	public HomePage enterSalseData(String fName, String lName, String totalSale) {
		getDriver().findElement(By.xpath(firstName)).sendKeys(fName);
		getDriver().findElement(By.xpath(lastName)).sendKeys(lName);
		getDriver().findElement(By.xpath(amounts)).sendKeys(totalSale);
		getDriver().findElement(By.xpath(submitButton)).click();
		return new HomePage();
	}

	public void displatResult() {
		WebElement element = getDriver().findElement(By.xpath("//*[@id='sales-results']/table"));
		List<WebElement> elementList = element.findElements(By.tagName("tr"));
		for (WebElement we : elementList) {
			System.out.println(we.getText());
		}
	}

	public void bossMessages() {
		getDriver().findElement(By.xpath(showPerformance)).click();
		WebElement element = getDriver().findElement(By.xpath("//*[@id='sales-results']/table"));
		// List<WebElement> rowValue = getDriver().findElements(By.tagName("tr"));
		List<WebElement> elementList = element.findElements(By.tagName("tr"));
		for (int i = 2; i < elementList.size(); i++) {
			System.out.println("Boss Message for salse performance:- " + elementList.get(2).getText());

		}
	}

}

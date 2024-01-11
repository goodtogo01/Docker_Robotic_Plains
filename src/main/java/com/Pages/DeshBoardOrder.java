package com.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BaseClass.BaseTest;
import com.Utility.TestUtils;

public class DeshBoardOrder extends BaseTest {
	// Locators collection
	public String uNme = "username";
	public String pas = "password";
	public String loginButton = "//button[contains(text(),'Log in')]";
	public String displayUserName = "//span[contains(text(),'maria')]";

	public String logoutButton = "//button[@id='logout']";
	public String orderButton = "//a[contains(text(),'Order your robot!')]";
	public String allertButton = "//button[contains(text(),'OK')]";
	public String listOfRadioButton = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]";
	public String finalOrder = "//button[@id='order']";
	public String previiewButton = "//button[@id='preview']";
	public String orderAnother = "//button[@id='order-another']";
	public String orderPgeTxt = "//h2[contains(text(),'Build and order your robot!')]";
	public String orderReceipt = "//div[@id='receipt']";
	public String totalParts = "//div[@id='parts']";
	public String orderID = "//p[@class='badge badge-success']";
	public String head = "//label[contains(text(),'1. Head:')]";
	public String listOfHead = "//select[@id='head']"; // select class
	public String body = "//label[contains(text(),'2. Body:')]";
	public String legs = "//label[contains(text(),'3. Legs:')]";
	public String sizeOfLegs = "//input[@type='number']"; // select class
	public String shippingAddress = "//input[@id='address']";
	public String roobotImage = "//div[@id='robot-preview-image']";
	//WebElement rec =getDriver().findElement(By.xpath("//div[@id='receipt']"));
	// Page Factory initializations
//		public DeshBoardOrder() {
//			PageFactory.initElements((WebDriver) driver, this);
//		}

	public void orders() {
		getDriver().findElement(By.xpath(orderButton)).click();
	}

	public String orderPageDisplay() {
		String pageText = getDriver().findElement(By.xpath(orderPgeTxt)).getText();
		return pageText;
	}

	public void orderManue() {
		getDriver().findElement(By.xpath(orderButton)).click();
		getDriver().findElement(By.xpath(allertButton)).click();

	}

	// Head Selection
	public void headSelection(int indx) {
		String heads = getDriver().findElement(By.xpath(head)).getText();
		System.out.println("We are on the section number : " + heads);
		Select se = new Select(getDriver().findElement(By.xpath(listOfHead)));
		se.selectByIndex(indx);
		System.out.println("Available Item in the list is : ");
		for (int i = 1; i < se.getOptions().size(); i++) {
			System.out.println(se.getOptions().get(i).getText());
		}
		System.err.println("\nSelected Head is : " + se.getOptions().get(indx).getText() + "\n");
	}

	// Body Section
	public void bodySelections(int bodyNum) {
		String bodys = getDriver().findElement(By.xpath(body)).getText();
		System.out.println("We are on " + bodys);
		String radioButtons = getDriver().findElement(By.xpath(listOfRadioButton)).getText();
		for (int i = 1; i < radioButtons.length(); i++) {
			System.out.println(radioButtons);
			break;
		}
		// Select radio based on requirements
		String xpathHead = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[";
		String xpathTail = "]/label[1]";
		getDriver().findElement(By.xpath(xpathHead + bodyNum + xpathTail)).click();
		System.err.println("\nSelected Body is : "
				+ getDriver().findElement(By.xpath(xpathHead + bodyNum + xpathTail)).getText() + "\n");
	}

	// Leg Section
	public void legSelection(int legsCount) {
		String num = String.valueOf(legsCount);
		String numberOflegs = getDriver().findElement(By.xpath(legs)).getText();
		System.out.println("We are on : " + numberOflegs);
		getDriver().findElement(By.xpath(sizeOfLegs)).sendKeys(num);
		System.err.println("Total Lags count for this robot is : " + legsCount + "\n");
		// System.out.println("\nSelected Item from the list is : "
		// +select.getOptions().get(legsCount).getText());
	}

	public void enterStippingAddress(String address) {
		getDriver().findElement(By.xpath(shippingAddress)).sendKeys(address);
	}

	public boolean previiews() {
		getDriver().findElement(By.xpath(previiewButton)).click();
		boolean robotDiplayed = getDriver().findElement(By.xpath(roobotImage)).isDisplayed();
		return robotDiplayed;
	}

	public void orderSepcificDetails() {
		String orderId = getDriver().findElement(By.xpath(orderID)).getText();
		System.out.println("Order ID : " + orderId);
		String partsDetails = getDriver().findElement(By.xpath(totalParts)).getText();
		System.out.println("Number of Parts in the roobot : " + partsDetails);

	}

	public void fullReceiptDisplay()  {
		getDriver().findElement(By.xpath(finalOrder)).click();
		 
		String orders = getDriver().findElement(By.xpath(orderReceipt)).getText();
		System.out.println("\nFinal Receipts of order: " + orders + "\n");
		//TestUtils.takeScreenShootSpecificElement(rec);

	}

	public void backToOrderPage() {
		getDriver().findElement(By.xpath(orderAnother)).click();
		getDriver().findElement(By.xpath(allertButton)).click();
 		System.out.println("Back To Order Roobot Page. ");
		String txt = getDriver().findElement(By.xpath(orderPgeTxt)).getText();
		Assert.assertEquals(txt, "Build and order your robot!", "Expected Text is missing!!");
		System.out.println("Text Found as : " + txt + "\n");
	}
}

package com.Tests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.Pages.DeshBoardHome;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Utility.TestUtils;



public class DeshBoardHomeTest extends BaseTest {
	LoginPageTest lpt =new LoginPageTest();
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	DeshBoardHome deshBoardHome = new DeshBoardHome();
	TestUtils testUtils = new TestUtils();
	static String sheetName = "Sheet3";

	@Test(groups = "Desh Board Page Functions")
	public void pageTitleTest() {
		String ti = getDriver().getTitle();
		Assert.assertEquals(ti, "RobotSpareBin Industries Inc. - Intranet", "Title is missing!!");
		System.out.println("Page Title is : " + ti);
	}

	@DataProvider
	public Object[][] getNewData() {
		Object[][] data = TestUtils.getTestData(sheetName);
		return data;
	}

	@Test(groups = "Desh Board  Functions", dataProvider = "getNewData")
	public void salseDataTest(String firstname, String lastname, String amounts) {
	lpt.loginTest();
		 TestUtils.implicitelyWaitTime();
		deshBoardHome.enterSalseData(firstname, lastname, amounts);
	//	TestUtils.implicitelyWaitTime();
		deshBoardHome.displatResult();
 	TestUtils.implicitelyWaitTime();
		deshBoardHome.bossMessages();
	}
}
/*
 * @Test(groups = "Desh Board Functions", priority=3) public void
 * desplayResults() { deshBoardHome.displatResult(); }
 * 
 * @Test(groups = "Desh Board  Functions", priority = 3, dependsOnMethods
 * ="salseDataTest" ) public void bossMessageValidation(String firstname, String
 * lastname, String amounts) {
 * loginPage.enterCredentials(prop.getProperty("userName"),
 * prop.getProperty("password")); TestUtils.implicitelyWaitTime();
 * deshBoardHome.enterSalseData(firstname, lastname, amounts);
 * TestUtils.implicitelyWaitTime(); deshBoardHome.bossMessages(); }
 */

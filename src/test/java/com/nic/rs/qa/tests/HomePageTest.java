package com.nic.rs.qa.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nic.rs.qa.base.BasePage;
import com.nic.rs.qa.pages.HomePage;
import com.nic.rs.qa.util.CommonUtil;
import com.nic.rs.qa.util.ExcelUtil;




public class HomePageTest  {

	HomePage homePage;
	BasePage basePage;
	Properties prop;
	WebDriver driver;

	
	
	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		
		prop = basePage.initialize_properties();
		
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.MediumWait();
		homePage = new HomePage(driver);
		

	}

	/*
	 * @Test public void searchOmahaTest() throws InterruptedException {
	 * 
	 * homePage = new HomePage(driver);
	 * 
	 * homePage.searchOmaha();
	 * 
	 * }
	 */

	@Test(dataProvider = "getTestData")
	public void HomePage_verifySearchTest(String CityAndState,String HomePageUrl, String SRPPageURL) throws InterruptedException {

		homePage = new HomePage(driver);

		homePage.clickonSearchButton(CityAndState,HomePageUrl,SRPPageURL);
		Assert.assertEquals(driver.getCurrentUrl(), SRPPageURL);

	}

	/*
	 * @Test public void verifyForclosureLinkTest() throws InterruptedException {
	 * 
	 * homePage = new HomePage(driver);
	 * 
	 * homePage.clickOnForeclosureLink();
	 * 
	 * }
	 * 
	 * @Test public void verifyRentToOwnLinkTest() throws InterruptedException {
	 * 
	 * homePage = new HomePage(driver);
	 * 
	 * homePage.clickOnRentToOwnLink();
	 * 
	 * }
	 * 
	 * @Test public void verifyLearnMoreButton() throws InterruptedException {
	 * 
	 * homePage = new HomePage(driver);
	 * 
	 * homePage.clickOnLearnMoreButton();
	 * 
	 * }
	 * 
	 * @Test public void verifyReadMoreArticles() throws InterruptedException {
	 * 
	 * homePage = new HomePage(driver);
	 * 
	 * homePage.clickOnReadMoreArticles(); ;
	 * 
	 * }
	 */

	@AfterMethod
	public void tearDown() throws IOException {
		
		driver.quit();
	}

	
	@DataProvider(name = "getTestData")
	public Object[][] getTestData() {
		Object testData[][] = ExcelUtil.getTestData("TestData");
		return testData;
	}
}

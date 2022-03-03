package com.nic.rs.qa.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nic.rs.qa.base.BasePage;
import com.nic.rs.qa.pages.HomePage;
import com.nic.rs.qa.pages.SRPPage;
import com.nic.rs.qa.util.CommonUtil;

public class SRPPageTest  {
	
	HomePage homePage;
   SRPPage  srpPage;
	Properties prop;
	WebDriver driver;
	BasePage basePage;

	public SRPPageTest() {
		super();
	}
	
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
	 * @Test public void verifyHomeTypeFilter() throws InterruptedException {
	 * 
	 * srpPage=new SRPPage(driver);
	 * 
	 * srpPage.clickonHomeType();
	 * 
	 * }
	 * 
	 * 
	 * @Test public void verifybedsAndBathFilter() throws InterruptedException {
	 * 
	 * srpPage=new SRPPage(driver);
	 * 
	 * srpPage.clickonBedsAndBaths();
	 * 
	 * }
	 */
	 

	@AfterMethod
	public void tearDown() throws IOException{
		
		driver.close();
	}

}

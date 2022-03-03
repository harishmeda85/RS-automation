package com.nic.rs.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nic.rs.qa.base.BasePage;
import com.nic.rs.qa.util.CommonUtil;

public class SRPPage extends BasePage{
	
 HomePage homePage;
	
	@FindBy(xpath = "//body/div[@id='__next']/main[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/button[1]")
	public WebElement homeTypeDropDown;

	
	
	@FindBy(xpath = "//span[normalize-space()='Beds & Baths']")
	public WebElement bedsAndBaths;
	
	@FindBy(xpath = "//button[contains(text(),'Single Family Home')]")
	public WebElement singleFamilyHome;
	
	@FindBy(xpath = "//button[contains(text(),'Contdo / Towhome')]")
	public WebElement towHome;
	
	@FindBy(xpath = "//button[contains(text(),'Commercial')]")
	public WebElement commercial;
	
	@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='Search'])[1]")
	public WebElement searchBtnInHomeType;
	
	@FindBy(xpath = "(//button[normalize-space()='Search'])[1]")
	public WebElement searchBtnInBedsAndBaths;
	
	
	@FindBy(xpath = "//body/div[@id='__next']/main[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[4]")
	public WebElement beds_3;
	
	@FindBy(xpath = "//body/div[@id='__next']/main[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button[3]")
	public WebElement baths_2;
	
	@FindBy(xpath = "//span[contains(text(),'More Filters')]")
	public WebElement moreFilters;
	
	@FindBy(xpath = "//button[normalize-space()='Sale Type']")
	public WebElement saleTypeInMoreFilters;
	
	
	
	@FindBy(xpath = "//button[normalize-space()='Pre-Foreclosure NOD']")
	public WebElement preforeclosureSaleTypeInMoreFilters;
	
	@FindBy(xpath = "//button[normalize-space()='VA Foreclosure']")
	public WebElement vaForeclosureSaleTypeInMoreFilters;
	
	@FindBy(xpath = "//button[normalize-space()='Short Sales']")
	public WebElement shortSale_SaleTypeInMoreFilters;
	
	
	
	@FindBy(xpath = "//button[normalize-space()='REO Foreclosure']")
	public WebElement reoForeclosureSaleTypeInMoreFilters;
	
	
	@FindBy(xpath = "//button[normalize-space()='Special Options']")
	public WebElement specialOptionsSaleTypeInMoreFilters;
	
	@FindBy(xpath = "//button[normalize-space()='Rent to Own Potential']")
	public WebElement rentToOwnSpecialOptionsInMoreFilters;
	
	//button[normalize-space()='Bargain Price']
	
	@FindBy(xpath = "//button[normalize-space()='Bargain Price']")
	public WebElement bargainPriceSpecialOptionsInMoreFilters;

	WebDriver driver;
	
	public SRPPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonHomeType(String CityAndState,String HomePageUrl, String SRPPageURL) throws InterruptedException {
		
		homePage=new HomePage(driver);
		homePage.clickonSearchButton(CityAndState,HomePageUrl,HomePageUrl);
	        
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.elementToBeClickable(homeTypeDropDown)).click();
	     wait.until(ExpectedConditions.elementToBeClickable(singleFamilyHome)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(searchBtnInHomeType)).click();
	    CommonUtil.MediumWait();
	    Thread.sleep(20000);
		   String expectedUrl="https://master.d1kf438yw3sssi.amplifyapp.com/or/morrow-county/boardman/foreclosures/pt-singlefamilyhome";
		  //  Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		 
				}
	
	
public void clickonBedsAndBaths(String CityAndState,String HomePageUrl, String SRPPageURL) throws InterruptedException {
		
	homePage=new HomePage(driver);
	homePage.clickonSearchButton(CityAndState,HomePageUrl,HomePageUrl);
	        
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.elementToBeClickable(bedsAndBaths)).click();
	     wait.until(ExpectedConditions.elementToBeClickable(beds_3)).click();
	     wait.until(ExpectedConditions.elementToBeClickable(baths_2)).click();
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("javascript:window.scrollBy(5550,6000)");
	    wait.until(ExpectedConditions.elementToBeClickable(searchBtnInBedsAndBaths)).click();
	    CommonUtil.MediumWait();
	    Thread.sleep(20000);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   String expectedUrl="https://master.d1kf438yw3sssi.amplifyapp.com/or/morrow-county/boardman/foreclosures/beds-3/baths-2";
		  //  Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		 
				}
}

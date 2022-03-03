package com.nic.rs.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nic.rs.qa.base.BasePage;
import com.nic.rs.qa.util.CommonUtil;
import com.nic.rs.qa.util.ElementActions;





public class HomePage extends BasePage {
	
	WebDriver driver;
	
	ElementActions elementActions;

	@FindBy(xpath = "//input[@placeholder='Address, City, Zip']")
	public WebElement searchBox; 
	
	@FindBy(linkText= "Omaha, AR")
	public WebElement dropDownList; 
	
	@FindBy(xpath="//span[@class='d-none d-md-block']")
	public WebElement searchButton;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/div[3]/p[1]")
	public WebElement pageHeading;
	
	@FindBy(xpath="//body/div[@id='__next']/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/a[1]/*[1]")
	public WebElement forclosureLink;
	
	
	@FindBy(xpath="//body/div[@id='__next']/main[1]/section[1]/div[1]/div[3]/div[1]/div[2]/a[1]/*[1]")
	public WebElement rentOwnLink;
	
	@FindBy(css="button[class='mt-2 btn btn-primary']")
	public WebElement learnMoreButton;
	
	
	
	@FindBy(css=".h-100.SearchBanner_gradient__2Ti1j.d-flex.flex-column.align-items-center.justify-content-center")
	public WebElement clickOnPage;
	
	
	@FindBy(xpath="//h1[contains(text(),'Learning Center')]")
	public WebElement learningCenterPageHeading;
	
	
	@FindBy(xpath="//body/div[@id='__next']/main[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]")
	public WebElement selectOption;
	
	@FindBy(xpath="//span[normalize-space()='Read More Articles']")
	public WebElement readMoreArticles;
	
	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
public void clickonSearchButton(String CityAndState,String HomePageUrl, String SRPPageURL) throws InterruptedException {
		
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(250,350)");
        
	/*
	 * WebDriverWait wait = new WebDriverWait(driver, 30);
	 * wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	 */
    
	/*
	 * Actions action = new Actions(driver);
	 * 
	 * action.moveByOffset(200,100).perform(); Thread.sleep(10000); action.click();
	 */
    searchBox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    searchBox.sendKeys(CityAndState);
	/*
	 * clickOnPage.click(); CommonUtil.MediumWait(); selectOption.click();
	 */
 
    searchButton.click();
    //searchBox.sendKeys(Keys.ENTER);
    CommonUtil.shortWait();
      ;
  
	    String expectedForclosureText=pageHeading.getText().replaceAll("[0-9]","").replaceAll("[^a-zA-Z0-9]","").trim();
	    System.out.println(expectedForclosureText);
	   // Assert.assertEquals("ForeclosuresforSale", expectedForclosureText);
	 
			}
	
public void searchOmaha() throws InterruptedException {
	
		
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(250,350)");
    Actions action = new Actions(driver);

    action.moveByOffset(200,100).perform();  
    Thread.sleep(10000);
    action.click();
        searchBox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    
        searchBox.sendKeys("Omaha");

        searchBox.sendKeys(Keys.ENTER);
        
        CommonUtil.MediumWait();
     
        String expectedForclosureText=pageHeading.getText().replaceAll("[0-9]","").replaceAll("[^a-zA-Z0-9]","").trim();
	    System.out.println(expectedForclosureText);
	   // Assert.assertEquals("ForeclosuresforSale", expectedForclosureText);
	 
			}

	
public void clickOnForeclosureLink() {
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(750,1050)");
 

	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(forclosureLink)).click();
	
    CommonUtil.MediumWait();
    String expectedForclosureText=pageHeading.getText().replaceAll("[0-9]","").replaceAll("[^a-zA-Z0-9]","").trim();
    System.out.println(expectedForclosureText);
  //  Assert.assertEquals("ForeclosuresforSale", expectedForclosureText);
 
		}
	
public void clickOnRentToOwnLink() {
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(950,1550)");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(rentOwnLink)).click();

    CommonUtil.MediumWait();
    
    
    String expectedRentToOwnText=pageHeading.getText().replaceAll("[0-9]","").replaceAll("[^a-zA-Z0-9]","").trim();
    System.out.println(expectedRentToOwnText);
  //  Assert.assertEquals("RenttoOwn", expectedRentToOwnText);
 
		}
	
public void clickOnLearnMoreButton() {
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(3050,4500)");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(learnMoreButton)).click();

    CommonUtil.MediumWait();
    String learningCenterPageHeadingText=learningCenterPageHeading.getText();
  
    System.out.println(learningCenterPageHeading);
   // Assert.assertEquals("Learning Center", learningCenterPageHeadingText);
 
		}
	
	
public void clickOnReadMoreArticles() {
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(3050,5500)");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(readMoreArticles)).click();

    CommonUtil.MediumWait();
    String learningCenterPageHeadingText=learningCenterPageHeading.getText();
  
    System.out.println(learningCenterPageHeading);
  //  Assert.assertEquals("Learning Center", learningCenterPageHeadingText);
 
		}
	
	
	
	
	
	

}

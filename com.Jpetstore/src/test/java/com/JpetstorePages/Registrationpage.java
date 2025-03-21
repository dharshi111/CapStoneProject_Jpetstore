package com.JpetstorePages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.JpetstoreUtility.Reports;
import com.StepDefinition.Hook;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Registrationpage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public Registrationpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
		 
	}

//locators for signin
	By enter = By.xpath("//a[text()='Enter the Store']");
	By sigin = By.linkText("Sign In");
	By username = By.name("username");
	By password = By.name("password");
	By loginbutton = By.name("signon");
    By errormsg=By.xpath("//li[text()='Invalid username or password.  Signon failed.']");
 
//locators for user information
	By register = By.linkText("Register Now!");
	By userid = By.name("username");
	By newpassword = By.name("password");
	By repeatedpassword = By.name("repeatedPassword");

//locators for Account information
	By firstname = By.name("account.firstName");
	By lastname = By.name("account.lastName");
	By email = By.name("account.email");
	By phone = By.name("account.phone");
	By address1 = By.name("account.address1");
	By address2 = By.name("account.address2");
	By city = By.name("account.city");
	By state = By.name("account.state");
	By zip = By.name("account.zip");
	By country = By.name("account.country");

//locators for profile information
	By languagerpeference = By.xpath("//select[@name='account.languagePreference']/option[@value='english']");
	//By category = By.xpath("//select[@name='account.favouriteCategoryId']/option[3]");
	By category = By.xpath("//select[@name='account.favouriteCategoryId']/option[text()='REPTILES']");
	By list = By.xpath("//input[@name='account.listOption']");
	By banner = By.xpath("//input[@name='account.bannerOption']");
	By saveaccountinformation = By.name("newAccount");
//clicking enter the website link
	public void enterlink() {
		driver.findElement(enter).click();
	}
//clicking sigin link
	public void signin() {

		driver.findElement(sigin).click();
	}
//entering registration Details
	public void details() {
		driver.findElement(register).click();
		driver.findElement(userid).sendKeys("usersnumbers");
		driver.findElement(newpassword).sendKeys("pass112233");
		driver.findElement(repeatedpassword).sendKeys("pass11");
		driver.findElement(firstname).sendKeys("dharshini");
		driver.findElement(lastname).sendKeys("R");
		driver.findElement(address1).sendKeys("anna nagar");
		driver.findElement(address2).sendKeys("anna nagar");
		driver.findElement(email).sendKeys("dharsh@gmail.com");
		driver.findElement(phone).sendKeys("9644635512");
		driver.findElement(city).sendKeys("chennai");
		driver.findElement(state).sendKeys("tamilnadu");
		driver.findElement(zip).sendKeys("6293002");
		driver.findElement(country).sendKeys("india");
		driver.findElement(languagerpeference).click();
		driver.findElement(category).click();
		driver.findElement(list).click();
		driver.findElement(banner).click();
	}
   //checking account is created or not
	public boolean accountButton() {
		
		
		boolean actResult = true;
		try {
			driver.findElement(saveaccountinformation).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(sigin));
		
			Reports.generateReport(driver, test, Status.PASS,"Account is created");
		
	
		}catch(TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL,"Account is not created");
		}
		return actResult;
	}
	//entering user and password
    public void validusername(String user) {
    	driver.findElement(username).clear();
    	driver.findElement(username).sendKeys(user);
    }
    public void validpassword(String pass) {
    	driver.findElement(password).clear();
    	driver.findElement(password).sendKeys(pass);
    }
    public void invalidusername(String user) {
    	driver.findElement(username).clear();
    	driver.findElement(username).sendKeys(user);
    }
    public void invalidpassword(String pass) {
    	driver.findElement(password).clear();
    	driver.findElement(password).sendKeys(pass);
    }
    //checking login is success or not
	public boolean Login() {
		boolean actResult = true;
	
try {
	driver.findElement(loginbutton).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(errormsg));
	Reports.generateReport(driver, test, Status.FAIL,"Login is failure");
	}catch(TimeoutException te) {
	actResult = true;
	Reports.generateReport(driver, test, Status.PASS,"Login is success");
}
return actResult;
}
	//checking password recovery
	public boolean isPasswordRecoveryLinkAbsent() {
	    boolean result = true;
	    try {
	      
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Forgot Password")));
	        result = true;
	    } catch (TimeoutException e) {
	        result = false;  
	        Reports.generateReport(driver, test, Status.FAIL, "Password recovery link is absent.");
	    } catch (NoSuchElementException e) {
	        result = false; 
	        Reports.generateReport(driver, test, Status.FAIL, "Password recovery link is absent.");
	    }
	    return result;
	}

	}
	

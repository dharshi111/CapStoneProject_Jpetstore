package com.JpetstorePages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.JpetstoreUtility.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Searchpage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public Searchpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
		 
	}
//locators for search functionality
By searchfield=By.name("keyword");
By searchbutton=By.name("searchProducts");
By firstpet=By.xpath("//div[@id='QuickLinks']/a[1]");
By firstproduct=By.xpath("//a[text()='FI-SW-01']");
By firstitem=By.xpath("//a[text()='EST-2']");
By seconditem=By.xpath("//a[text()='EST-1']");
//locators for addtocart
By cartbutton=By.linkText("Add to Cart");
By proceedtocheckout=By.linkText("Proceed to Checkout");
By checkbox=By.xpath("//input[@name='shippingAddressRequired']");
By continuebutton1=By.name("newOrder");
By continuebutton2=By.name("newOrder");
By confirmbutton=By.linkText("Confirm");
By removebutton=By.xpath("//table/tbody/tr[3]/td[8]");
//searching for pets
public void enter() {
	
	  driver.findElement(searchfield).sendKeys("pets");
	  
}
//clicking search button
public void search() {
driver.findElement(searchbutton).click();
}

//verifying search field
public boolean verifysearchfield() {
	boolean actResult = true;
	try {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
	
		Reports.generateReport(driver, test, Status.PASS,"search button is available");
	

	}catch(TimeoutException te) {
		actResult = false;
		Reports.generateReport(driver, test, Status.FAIL,"search button is not available ");
	}
	return actResult;
}

//verifying product is selected or not
public boolean checksearch() {
    boolean actResult = true;
    driver.findElement(firstpet).click();
    driver.findElement(firstproduct).click();
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(firstitem));
      driver.findElement(firstitem).click();
      Reports.generateReport(driver, test, Status.PASS,"selecting the product is success");
    
    	 } catch (TimeoutException te) {
        
        actResult = false;
        Reports.generateReport(driver, test, Status.FAIL,"selecting the product is failed") ;
    }

    return actResult;
}

//verifying pricefilter is there or not
public boolean pricefilter() {
    boolean result = true;
    try {
     
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("price")));
        result = true; 
    } catch (TimeoutException e) {
        result = false; 
        Reports.generateReport(driver, test, Status.FAIL, "Price filter link is absent.");
    } catch (NoSuchElementException e) {
        result = false;
        Reports.generateReport(driver, test, Status.FAIL, "Price filter link is absent.");
    }
    return result;
}

//verifying languagefilter is there or not
public boolean languagefilter() {
    boolean result = true;
    try {
       
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("language")));
        result = true; 
    } catch (TimeoutException e) {
        result = false;  
        Reports.generateReport(driver, test, Status.FAIL, "Language filter link is absent.");
    } catch (NoSuchElementException e) {
        result = false; 
        Reports.generateReport(driver, test, Status.FAIL, "Language filter link is absent.");
    }
    return result;
}

//selecting firstproduct from list
public void selectproduct() {
	 driver.findElement(firstpet).click();
	    driver.findElement(firstproduct).click();
}

//validating product title
public boolean validproductTitle() {
	 
    boolean actResult;
    String expectedTitle = "Angelfish"; 
    String actualTitle = driver.findElement(By.xpath("//h2[text()='Angelfish']")).getText();

  
    if (actualTitle.equals(expectedTitle)) {
        actResult = true;
        Reports.generateReport(driver, test, Status.PASS, "Title is matched");
    } else {
        actResult = false;
        Reports.generateReport(driver, test, Status.FAIL, "Title is not matched");
    }

    return actResult;
}

//validating product description
public boolean validDescription() {
	
	 driver.findElement(firstitem).click();  
	boolean actresult;
	String expected="Small Angelfish";
	 String actual = driver.findElement(By.xpath("//table/tbody/tr[3]")).getText();

	    if (actual.equals(expected)) {
	    	actresult = true;
	        Reports.generateReport(driver, test, Status.PASS, "description is matched");
	    } else {
	    	actresult = false;
	        Reports.generateReport(driver, test, Status.FAIL, "description is not matched");
	    }

	    return actresult;
}

//validating product price 
public boolean price() {
	
	    
	boolean actresult;
	String expected="$16.50";
	 String actual = driver.findElement(By.xpath("//table/tbody/tr[6]")).getText();

	    if (actual.equals(expected)) {
	    	actresult = true;
	        Reports.generateReport(driver, test, Status.PASS, "price is matched");
	    } else {
	    	actresult = false;
	        Reports.generateReport(driver, test, Status.FAIL, "price is not matched");
	    }

	    return actresult;
}

//checking availability of product
public boolean checkAvailability() {
    boolean actResult = true;  
    String expected = "in stock";

    try {
        // Use findElements() to avoid exceptions if the element is not found
        List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr[contains(., 'in stock')]"));
        
        // Check if the element is found
        if (elements.size() > 0) {
            // If the element is found, get the text and check if it contains the expected text
            String actual = elements.get(0).getText().trim();

            if (actual.contains(expected)) {
                actResult = true;
                Reports.generateReport(driver, test, Status.PASS, "Product is in stock");
            } else {
                actResult = false;
                Reports.generateReport(driver, test, Status.FAIL, "Product is not in stock");
            }
        } else {
            // If no elements are found, report the failure
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Product is not in stock");
        }
    } catch (Exception e) {
        // Catch any unexpected exceptions and report the failure
        actResult = false;
        Reports.generateReport(driver, test, Status.FAIL, "An unexpected error occurred ");
    }

    return actResult;
}



//checking cart button is there or not
public boolean addtocart() {
	boolean actResult = true;
	try {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartbutton));
	
		Reports.generateReport(driver, test, Status.PASS,"cart button is available");
	

	}catch(TimeoutException te) {
		actResult = false;
		Reports.generateReport(driver, test, Status.FAIL,"cart button is not available ");
	}
	return actResult;
}

//verify the product is in cart or not
public boolean verifyCart() {
	driver.findElement(cartbutton).click();
    boolean actResult;
    String expected = "Your cart is empty."; 
    String actual = driver.findElement(By.xpath("//a[text()='EST-2']")).getText(); 

    if (actual.equals(expected)) {
        actResult = false; 
        Reports.generateReport(driver, test, Status.FAIL, "Cart is empty"); 
    } else {
        actResult = true;  
        Reports.generateReport(driver, test, Status.PASS, "Cart is not empty");
    }

    return actResult;
}

//clicking checkout button
public void clickcheckout() {
	driver.findElement(proceedtocheckout).click();
	driver.findElement(By.name("username")).sendKeys("userid");
	driver.findElement( By.name("password")).clear();
	driver.findElement( By.name("password")).sendKeys("pass123");
	driver.findElement( By.name("signon")).click();
	driver.findElement(By.xpath("//img[@name='img_cart']")).click();

	driver.findElement(proceedtocheckout).click();
}

//clicking checkbox
public void checkbox() {
	 driver.findElement(checkbox).click();
}

//clicking continue button
public void clickcontinue() {
  
   driver.findElement(continuebutton1).click();
   driver.findElement(continuebutton2).click();
}

//clicking confirm button
public void confirmbutton() {
	driver.findElement(confirmbutton).click();
}

//checking order submitted button
public boolean verifymessage() {
    boolean actResult;
    String expected = "Thank you, your order has been submitted."; 
    String actual = driver.findElement(By.xpath("//li[text()='Thank you, your order has been submitted.']")).getText();

    if (actual.equals(expected)) {
        actResult = true; 
        Reports.generateReport(driver, test, Status.PASS, "order is confirmed"); 
    } else {
        actResult = true;  
        Reports.generateReport(driver, test, Status.PASS, "order is not confirmed");
    }

    return actResult;
}

public void  fistproduct() {
	  driver.findElement(firstpet).click();
	    driver.findElement(firstproduct).click();
	    driver.findElement(firstitem).click();
	    driver.findElement(cartbutton).click();
}
public void secondproduct() {
	  driver.findElement(firstpet).click();
	    driver.findElement(firstproduct).click();
	    driver.findElement(seconditem).click();
	    driver.findElement(cartbutton).click();
}

public boolean cartupdate() {
	boolean actResult = true;
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstitem));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seconditem));
	
		Reports.generateReport(driver, test, Status.PASS,"cart is updated");
	

	}catch(TimeoutException te) {
		actResult = false;
		Reports.generateReport(driver, test, Status.FAIL,"cart is not updated");
	}
	return actResult;
}
public void removebutton() {
	driver.findElement(removebutton).click();
}
public boolean remove() {
	
	boolean actResult = false;
	try {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(seconditem));
	
		Reports.generateReport(driver, test, Status.FAIL,"product is not removed from cart");
	

	}catch(TimeoutException te) {
		actResult = true;
		Reports.generateReport(driver, test, Status.PASS,"product is removed from cart");
	}
	return actResult;
}
public boolean wishlist() {
	  boolean result = true;
	    try {
	       
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("wishlist")));
	        result = false; 
	    } catch (TimeoutException e) {
	        result = true;  
	        Reports.generateReport(driver, test, Status.FAIL, "wishlist link is absent.");
	    } catch (NoSuchElementException e) {
	        result = true; 
	        Reports.generateReport(driver, test, Status.FAIL, "wishlist  link is absent.");
	    }
	    return result;
}
}





package com.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.JpetstorePages.Registrationpage;
import com.JpetstoreUtility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationpageStepCode extends Base{
	  WebDriver driver = Base.driver;
	    ExtentTest test;
	    Registrationpage page;

	  
	    public RegistrationpageStepCode() {
	       
	        test = Hook.test;
	    }
	
	@When("I click enter store link")
	public void i_click_enter_store_link() {
		page = new Registrationpage(driver, test); 
	  page.enterlink();
	}

	@And("Its navigate to home page")
	public void its_navigate_to_home_page1() {
	   System.out.println("its navigate to home page");
	}

	@Then("I click signin page")
	public void i_click_signin_page() {
	
	    page.signin();
	}

	@When("I enter all details")
	public void i_enter_all_details() {
	  page.details(); 
	}


	@Then("I verify account is created")
	public void its_navigate_to_home_page() {
	    page = new Registrationpage(driver, test);  
	    boolean actResult = page.accountButton();
	    Assert.assertTrue(actResult);
	}


@And("I enter valid username {string}")
public void i_enter_valid_username(String string) {
   page.validusername(string);
}

@And("I enter valid password {string}")
public void i_enter_valid_password(String string) {
page.validpassword(string);
}


@And("I enter invalid username {string}")
public void i_enter_invalid_username(String string) {
  page.invalidusername(string);
}

@And("I enter invalid password {string}")
public void i_enter_invalid_password(String string) {
page.invalidpassword(string);
}

@Then("I click login button")
public void i_click_login_button() {
	page = new Registrationpage(driver, test);
	boolean actResult = page.Login();
	Assert.assertTrue(actResult);
	
}

@Then("I click password recovery link")
public void i_click_password_recovery_link() {
	page = new Registrationpage(driver, test);
	boolean actResult = page.isPasswordRecoveryLinkAbsent();
	//Assert.assertTrue(actResult);
	
}

}

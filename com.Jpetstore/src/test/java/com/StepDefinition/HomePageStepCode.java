package com.StepDefinition;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.JpetstorePages.Homepage;
import com.JpetstoreUtility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepCode extends Base {

	WebDriver driver=Base.driver;
	ExtentTest test = Hook.test;

     Homepage homepage=new Homepage(driver, test);

@Given("I navigate to Home Page")
public void i_navigate_to_home_page() {
	 System.out.println("navigating to link");
}
@Then("I validate the link")
public void i_validate_the_link() {

	boolean actResult =homepage.validUrl();
	Assert.assertTrue(actResult);
}
@Then("I validate title page")
public void i_validate_title_page() {
	
	boolean actResult =homepage.validTitle();
	Assert.assertTrue(actResult);
} 
}
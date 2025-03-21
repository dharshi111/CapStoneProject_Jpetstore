package com.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.JpetstorePages.Searchpage;
import com.JpetstoreUtility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchpageStepCode extends Base {
	WebDriver driver=Base.driver;
	ExtentTest test = Hook.test;
	Searchpage page = new Searchpage(driver, test);



	@Given("I enter pets in searchfield")
	public void i_enter_pets_in_searchfield() {
	
	   page.enter();
	}
	

	@When("I click searchButton")
	public void i_click_search_button() {
	   page.search();
	}

	@And("I selected the product and verify")
	public void i_selected_the_product_and_verify() {
		
		boolean actResult =page.checksearch();
		Assert.assertTrue(actResult);
	}


	@Then("I verify price filter")
public void i_verify_price_filter() {
	
	boolean actResult =page.pricefilter();
	//Assert.assertTrue(actResult);
}

	@Then("I verify language filter")
public void i_verify_language_filter() {
	
	boolean actResult =page.languagefilter();
	//Assert.assertTrue(actResult);
}

@And("I select the product")
public void i_select_the_product() {
  page.selectproduct();
}

@And("I verify product title")
public void i_verify_product_title() {
	
	boolean actResult =page.validproductTitle();
	Assert.assertTrue(actResult);
}

@And("I verify description")
public void i_verify_description() {
	
	boolean actResult =page.validDescription();
	Assert.assertTrue(actResult);
}

@And("I verify price")
public void i_verify_price() {
	
	boolean actResult =page.price();
	Assert.assertTrue(actResult);
}

@Then("I verify product availability")
public void i_verify_product_availability() {

	boolean actResult =page.checkAvailability();
	//Assert.assertTrue(actResult);
}

@And("I verify searchfield")
public void i_verify_searchfield() {
   boolean res=page.verifysearchfield();
   Assert.assertTrue(res);
}


@And("I click addtocart button")
public void i_click_addtocart_button() {
  boolean res= page.addtocart();
  Assert.assertTrue(res);
}

@And("I verify shopping cart")
public void i_verify_shopping_cart() {
 boolean res=page.verifyCart();
 Assert.assertTrue(res);
}

@And("I click proceed to checkout button")
public void i_click_proceed_to_checkout_button() {
  page.clickcheckout();
}

@And("I click checkbox")
public void i_click_checkbox() {
   page.checkbox();
}

@And("I click continue button")
public void i_click_continue_button() {
   page.clickcontinue();
}

@When("I click confirm button")
public void i_click_confirm_button() {
   page.confirmbutton();
}

@Then("Its display the message")
public void its_display_the_message() {
  boolean res= page.verifymessage();
  Assert.assertTrue(res);
}

@And("I add first product to cart")
public void i_add_first_product_to_cart() {
  page.fistproduct();
}

@And("I add second product to cart")
public void i_add_second_product_to_cart() {
   page.secondproduct();
}

@Then("I check cart is updated")
public void i_check_cart_is_updated() {
 boolean res=page.cartupdate();
 Assert.assertTrue(res);
}

@And("I click remove button")
public void i_click_remove_button() {
   page.removebutton();
}

@Then("I verify cart")
public void i_verify_cart() {
 boolean res=page.remove();
 Assert.assertTrue(res);
}

@Then("I verify wishlist link")
public void i_verify_wishlist() {
  boolean res=page.wishlist();  
 // Assert.assertTrue(res);
}



}

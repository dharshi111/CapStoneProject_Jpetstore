package com.JpetstorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.JpetstoreUtility.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Homepage {
	private WebDriver driver;
	
	ExtentTest test;

	public Homepage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
//url validation
	public boolean validUrl() {

		String currUrl = driver.getCurrentUrl();
		
		boolean actResult;
		if (currUrl.equals("https://petstore.octoperf.com/")) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "petstore is launched Successful");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "petstore is launched failure");
		}
		
		return actResult;
	}
//title validation
	public boolean validTitle() {
String currUrl = driver.getTitle();
		
		boolean actResult;
		if (currUrl.equals("JPetStore Demo")) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "title is verified");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "title is not verified");
		}
		
		return actResult;	
}
	


}

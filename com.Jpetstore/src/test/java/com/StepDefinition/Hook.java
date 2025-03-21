package com.StepDefinition;

import org.openqa.selenium.WebDriver;

import com.JpetstoreUtility.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hook extends Base {
	static WebDriver driver = Base.driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	

	@BeforeAll()
	public static void beforeAll() {

		try {
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@AfterAll()
	public static void afterAll() {
		extent.flush();
	}

	@Before()
	public void before() {
	    test = extent.createTest("Jpet Demo");  
	    getBrowser();
	    System.out.println("chrome is opening");
	}

	@After()
	public void after() {
    Base.driver.quit();
	System.out.println("chrome is closing");

	}
}
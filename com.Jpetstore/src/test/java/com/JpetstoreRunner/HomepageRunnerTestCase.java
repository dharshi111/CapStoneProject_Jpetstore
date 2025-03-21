package com.JpetstoreRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features={"src\\test\\resources\\Features"} , tags="@homepage or @registrationpage or @searchfunctionality"
,glue="com.StepDefinition", plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-html-report.html",
        "json:target/cucumber-reports/cucumber.json" 
    }) 

	

	
	public class HomepageRunnerTestCase extends AbstractTestNGCucumberTests  {

	}



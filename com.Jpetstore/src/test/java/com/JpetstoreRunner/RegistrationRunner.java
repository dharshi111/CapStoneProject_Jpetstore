package com.JpetstoreRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src\\test\\resources\\Features\\Registration.feature"} , tags="@registrationpage"
,glue="com.StepDefinition") 
public class RegistrationRunner extends AbstractTestNGCucumberTests {

}

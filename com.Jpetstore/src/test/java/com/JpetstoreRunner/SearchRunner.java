package com.JpetstoreRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src\\test\\resources\\Features\\Search.feature"} , tags=" @productdetails"
,glue="com.StepDefinition") 
public class SearchRunner extends AbstractTestNGCucumberTests{

}

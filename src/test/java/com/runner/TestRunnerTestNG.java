package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resource\\Features\\Bus.feature",glue="com.StepDefinitionTestNG",tags="@Insurance",//monochrome=true
plugin= {"pretty",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		 "html:target/CucumberReport/Cucumber.html",
		 "json:target/CucumberJson.json",
		 "junit:target/CucumberJunit.xml"})


public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}

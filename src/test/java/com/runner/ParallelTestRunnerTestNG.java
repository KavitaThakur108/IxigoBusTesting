package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
 
@CucumberOptions(
        features = "src\\test\\resource\\Features\\Bus.feature",
        glue = {"com.StepDefinitionTestNG", "com.hooks"},
        		plugin = {
        				
                		"pretty:target/pretty-parallel-report.txt",
                        "html:target/cucumber-html-parallel-report.html",
                        "json:target/cucumber-json-parallel-report.json"
                },
        monochrome = true,
        tags = "@Parallel"
)
public class ParallelTestRunnerTestNG extends AbstractTestNGCucumberTests {
 
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() 
    {
        return super.scenarios();
    }
}
 

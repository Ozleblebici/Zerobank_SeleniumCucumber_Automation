package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "html:target/failed-html-report", "json:target/cucumber.json"},
        features = "@target/rerun.txt",
        glue = "com/vytrack/step_definitions",
        dryRun = true
)
public class FailedTestRunner {
}

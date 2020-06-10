package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "html:target/failed-html-report", "json:target/failedcucumber.json"},
        features = "@target/rerun.txt",
        glue = "com/zerobank/stepdefnitions",
        dryRun = false
)
public class FailedTestRunner {
}

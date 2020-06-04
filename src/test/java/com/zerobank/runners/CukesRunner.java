package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = "src/test/resources/features/",
        glue = "src/test/java/com/zerobank/stepdefnitions",
        dryRun = true,
        tags = ""
)
public class CukesRunner {
}

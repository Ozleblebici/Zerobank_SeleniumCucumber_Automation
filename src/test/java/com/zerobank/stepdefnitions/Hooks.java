package com.zerobank.stepdefnitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {




    @Before
    public void setUp(){
        Actions actions;
        WebDriverWait wait;
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigurationReader.get("implicitWait")), TimeUnit.SECONDS);
//        actions = new Actions(driver);
//        wait = new WebDriverWait(driver,Long.parseLong(ConfigurationReader.get("explicitWait")));
    }


    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        BrowserUtils.waitFor(2);
        Driver.closeDriver();
    }
//
//    @Before ("@dbKullan")
//    public void dbSteUp(){
//        db.init.ds;
//
//    }
//    @After ("@dbKullan")
//    public void dbTearDown(){
//        db.kapat;
//    }
}

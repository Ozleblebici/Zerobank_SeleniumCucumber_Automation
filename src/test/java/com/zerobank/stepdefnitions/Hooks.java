package com.zerobank.stepdefnitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {

//    Actions actions;
//    WebDriverWait wait;

//    @Before
//    public void setUp(){
//        WebDriver driver = Driver.get();
//        driver.get(ConfigurationReader.get("url"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigurationReader.get("implicitWait")), TimeUnit.SECONDS);
//        actions = new Actions(driver);
//        wait = new WebDriverWait(driver,Long.parseLong(ConfigurationReader.get("explicitWait")));
//    }
//
//
//    @After
//    public void tearDown(){
//
//        // screenshoot ekle!!!
//        BrowserUtils.waitFor(2);
//        Driver.closeDriver();
//    }
}

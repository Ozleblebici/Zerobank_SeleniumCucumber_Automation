package com.zerobank.pages;


import com.zerobank.stepdefnitions.PurchaseForeignCurrencyStepDef;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

    @FindBy (id = "user_login")
    public WebElement userNameInput;

    @FindBy (id = "user_password")
    public WebElement passwordInput;

    @FindBy (name = "submit")
    public WebElement singInButton;

    @FindBy (partialLinkText = "Forgot your password")
    public WebElement forgotPassLink;

    @FindBy (css = ".alert.alert-error")
    public WebElement errorMessage;

    public void login(){
        userNameInput.sendKeys(ConfigurationReader.get("username"));
        passwordInput.sendKeys(ConfigurationReader.get("password"), Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    public void loginAs(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    public String getErrorMessage (){
       return errorMessage.getText();
    }

}

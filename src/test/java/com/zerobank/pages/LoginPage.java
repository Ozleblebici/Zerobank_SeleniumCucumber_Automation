package com.zerobank.pages;

import com.zerobank.utilities.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

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


    /**
     * This method use for login the url via using conf.pro. credentials
     */
    public void login(){
        userNameInput.sendKeys(ConfigurationReader.get("username"));
        passwordInput.sendKeys(ConfigurationReader.get("password")); //, Keys.ENTER
        singInButton.click();
        BrowserUtils.waitFor(1);
    }

    /**
     * This method created for negative login tests
     * @param username
     * @param password
     */
    public void loginAs(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password); //, Keys.ENTER
        singInButton.click();
        BrowserUtils.waitFor(1);
    }

    /**
     * This method return error message for unsuccessful login (with invalid credentials)
     * @return
     */
    public String getErrorMessage (){
       return errorMessage.getText();
    }

}

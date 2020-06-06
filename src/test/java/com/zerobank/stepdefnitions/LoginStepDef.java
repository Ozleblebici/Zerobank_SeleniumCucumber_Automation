package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDef {

    Pages page = new Pages();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        page.loginPage().login();
    }

    @Given("the user should not be able to login with wrong credentials")
    public void the_user_should_not_be_able_to_login_with_wrong_credentials() {
        page.loginPage().loginAs("userName","passWord");
    }


    /////  put this asser in page
    @Then("login error message should be displayed")
    public void login_error_message_should_be_displayed() {
        Assert.assertTrue(page.loginPage().errorMessage.isDisplayed());
        Assert.assertEquals("Login and/or password are wrong.", page.loginPage().getErrorMessage());
    }

    @Given("the user should not be able to login with blank credentials")
    public void the_user_should_not_be_able_to_login_with_blank_credentials() {
        page.loginPage().loginAs("","");
    }
}

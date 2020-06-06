package com.zerobank.stepdefnitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountActivityNavStepDef {



    @Given("the user accesses the {string}")
    public void the_user_accesses_the(String module) {
        System.out.println("navigate to page module");
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkName) {
        System.out.println(linkName);
    }



    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String dropDownName) {
        System.out.println(dropDownName);
    }


}

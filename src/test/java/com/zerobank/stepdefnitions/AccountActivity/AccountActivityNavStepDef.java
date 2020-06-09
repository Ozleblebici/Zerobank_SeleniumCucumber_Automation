package com.zerobank.stepdefnitions.AccountActivity;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountActivityNavStepDef {

    Pages pages = new Pages();



    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkName) {
       pages.accountSummary().clickAccountLink(linkName);
    }



    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String selectedAccountName) {
        pages.accountActivity().verifyDefaultSelectAccount(selectedAccountName);
    }


}

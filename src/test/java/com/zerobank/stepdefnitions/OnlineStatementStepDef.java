package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

import java.util.List;

public class OnlineStatementStepDef {

    Pages pages = new Pages();
    @Then("Verify that default dropdown option should be {string}")
    public void verify_that_default_dropdown_option_should_be(String defaultOption) {
        pages.onlineStatementsPage().verifyDropDownDefaultOption(defaultOption);
    }

    @Then("Verify following account names under account dropdown")
    public void verify_following_account_names_under_account_dropdown(List<String>options) {
        pages.onlineStatementsPage().verifyDropDownOptions(options);
    }

    @Then("After select following account names then Verify same account name in board header")
    public void after_select_following_account_names_then_Verify_same_account_name_in_board_header(List<String>accountTypes) {
        pages.onlineStatementsPage().verifyBoardHeaderWithDropDownOptions(accountTypes);
    }

    @Given("After click {string} ,verify that active year should be change")
    public void after_click_verify_that_active_year_should_be_change(String year) {
       pages.onlineStatementsPage().verifyActiveStatementYear(year);
    }

    @Then("Statements dates year should be same with following {string}")
    public void statements_dates_year_should_be_same_with_following(String year) {
       pages.onlineStatementsPage().verifyPdfStatamentsYear(year);
    }
}

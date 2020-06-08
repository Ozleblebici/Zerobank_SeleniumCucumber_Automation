package com.zerobank.stepdefnitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

public class FindTransactionsStepDef {


    Pages pages =new Pages();

    @Then("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {

           pages.accountActivity().findTransactionsLink.click();
    }


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        pages.accountActivity().enterDateRange(fromDate,toDate);

    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitFor(2);
        pages.accountActivity().findButton.click();
        BrowserUtils.waitFor(2);
        pages.accountActivity().addResultInBag();
    }

    @Then("results table should only show transactions dates between {string} to {string} and should be sorted by most recent date")
    public void results_table_should_only_show_transactions_dates_between_to_and_should_be_sorted_by_most_recent_date(String fromDate, String toDate) {
        pages.accountActivity().verifyDateBetweenFromTo(fromDate,toDate);
        //Driver.get().navigate().refresh();
    }

//    @Then("the results should be sorted by most recent date")
//    public void the_results_should_be_sorted_by_most_recent_date() {
//        System.out.println();
//    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String changeDate) {
        pages.accountActivity().verifyNotContainTransactionsDated(changeDate);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
       pages.accountActivity().enterDescription(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String input) {
        pages.accountActivity().verifyTableContainDescriptionTexts(input);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String input) {
        pages.accountActivity().verifyTableNotContainDescriptionTexts(input);
    }


    @Then("results table should show {string} result under {string}")
    public void results_table_should_show_result_under(String input, String row) {
        pages.accountActivity().verifyAccountTypeResult(row,input);
    }

    @When("user selects type {string}")
    public void user_selects_type(String accountType) {
        pages.accountActivity().getTypeDropDownSelectObject().selectByValue(accountType.toUpperCase());
        pages.accountActivity().findButton.click();
    }



//    @Then("results table should show no result under {string}")
//    public void results_table_should_show_no_result_under(String string) {
//        System.out.println();
//    }



}

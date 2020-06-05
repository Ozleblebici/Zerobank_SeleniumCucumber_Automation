package com.zerobank.stepdefnitions;

import io.cucumber.java.en.*;

public class FindTransactionsStepDef {



    @Then("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
        System.out.println("navigate to tab");
    }


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        System.out.println("***dates***dates****");
    }

    @When("clicks search")
    public void clicks_search() {
        System.out.println("searchhhh");
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        System.out.println();
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        System.out.println();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        System.out.println();
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        System.out.println();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        System.out.println();
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        System.out.println();
    }


    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        System.out.println();
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        System.out.println();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        System.out.println();
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        System.out.println();
    }



}

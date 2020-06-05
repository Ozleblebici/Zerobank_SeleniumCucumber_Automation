package com.zerobank.stepdefnitions;

import io.cucumber.java.en.*;

import java.util.List;

public class PurchaseForeignCurrencyStepDef {

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        System.out.println(currencies);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        System.out.println("********");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        System.out.println("error message");
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        System.out.println("**********");
    }
}

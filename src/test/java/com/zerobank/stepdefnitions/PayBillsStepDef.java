package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

public class PayBillsStepDef {

    Pages pages = new Pages();

    @When("the user completes a Pay operation with these {string} and {string}")
    public void the_user_completes_a_Pay_operation_with_these_and(String amount, String date) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validation message {string} should be displayed")
    public void validation_message_should_be_displayed(String message) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

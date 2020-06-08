package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

public class PayBillsStepDef {

    Pages pages = new Pages();

    @When("the user completes a Pay operation with these {string} and {string}")
    public void the_user_completes_a_Pay_operation_with_these_and(String amount, String date) {
       pages.paySavedPayeeSubTab().setPayOperation(amount,date);
    }

    @Then("validation message {string} should be displayed at {string}")
    public void validation_message_should_be_displayed(String message, String inputName) {
        pages.payBillsPage().verifyValidationErrorMessage(message,inputName);
    }
}

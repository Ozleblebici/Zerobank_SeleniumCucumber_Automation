package com.zerobank.stepdefnitions;

import io.cucumber.java.en.*;

import java.util.Map;

public class AddNewPayeeStepDef {


    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String>payeeInfoList) {
        System.out.println(payeeInfoList);
    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        System.out.println(message);
    }
}


package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

import java.util.Map;

public class AddNewPayeeStepDef {



    Pages pages = new Pages();

    @Given("creates new payee using following information")

    public void creates_new_payee_using_following_information(Map<String,String>payeeInfoList) {
        pages.addNewPayeeSubTab().creates_new_payee(payeeInfoList);

        //TODO buraya ekstra method ekle!!
    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        pages.payBillsPage().verifyAlertSuccessMessage(message);
    }

    @Then("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String subTab) {
    //    pages.payBillsPage().navigateToSubTabs(subTab);
        pages.loginPage().navigateToTab(subTab);
    }
}


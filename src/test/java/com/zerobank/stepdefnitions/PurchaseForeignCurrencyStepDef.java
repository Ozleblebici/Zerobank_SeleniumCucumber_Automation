package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

import java.util.List;

public class PurchaseForeignCurrencyStepDef {

    Pages pages = new Pages();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currenciesList) {
        pages.purchaseForeignCurrencySubTab().verifyAllCurrencyDropDownList(currenciesList);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        pages.purchaseForeignCurrencySubTab().purchaseWithoutSelectingCurrency();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        pages.purchaseForeignCurrencySubTab().verifyCurrencyErrorMessageDisplay();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        pages.purchaseForeignCurrencySubTab().purchaseWithoutEnteringValue();
    }
}

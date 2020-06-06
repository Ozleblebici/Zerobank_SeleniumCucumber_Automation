package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

import java.util.List;

public class AccountSummaryStepDef {

    Pages page = new Pages();

    @Then("following account types should be displayed")
    public void following_account_types_should_be_displayed(List<String> accountTypeList) {
        page.accountSummary().verifyAccountTypeListText(accountTypeList);
    }

    @Then("following columns at Credit Accounts table should be displayed")
    public void following_columns_at_table_should_be_displayed(List<String> tableColumnsList ) {
        page.accountSummary().verifyCreditCardTableColumns(tableColumnsList);
    }
}

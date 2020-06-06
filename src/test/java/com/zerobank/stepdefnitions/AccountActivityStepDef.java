package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.Then;

import java.util.List;

public class AccountActivityStepDef {

    Pages pages = new Pages();

    @Then("the account drop down default option should be {string}")
    public void the_drop_down_default_option_should_be( String defaultValue) {

        pages.accountActivity().verifyDropDownDefaultOption(defaultValue);
    }

    @Then("following drop down options should be have")
    public void following_drop_down_options_should_be_have(List<String> dropDownList) {

        pages.accountActivity().verifyDropDownOptions(dropDownList);
    }

    @Then("following columns name at Transactions table should be have")
    public void following_columns_name_at_Transactions_table_should_be_have(List<String> columnNameList) {

        pages.accountActivity().verifyTablesHeadsTexts(columnNameList);
    }

}

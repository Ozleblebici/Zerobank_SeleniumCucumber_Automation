package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity extends BasePage{

    @FindBy (linkText = "Show Transactions")
    public WebElement showTransactionsLink;

    @FindBy (linkText = "Find Transactions")
    public WebElement findTransactionsLink;

    @FindBy(xpath = "//div[@id='ui-tabs-1']/h2")
    public WebElement boardHeaderTitle;

    @FindBy (id = "aa_accountId")
    public WebElement accuntIdDropdown;

    @FindBy (xpath = "//thead//th")
    public List<WebElement> tableHeads;




    public String getBoardHeaderTitle(){
        return boardHeaderTitle.getText();
    }

    public Select getSelectObject(){
        return new Select(accuntIdDropdown);
    }

    public String getSelectDefault(){
        return getSelectObject().getFirstSelectedOption().getText();
    }

    public List<String> getSelectOptionsList(){
        return BrowserUtils.getElementsText(getSelectObject().getOptions());
    }

    public List<String> getTablesHeadsTexts(){

        return BrowserUtils.getElementsText(tableHeads);
    }



    // Verify Metohods;

    public void verifyDropDownDefaultOption(String expectedDefaultOption){
        Assert.assertEquals(expectedDefaultOption,getSelectDefault());
    }

    public void verifyDropDownOptions(List<String> dropDownList){
        Assert.assertEquals(dropDownList, getSelectOptionsList());
    }

    public void verifyTablesHeadsTexts(List<String> columnNameList){
        Assert.assertEquals(columnNameList, getTablesHeadsTexts());
    }




}

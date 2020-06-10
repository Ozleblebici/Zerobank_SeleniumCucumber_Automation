package com.zerobank.pages;

import com.zerobank.utilities.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
//import org.jetbrains.annotations.NotNull;

import java.util.*;

public class AccountActivityPage extends BasePage {

    @FindBy (linkText = "Show Transactions")
    public WebElement showTransactionsLink;

    @FindBy (linkText = "Find Transactions")
    public WebElement findTransactionsLink;

//    @FindBy(xpath = "//div[@id='ui-tabs-1']/h2")
//    public WebElement boardHeaderTitle;

    @FindBy (id = "aa_accountId")
    public WebElement accuntIdDropdown;

    @FindBy (xpath = "//thead//th")
    public List<WebElement> tableHeads;

    @FindBy (id = "aa_description")
    public WebElement descriptionInput;

    @FindBy (id = "aa_fromDate")
    public WebElement fromDateInput;

    @FindBy (id= "aa_toDate")
    public WebElement toDateInput;

    @FindBy (css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy (xpath = "(//tbody)[2]//tr//td[1]")
    public List<WebElement> tableDateRowElementsList;

    @FindBy (xpath = "(//tbody)[2]//tr//td[2]")
    public List<WebElement> tableDescriptionRowElementsList;

    @FindBy (id = "aa_type")
    public WebElement accountTypeDropDown;

    /**
     *  This static @searchList array list keeps all date columns for each search and keep them as a List of string
     */
    public static ArrayList<List<String>> searchList= new ArrayList<>();


    /**
     * This method update/add date columns to static @searchlist object for each results
     */
    public void addResultInBag(){
        searchList.add(BrowserUtils.getElementsText(tableDateRowElementsList));
    }

    /**
     * This method enter @param to description input
     * @param description
     */
    public void enterDescription(String description){
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    /**
     * This method enter @parama to fromdate and todate input
     * @param fromDate
     * @param toDate
     */
    public void enterDateRange(String fromDate, String toDate){
        fromDateInput.clear();
        fromDateInput.sendKeys(fromDate);
        toDateInput.clear();
        toDateInput.sendKeys(toDate);

    }


    // GET METHODS

    /**
     * This methods returns Description rows elements texts as list of string
     * @return
     */
    public List<String> getTableDescriptionRowElementsText(){
        return BrowserUtils.getElementsText(tableDescriptionRowElementsList);
    }

    /**
     * Tihs method return Select object for account ID DropDown element
     * @return
     */
    public Select getSelectObject(){
        return new Select(accuntIdDropdown);
    }

    /**
     * Tihs method return Select object for account Type DropDown element
     * @return
     */
    public Select getTypeDropDownSelectObject(){
        return new Select(accountTypeDropDown);
    }

    /**
     * This method return account ID DropDown element First Selected Default option's text
     * @return
     */
    public String getSelectDefault(){
        return getSelectObject().getFirstSelectedOption().getText();
    }

    /**
     * This method return list of string for account ID DropDown element
     * @return
     */
    public List<String> getSelectOptionsList(){
        return BrowserUtils.getElementsText(getSelectObject().getOptions());
    }

    /**
     * This method return list of string for table Head elements
     * @return
     */
    public List<String> getTablesHeadsTexts(){
        return BrowserUtils.getElementsText(tableHeads);
    }



    // ****Verify Metohods****

    /**
     * THis method verify that when we change the search dates, this metod find and check @changed Date
     * @param changedDate
     */
    public void verifyNotContainTransactionsDated (String changedDate){

        List<String> list1 = searchList.get(0);
        List<String> list2 = searchList.get(1);

        list1.removeAll(list2);

        Assert.assertEquals(changedDate, list1.get(0));
    }

    /**
     * This method verify that default value of drop down options
     * @param expectedDefaultOption
     */
    public void verifyDropDownDefaultOption(String expectedDefaultOption){
        Assert.assertEquals(expectedDefaultOption,getSelectDefault());
    }

    /**
     * This method verify that all drop down options are same as given @param
     * @param dropDownList
     */
    public void verifyDropDownOptions(List<String> dropDownList){
        Assert.assertEquals(dropDownList, getSelectOptionsList());
    }

    /**
     * This methods verify tables Head column texts with @param
     * @param columnNameList
     */
    public void verifyTablesHeadsTexts(List<String> columnNameList){
        Assert.assertEquals(columnNameList, getTablesHeadsTexts());
    }

    /**
     *This method verify default Account drop down type name
     * @param expectedSelectAccountName
     */
    public void verifyDefaultSelectAccount(String expectedSelectAccountName ){
        Assert.assertEquals(expectedSelectAccountName,getSelectDefault());
    }

    /**
     * This method will check that all rows description is include expected input
     * @param expectedInput
     */
    public void verifyTableContainDescriptionTexts (String expectedInput){
        boolean check= false;
        for (String input : getTableDescriptionRowElementsText()) {
              if(!input.contains(expectedInput)){
                  check=false;
                  break;
              } else{
                  check=true;
              }
        }
        Assert.assertTrue(check);
    }

    /**
     * This method will check that all rows description is not include expected input
     * @param expectedInput
     */
    public void verifyTableNotContainDescriptionTexts (String expectedInput){
        boolean check= true;
        for (String input : getTableDescriptionRowElementsText()) {
            if(input.contains(expectedInput)){
                check=true;
                break;
            } else{
                check=false;
            }
        }
        Assert.assertFalse(check);
    }

    /**
     * This method take data from user to verify type via @input, and take @row name to take true table column list
     * Then method will check each rows one by one is it empty or not via each row elements texts with using boolean flags
     * @param row
     * @param input
     */
    public void verifyAccountTypeResult (String row,  String input){  //@NotNull
        BrowserUtils.waitFor(2);
        boolean flag=true;
        if (input.contains("at least one")) {
            flag = true;
        } else if (input.contains("no")) {
            flag = false;
        }

        List<WebElement> typeTableList=new ArrayList<>();
        if (row.equalsIgnoreCase("Deposit")){
            typeTableList=Driver.get().findElements(By.xpath("(//tbody)[2]//tr//td[3]"));
        } else if (row.equalsIgnoreCase("Withdrawal")){
            typeTableList=Driver.get().findElements(By.xpath("(//tbody)[2]//tr//td[4]"));
        }

        boolean check = !flag;
        for (String eachRow :BrowserUtils.getElementsText(typeTableList) ) {
             if (!eachRow.equals("")){
                 check= flag;
                 break;
             }
        }
        Assert.assertTrue("flag"+flag, check);
    }

    /**
     * This method verify that results dates row just between fromdate to todate
     * it will check from alltableDateRowElements for list.
     * @param expectedFromDate
     * @param expectedToDate
     */
    public void verifyDateBetweenFromTo(String expectedFromDate, String expectedToDate){
        Assert.assertTrue(Integer.parseInt(tableDateRowElementsList.get(tableDateRowElementsList.size()-1).getText().replace("-","")) >= Integer.parseInt(expectedFromDate.replace("-","")) );
        Assert.assertTrue(Integer.parseInt(tableDateRowElementsList.get(0).getText().replace("-","")) <= Integer.parseInt(expectedToDate.replace("-","")) );
    }


}

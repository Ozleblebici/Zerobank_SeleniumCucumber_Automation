package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage{

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

    public static ArrayList<List<String>> searchList= new ArrayList<>();

    /**
     * This method verify that results dates row just between fromdate to todate
     * it will check from alltableDateRowElements for list.
     * @param expectedFromDate
     * @param expectedToDate
     */
    public void verifyDateBetweenFromTo(String expectedFromDate, String expectedToDate){
        //Assert.assertEquals(expectedFromDate, tableDateRowElementsList.get(tableDateRowElementsList.size()-1).getText());
        //Assert.assertEquals(expectedToDate, tableDateRowElementsList.get(0).getText());

        Assert.assertTrue(Integer.valueOf(tableDateRowElementsList.get(tableDateRowElementsList.size()-1).getText().replace("-","")) >= Integer.valueOf(expectedFromDate.replace("-","")) );
        Assert.assertTrue(Integer.valueOf(tableDateRowElementsList.get(0).getText().replace("-","")) <= Integer.valueOf(expectedToDate.replace("-","")) );

      //Assert.assertEquals("sorted by most recent date",expectedToDate,tableDateRowElementsList.get(0).getText());
    }


    public void addResultInBag(){
        searchList.add(BrowserUtils.getElementsText(tableDateRowElementsList));
    }


    public void verifyNotContainTransactionsDated (String changedDate){

        List<String> list1 = searchList.get(0);
        List<String> list2 = searchList.get(1);

        System.out.println(list1);
        System.out.println(list2);

        list1.removeAll(list2);

//        for (int i = 0; i < list1.size(); i++) {
//            for (int j = 0; j < list2.size(); j++) {
//                if (list1.get(i).equals(list2.get(j))){
//                    list1.remove(i);
//                    i--;
//                    j--;
//                }
//            }
//        }

        Assert.assertEquals(changedDate, list1.get(0));
    }


    public void enterDateRange(String fromDate, String toDate){
        fromDateInput.clear();
        fromDateInput.sendKeys(fromDate);
        toDateInput.clear();
        toDateInput.sendKeys(toDate);

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

    public void verifyDefaultSelectAccount(String expectedSelectAccountName ){
        Assert.assertEquals(expectedSelectAccountName,getSelectDefault());
    }



}

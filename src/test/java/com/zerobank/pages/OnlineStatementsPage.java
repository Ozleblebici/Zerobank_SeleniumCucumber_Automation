package com.zerobank.pages;

import com.zerobank.utilities.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OnlineStatementsPage extends BasePage {


    @FindBy(id = "os_accountId")
    public WebElement accountDropDown;

    @FindBy(css = "#online_statements_for_account h2")
    public WebElement boardHeader;

    //    //a[contains(text(),'2012')]      recent statemnts
//div[@id='os_2011']//tbody//td    documnets pdfs


    /**
     * Tihs method return Select object for account ID DropDown element
     * @return
     */
    public Select getSelectObject(){
        return new Select(accountDropDown);
    }

    /**
     * This method return account ID DropDown element First Selected Default option's text
     * @return
     */
    public String getSelectDefault(){
        return getSelectObject().getFirstSelectedOption().getText();
    }


    /**
     * This method verify that default value of drop down options
     * @param expectedDefaultOption
     */
    public void verifyDropDownDefaultOption(String expectedDefaultOption){
        Assert.assertEquals(expectedDefaultOption, getSelectDefault());
    }

    /**
     * This method return list of string for account ID DropDown element
     * @return
     */
    public List<String> getSelectOptionsList(){
        return BrowserUtils.getElementsText(getSelectObject().getOptions());
    }

    /**
     * This method verify that all drop down options are same as given @param
     * @param dropDownList
     */
    public void verifyDropDownOptions(List<String> dropDownList){
        Assert.assertEquals(dropDownList, getSelectOptionsList());
    }


    /**
     * This method select account type one by one, and verify them with board header text
     * @param accountTypes
     */
    public void verifyBoardHeaderWithDropDownOptions(List<String> accountTypes){
        for (int i=0; i<accountTypes.size(); i++){
            BrowserUtils.waitFor(1);
            try {
                getSelectObject().selectByIndex(i + 1);
            } catch (Exception e){
                // gereksiz yere son elemnde hata veriyor girmediği halde!
                //catch yakalıyor test devam ediyor
            }
            Assert.assertEquals(accountTypes.get(i), boardHeader.getText().split("-")[1].trim());
        }
    }



    /**
     * This method click the year and verify is Active or not
     * @param year
     */
    public void verifyActiveStatementYear (String year){
        Driver.get().findElement(By.xpath("//a[contains(text(),'"+year+"')]")).click();

        boolean isActive= true;
       try {
           Driver.get().findElement(By.xpath("//li[@class='active']//a[contains(text(),'"+year+"')]")).getText();
       }catch (Exception e){
           isActive=false;
       }
           Assert.assertTrue(isActive);
    }


    //Statements dates year should be same with following "<year>"
    public void verifyPdfStatamentsYear(String year){
        String expectedYear= year.substring(2); // click year

        List<WebElement> rows = Driver.get().findElements(By.xpath("//div[@id='os_"+year+"']//tbody//td"));

        for (WebElement row : rows) {
            try {
                String actualYear = row.getText().substring(16, 18);
                Assert.assertEquals(expectedYear,actualYear);
            } catch (Exception e){
            }
        }
    }









}

package com.zerobank.pages.PayBills;

import com.zerobank.utilities.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class PurchaseForeignCurrencySubTab extends BasePage {

    @FindBy(id = "pc_currency")
    public WebElement CurrencyDropDown;

    @FindBy(id = "pc_amount")
    public WebElement amountInput;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dollarRadioBtn;

    @FindBy(id = "pc_inDollars_false")
    public WebElement selectedCurrencyBtn;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostButton;

    @FindBy(id = "purchase_cash")
    public WebElement purchaseButton;


    /**
     * This method convert to our Currency element, and create a Select class object
     * @return
     */
    public Select getCurrencySelectObject (){
        return new Select(CurrencyDropDown);
    }



    /**
     * This method try purchase without selecting currency
     */
    public void purchaseWithoutSelectingCurrency(){
        amountInput.sendKeys("12345");
        dollarRadioBtn.click();
        // ***!!!!Use this step for negative test for next feature step (error message assert test) !!!!***
        //  getCurrencySelectObject().selectByIndex(2);

        calculateCostButton.click();
    }

    /**
     * This method try purchase without selecting currency
     */
    public void purchaseWithoutEnteringValue(){
        getCurrencySelectObject().selectByIndex(2);
        dollarRadioBtn.click();
        // ***!!!!Use this step for negative test for next feature step (error message assert test) !!!!***
       // amountInput.sendKeys("12345");

        calculateCostButton.click();
    }


    //Verify MethodS:

    /**
     * This method verify that all Select options in Currency dropdown is same with expected Data
     * @param expectedCurrenciesList  is coming from feature file data
     */
    public void verifyAllCurrencyDropDownList(List<String> expectedCurrenciesList){

        List<String> actualList = BrowserUtils.getElementsText(getCurrencySelectObject().getOptions());
        Assert.assertTrue("***Actual List: "+ actualList+" / ***Expected List: "+expectedCurrenciesList,actualList.containsAll(expectedCurrenciesList));
    }


    /**
     * This method verify that error message is appear on the map or not.
     * If it is not displayed it will give alertError then
     * tryCatch exception catch it and give false for assertion!!!
     */
    public void verifyCurrencyErrorMessageDisplay(){

        boolean check=true;
        try {
            Alert alert = Driver.get().switchTo().alert();
            alert.accept();
        } catch (Exception e){
            check = false;
        }

        Assert.assertTrue(check);
    }

}

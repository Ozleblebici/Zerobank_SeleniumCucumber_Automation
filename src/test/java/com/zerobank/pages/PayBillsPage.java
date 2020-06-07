package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage {


    @FindBy(css = ".ui-state-default.ui-corner-top")
    public List<WebElement> subTabs;

    @FindBy(id="sp_amount")
    public WebElement amountInput;

    @FindBy(id="sp_date")
    public WebElement dateInput;

    @FindBy(id="sp_description")
    public WebElement descriptionInput;

    @FindBy(id="pay_saved_payees")
    public WebElement payBtn;

    @FindBy (id = "alert_content")
    public WebElement alertSuccessMessage;




    public void verifyAlertSuccessMessage(String expectedMessage){
        Assert.assertTrue(alertSuccessMessage.isDisplayed());
        Assert.assertEquals(expectedMessage, alertSuccessMessage.getText());
    }




    /**
     * this method will navigate subTabs
     * @param subTabName comes form feature
     * it will wait for clickablility and click
     */
    public void navigateToSubTabs(String subTabName) {

        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath("//li[contains(@class,'ui-state-default ui-corner-top')]//a[contains(text(),'" + subTabName + "')]")), 5).click();
    }

    /**
     * This method will done pay operation for user with these datas;
     * You can use it for @positive(successful) and @negative(unsuccessful) Scenarios
     * @param amount
     * @param date
     */
    public void setPayOperation(String amount, String date){
        int shortWait = Integer.valueOf(ConfigurationReader.get("shortWait"));
            BrowserUtils.waitForVisibility(amountInput,shortWait).sendKeys(amount);
            BrowserUtils.waitForVisibility(dateInput,shortWait).sendKeys(date);
        BrowserUtils.waitFor(2);
            BrowserUtils.waitForClickablility(payBtn,shortWait).click();
    }


    /**
     * This method verify that relevant input validation error message and display
     * It takes expected message and relevant input name value, it passes assertion
     * @param message
     * @param inputName
     */
    public void verifyValidationErrorMessage(String message, String inputName){
        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        WebElement field = Driver.get().findElement(By.cssSelector("input[name='"+inputName+"']"));
        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", field);
        String actualMessage = (String)js.executeScript("return arguments[0].validationMessage;", field);
        Assert.assertEquals(message,actualMessage);
        boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",field);
    //Assert.assertFalse(is_valid);
     System.out.println("isRequired = " + isRequired);
      //  BrowserUtils.waitFor(2);
    // Assert.assertTrue((Boolean)((JavascriptExecutor)Driver.get()).executeScript("return arguments[0].validity.valid;", field));
   //Assert.assertTrue(isRequired);

    }





}

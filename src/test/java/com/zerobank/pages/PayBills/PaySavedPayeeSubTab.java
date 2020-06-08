package com.zerobank.pages.PayBills;

import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaySavedPayeeSubTab extends BasePage {

    @FindBy(id="sp_amount")
    public WebElement amountInput;

    @FindBy(id="sp_date")
    public WebElement dateInput;

    @FindBy(id="sp_description")
    public WebElement descriptionInput;

    @FindBy(id="pay_saved_payees")
    public WebElement payBtn;


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








}

package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
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


    /**
     * this method will navigate subTabs
     * @param subTabName comes form feature
     * it will wait for clickablility and click
     */
    public void navigateToSubTabs(String subTabName) {

        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath("//li[contains(@class,'ui-state-default ui-corner-top')]//a[contains(text(),'" + subTabName + "')]")), 5).click();
    }




    //   JavascriptExecutor js = (JavascriptExecutor)driver;
//    WebElement field = driver.findElement(By.name("email"));
//    Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", field);
//    String message = (String)js.executeScript("return arguments[0].validationMessage;", field);

}

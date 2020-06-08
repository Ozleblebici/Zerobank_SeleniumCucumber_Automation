package com.zerobank.pages.PayBills;

import com.zerobank.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AddNewPayeeSubTab extends BasePage {

    @FindBy(id="np_new_payee_name")
    public WebElement payeeNameInput;

    @FindBy(id="np_new_payee_address")
    public WebElement payeeAddressInput;

    @FindBy(id="np_new_payee_account")
    public WebElement accountInput;

    @FindBy(id="np_new_payee_details")
    public WebElement payeeDetailsInput;

    @FindBy(id = "add_new_payee")
    public WebElement addBtn;




    /**
     * This method will create new payee via using  Map<Key,Value></> List data
     * @param payeeInfoList  is coming from feature file
     */
    public void creates_new_payee(Map<String,String> payeeInfoList){

        payeeNameInput.sendKeys(payeeInfoList.get("Payee Name"));
        payeeAddressInput.sendKeys(payeeInfoList.get("Payee Address"));
        accountInput.sendKeys(payeeInfoList.get("Account"));
        payeeDetailsInput.sendKeys(payeeInfoList.get("Payee details"));
        addBtn.click();
    }



}

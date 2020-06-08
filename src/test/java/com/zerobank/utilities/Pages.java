package com.zerobank.utilities;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBills.AddNewPayeeSubTab;
import com.zerobank.pages.PayBills.PayBillsPage;
import com.zerobank.pages.PayBills.PaySavedPayeeSubTab;
import com.zerobank.pages.PayBills.PurchaseForeignCurrencySubTab;

public class Pages {


    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private AccountActivityPage accountActivityPage;
    private PayBillsPage payBillsPage;
    private PaySavedPayeeSubTab paySavedPayeeSubTab;
    private AddNewPayeeSubTab addNewPayeeSubTab;
    private PurchaseForeignCurrencySubTab purchaseForeignCurrencySubTab;


    public LoginPage loginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public AccountSummaryPage accountSummary(){
        if (accountSummaryPage == null) {
            accountSummaryPage = new AccountSummaryPage();
        }
        return accountSummaryPage;
    }

    public AccountActivityPage accountActivity() {
        if (accountActivityPage == null) {
            accountActivityPage = new AccountActivityPage();
        }
        return accountActivityPage;
    }

    public PayBillsPage payBillsPage() {
        if (payBillsPage == null) {
            payBillsPage = new PayBillsPage();
        }
        return payBillsPage;
    }

    public PaySavedPayeeSubTab paySavedPayeeSubTab() {
        if (paySavedPayeeSubTab == null) {
            paySavedPayeeSubTab = new PaySavedPayeeSubTab();
        }
        return paySavedPayeeSubTab;
    }

    public AddNewPayeeSubTab addNewPayeeSubTab() {
        if (addNewPayeeSubTab == null) {
            addNewPayeeSubTab = new AddNewPayeeSubTab();
        }
        return addNewPayeeSubTab;
    }

    public PurchaseForeignCurrencySubTab purchaseForeignCurrencySubTab() {
        if (purchaseForeignCurrencySubTab == null) {
            purchaseForeignCurrencySubTab = new PurchaseForeignCurrencySubTab();
        }
        return purchaseForeignCurrencySubTab;
    }
}

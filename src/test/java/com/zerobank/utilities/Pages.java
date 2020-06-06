package com.zerobank.utilities;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;

public class Pages {


    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private AccountActivityPage accountActivityPage;
    private PayBillsPage payBillsPage;

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
}

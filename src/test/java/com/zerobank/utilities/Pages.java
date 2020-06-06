package com.zerobank.utilities;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;

public class Pages {


    private LoginPage loginPage;
    private AccountSummary accountSummary;
    private AccountActivity accountActivity;

    public LoginPage loginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public AccountSummary accountSummary(){
        if (accountSummary == null) {
            accountSummary = new AccountSummary();
        }
        return accountSummary;
    }

    public AccountActivity accountActivity() {
        if (accountActivity == null) {
            accountActivity = new AccountActivity();
        }
        return accountActivity;
    }
}

package com.zerobank.stepdefnitions;
import com.zerobank.pages.PayBills.MyMoneyMapPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyMoneyMapStepDef {

    @Given("the user access the {string}")
    public void the_user_access_the(String TabName) {

        MyMoneyMapPage myMoneyMapPage = new MyMoneyMapPage();
        myMoneyMapPage.navigateToTab(TabName);
    }

    @Then("table should displays summaryrows")
    public void table_should_displays_summaryrows() {

        MyMoneyMapPage moneyMapPage = new MyMoneyMapPage();
        //moneyMapPage.totalInflow.isDisplayed();
        //moneyMapPage.totalOutflow.isDisplayed();
        //moneyMapPage.whatsleft.isDisplayed();

        Assert.assertTrue( "total inflow is displayed",moneyMapPage.totalInflow.isDisplayed());
        Assert.assertTrue("total outflow is displayed",moneyMapPage.totalOutflow.isDisplayed());
        Assert.assertTrue("whatsleft is displayed",moneyMapPage.whatsleft.isDisplayed());

    }

    @Then("system should compare infos between {string} and {string}")
    public void system_should_compare_infos_between_and(String totalDatas, String tablesDatas ) {
        String totalDataspath = "//div[contains(text(),'"+totalDatas+"')]/../../td[2]";
        String tablesDataspath = "(//div[contains(text(),'"+tablesDatas+"')]/../../../../tr[4]//b)[2]";
        ///tr/td/div/b[contains(text(),'$')]  bu metodla da denenecek
        // WebElementle olustur, get et
        WebElement expectedData= Driver.get().findElement(By.xpath(totalDataspath));
        WebElement actualData = Driver.get().findElement(By.xpath(tablesDataspath));


        Assert.assertEquals(expectedData.getText(),actualData.getText());

    }

    @Then("verify {string} amount is correct")
    public void verify_amount_is_correct(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
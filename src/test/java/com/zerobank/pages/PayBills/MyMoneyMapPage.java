package com.zerobank.pages.PayBills;


import com.zerobank.utilities.BasePage;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyMoneyMapPage extends BasePage {


        //@FindBy ( xpath = "//div[text()='Direct Deposits']")
        //  public WebElement Directdeposit;

        //@FindBy ( xpath = "//div[text()='Household']")
        // public WebElement Household;

        @FindBy(xpath = "(//img[@class='x-action-col-icon x-action-col-0   '])[1]")
        public WebElement icon1;

        // Ic kisimlari ayni , sadece class isminda en sonda space var bundan dolayi ayni degil oluyor
        //ve ikincisini locate edemiyoruz!!!!! o yüzden ayni olan kisimlari ayni tuttuk
        // img{---} ayni tuttuk sadece single quote icindekini parametre olarak veriyoruz

        @FindBy (xpath = "(//img[@class='x-action-col-icon x-action-col-0   '])[9]")
        public WebElement icon2;

        @FindBy ( css = "#ext-sprite-1259" )
        public WebElement retail;

        @FindBy (xpath = "//div[contains(text(),'Total Inflow')]" )
        public WebElement totalInflow;

        @FindBy (xpath = "//div[contains(text(),'Total Outflow')]")
        public WebElement totalOutflow;

        @FindBy (xpath = "//b[contains(text(),\"What's Left\")]")
        public WebElement whatsleft;
        // (//div[@class="x-grid-cell-inner "])[49]
        // (//div[@class="x-grid-cell-inner "])[51]
        //  (//div[@class="x-grid-cell-inner "])[47]

//(//div[contains(text(),'Subject: Deposit')]/../../../../tr[4]//b)[2]


        public String accessHead(String Head) {
            String headLocator = "//div[text()= '" + Head + "' ]";
            String tabElement = Driver.get().findElement(By.xpath(headLocator)).getText();

            return tabElement;
        }

        public String getDate(String date) {
            String dateLocator = "//div[text()='" + date + "']" ;
            String accessDate = Driver.get().findElement(By.xpath(dateLocator)).getText();
            return accessDate;

        }

        public String getAmount(String amountIndex, String amount) {
            String amountLocator = "(//div[text()='"+amount+"'])["+amountIndex+"]" ;
            String accessAmount = Driver.get().findElement(By.xpath(amountLocator)).getText();
            return accessAmount;

        }

        public void getIcon(String Index) {
            String iconLocator = "(//img[@class='x-action-col-icon x-action-col-0   '])["+Index+"]" ;
            Driver.get().findElement(By.xpath(iconLocator)).click();

        }


    }

package com.zerobank.utilities;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this );
    }

    Actions action = new Actions(Driver.get());

    @FindBy(linkText = "Account Summary")
    public WebElement accountSummaryBtn;

    @FindBy(linkText = "Account Activity")
    public WebElement accountActivityBtn;

    @FindBy(linkText = "Transfer Funds")
    public WebElement transferFundsBtn;

    @FindBy(linkText = "Pay Bills")
    public WebElement payBillsBtn;

    @FindBy(linkText = "My Money Map")
    public WebElement myMoneyMapBtn;

    @FindBy(linkText = "Online Statements")
    public WebElement onlineStatementsBtn;

    @FindBy(linkText = "Zero Bank")
    public WebElement goToHomePageBtn;

    @FindBy(id = "searchTerm")
    public WebElement searchInputBox;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement settingBtn;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement userNameBtn;

    @FindBy(id = "help_link")
    public WebElement helpLink;

    @FindBy(id = "logout_link")
    public WebElement logoutLink;

    @FindBy (css = ".board-header")
    public WebElement subTabTitle;

    @FindBy (css = ".board-header")
    public List<WebElement> subTabTitlesList;



    // ****GETTER METHODS****
    /**
     * This method use subTabTitle and
     * @return subTab Title texts as sting
     */
    public String getSubTabTitleText(){
        return subTabTitle.getText();
    }

    /**
     * This method use subTabTitlesList and
     * @return list of sub titles texts as a string
     */
    public List<String> getSubTabTitlesListTexts(){
        return BrowserUtils.getElementsText(subTabTitlesList);
    }

    /**
     * This method is navigate us "Help" section directly
     */
    public void clickToHelpLink(){
        action.moveToElement(userNameBtn).click().pause(500).moveToElement(helpLink).click().build().perform();
        //  BrowserUtils.clickWithJS(helpLink);
    }

    /**
     *This method will work for "Logout" feature.@
     */
    public void logOut(){
        action.moveToElement(userNameBtn).click().pause(500).moveToElement(logoutLink).click().build().perform();
        //   BrowserUtils.clickWithJS(logoutLink);
    }

    /**
     * This Method perform navigation for relevant tab for given parameter
     * @param tabName
     */
    public void navigateToTab(String tabName){
        try{
         //   BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath("//a[.='"+tabName+"']")));
            Driver.get().findElement(By.xpath("//a[.='"+tabName+"']")).click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Check entered input tabName = " + tabName);
        }
    }


    // ****VERIFY METHODS****
    /**
     * This method verify the page/tab title
     * @param expectedTitle
     */
    public void verifyToTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

}

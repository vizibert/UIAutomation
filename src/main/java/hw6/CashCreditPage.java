package hw6;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class CashCreditPage extends BaseView {

    @FindBy(xpath = "//*[@id=\"credit-sum\"]/div/input")
    private WebElement creditSum;

    public CashCreditPage clickAndTypeNewCreditSum(String newCreditSum) {
        creditSum.click();
        creditSum.clear();
        creditSum.sendKeys(newCreditSum);
        return new CashCreditPage(driver);
    }

    @FindBy(xpath = "//*[@id=\"bank-offer\"]/button")
    private WebElement sendRequestButton;

    public CashCreditPage clickSendRequestButton() {
        sendRequestButton.click();
        return new CashCreditPage(driver);
    }

    @FindBy(name = "fio")
    private WebElement fio;

    public CashCreditPage clickAndTypeFIO(String newFIO) {
        fio.click();
        fio.sendKeys(newFIO);
        return new CashCreditPage(driver);
    }

    @FindBy(name = "birthdate")
    private WebElement dob;

    public CashCreditPage clickAndTypeDOB(String newDOB) {
        dob.click();
        dob.sendKeys(newDOB);
        return new CashCreditPage(driver);
    }

    @FindBy(name = "phone")
    private WebElement mobile;

    public CashCreditPage clickAndTypeMobile(String newMobile) {
        mobile.click();
        mobile.sendKeys(newMobile);
        return new CashCreditPage(driver);
    }

    @FindBy(name = "region")
    private WebElement region;

    public CashCreditPage clickAndTypeRegion(String newRegion) {
        region.click();
        region.sendKeys(newRegion);
        return new CashCreditPage(driver);
    }

    @FindBy(xpath = "//*[contains(text(),\"ОТПРАВИТЬ\")]")
    private WebElement sendButton;

    public SuccessBlock clickSendButton() {
        sendButton.click();
        return new SuccessBlock(driver);
    }

    public CashCreditPage(WebDriver driver) {
        super(driver);
    }

}

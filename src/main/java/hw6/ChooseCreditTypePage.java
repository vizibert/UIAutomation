package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseCreditTypePage extends BaseView {

    @FindBy(xpath = "//*[@class=\"container py-14\"]//*[text()='Кредиты наличными']")
    private WebElement cashCredit;

    public CashCreditPage clickCashCredit() {
        cashCredit.click();
        return new CashCreditPage(driver);
    }

    public ChooseCreditTypePage(WebDriver driver) {
        super(driver);
    }
}

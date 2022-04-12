package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BaseView {

    @FindBy(xpath = "//*[@id=\"__next\"]//a[text()='Кредиты']")
    private WebElement creditLink;

    public ChooseCreditTypePage clickCreditLink() {
        creditLink.click();
        return new ChooseCreditTypePage(driver);
    }

    public Header(WebDriver driver) {
        super(driver);
    }

}

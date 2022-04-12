package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class SuccessBlock extends BaseView {

    @FindBy(xpath = "//*[contains(text(),\"Заявка отправлена\")]")
            private WebElement titleSuccess;

    public void CheckThatRequestWasSentSuccessfully() {

        webDriverWait.until(ExpectedConditions.visibilityOf(titleSuccess));
        assertThat(titleSuccess, isDisplayed());
    }

    public SuccessBlock(WebDriver driver) {
        super(driver);
    }
}

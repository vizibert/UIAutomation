package hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendCashCreditRequestTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    void SendSuccessCashCreditRequestTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://sovcombank.ru/");

        new Header(driver)
                .clickCreditLink()
                .clickCashCredit()
                .clickAndTypeNewCreditSum("500000")
                .clickSendRequestButton()
                .clickAndTypeFIO("Иван Бонгратионов")
                .clickAndTypeDOB("10.01.1990")
                .clickAndTypeMobile("9819999192")
                .clickAndTypeRegion("Брянская область")
                .clickSendButton()
                .CheckThatRequestWasSentSuccessfully();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

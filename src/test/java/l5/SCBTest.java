package l5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class SCBTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String SCB_BASE_URL = "https://sovcombank.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(SCB_BASE_URL);
    }

    @Test
    void SendApplicationForALoan() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/nav[2]/div[2]/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[2]/div/ul/li[1]/a")).click();

        WebElement creditSum = driver.findElement(By.xpath("//*[@id=\"credit-sum\"]/div/input"));
        creditSum.click();
        creditSum.clear();
        creditSum.sendKeys("500000");

        driver.findElement(By.xpath("//*[@id=\"bank-offer\"]/button")).click();

        WebElement fio = driver.findElement(By.name("fio"));
        fio.click();
        fio.sendKeys("Иван Бонгратионов");

        WebElement dob = driver.findElement(By.name("birthdate"));
        dob.click();
        dob.sendKeys("10.01.1990");

        WebElement mobile = driver.findElement(By.name("phone"));
        mobile.click();
        mobile.sendKeys("9819999192");

        WebElement region = driver.findElement(By.name("region"));
        region.click();
        region.sendKeys("Брянская область");

        driver.findElement(By.xpath("//*[contains(text(),\"ОТПРАВИТЬ\")]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),\"Заявка отправлена\")]")));

        boolean present;
        try {
            driver.findElement(By.xpath("//*[contains(text(),\"Заявка отправлена\")]"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

        Assertions.assertEquals(present, true );

    }

}
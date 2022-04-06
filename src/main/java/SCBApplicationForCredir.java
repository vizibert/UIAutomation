import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SCBApplicationForCredir {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://sovcombank.ru/");
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

        boolean present;
        try {
            driver.findElement(By.xpath("//*[contains(text(),\"Заявка отправлена\")]"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

        System.out.println("Has the test been passed? " + present);
    }
}
package day02_webelement_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DriverMethodlariSoru {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Yeni bir class olusturalim (Homework)
        // ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://www.facebook.com");
        // ve sayfa basliginin (title) “facebook” oldugunu test edin, degilse dogru basligi yazdirin.

        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Facebook title testi PASSED");
        }else {
            System.out.println("Facebook title testi FAILED");
            System.out.println(actualTitle);
        }

        // Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedUrlIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Facebook Url testi PASSED");
        }else{
            System.out.println("Facebook Url testi FAILED");
            System.out.println(actualUrl);
        }

        // https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");
        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedTitleIcerik = "Walmart.com";
        actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Walmart Title testi PASSED");
        }else {
            System.out.println("Walmart Title testi FAILED");
        }


        // Tekrar “facebook” sayfasina donun

        driver.navigate().back();
        Thread.sleep(3000);
        // Sayfayi yenileyin
        driver.navigate().refresh();
        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // Browser’i  kapatin
        driver.quit();
    }
}

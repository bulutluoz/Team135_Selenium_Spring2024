package day02_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Locators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu.com adresine gidin

        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratin

            // 1- once arama kutusunu bu class'ta kaydetmemiz gerekir
         WebElement aramaKutusu = driver.findElement(By.id("global-search"));

            // 2- findBy() ile webElementi kaydedince, istenilen islemleri yapabiliriz
        aramaKutusu.sendKeys("phone");
        aramaKutusu.submit();

        // sayfayi kapatin

        driver.quit();
    }
}

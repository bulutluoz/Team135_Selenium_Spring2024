package day02_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_ByLinkText {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/");

        Thread.sleep(1000);
        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkListesi = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinksayisi = linkListesi.size();

        if (expectedLinkSayisi==actualLinksayisi){
            System.out.println("Link sayisi testi PASSED");
        }else System.out.println("Link sayisi testi FAILED");

        //4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("roducts")).click();

        //5- special offer yazisinin gorundugunu test edin
        WebElement specialyaziElementi = driver.findElement(By.id("sale_image"));

        if (specialyaziElementi.isDisplayed()){
            System.out.println("Special Offer yazi testi PASSED");
        }else System.out.println("Special Offer yazi testi FAILED");

        //6- Sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();
    }
}

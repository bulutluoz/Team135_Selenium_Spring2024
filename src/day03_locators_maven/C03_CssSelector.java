package day03_locators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_CssSelector {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2-  https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");

        //6-  Furniture linkine tiklayin

        driver.findElement(By.linkText("Furniture")).click();

        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minFiyatKutusu = driver.findElement(By.cssSelector("input[name='min']"));
        WebElement maxFiyatKutusu = driver.findElement(By.cssSelector("input[name='max']"));
        WebElement filtreleButonu = driver.findElement(By.cssSelector("button[name='button']"));

        minFiyatKutusu.clear();
        minFiyatKutusu.sendKeys("40");
        maxFiyatKutusu.clear();
        maxFiyatKutusu.sendKeys("200");
        filtreleButonu.click();

        //8-  filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.cssSelector("div[class='product-box mb-2 pb-1']"));

        if (bulunanUrunElementleriList.size()>0){
            System.out.println("Bulunan urun sayisi testi PASSED");
        }else System.out.println("Bulunan urun sayisi testi FAILED");

        //10- Ilk urunu tiklayin
        bulunanUrunElementleriList.get(0).click();

        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement urunFiyatElementi = driver.findElement(By.cssSelector("span[id='priceproduct']"));
        // $50.00
        String urunFiyatiStr = urunFiyatElementi.getText().replaceAll("\\D",""); // 5000

        double urunFiyati = Double.parseDouble(urunFiyatiStr) / 100 ;

        if (urunFiyati>=40 && urunFiyati<=200){
            System.out.println("Ilk urun fiyat testi PASSED");
        }else System.out.println("Ilk urun fiyat testi FAILED");

        //12- Sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();
    }
}

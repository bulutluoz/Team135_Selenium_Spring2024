package day02_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_XPath {

    public static void main(String[] args) throws InterruptedException {

        // gerekli ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");
        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // bulunan sonuc yazisini yazdirin
        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));
        System.out.println(sonucYaziElementi.getText()); // 4 Products Found

        // bulunan sonuclarin 2'den fazla oldugunu test edin

        int expectedMinSonuc = 2;
        int actualSonucSayisi = Integer.parseInt(sonucYaziElementi.getText().replaceAll("\\D",""));

        if (actualSonucSayisi>expectedMinSonuc){
            System.out.println("Bulunan urun sayisi testi PASSED");
        }else System.out.println("Bulunan urun sayisi testi FAILED");
        // bulunan urunlerden ikincisine tiklayin

        // once tum bulunan urunleri bir liste olarak kaydedelim

        // List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("product-box my-2  py-1"));
        // class attribute'unun value'sunde space oldugu icin By.className() calismadi

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));
        bulunanUrunElementleriList.get(1).click();

        // acilan urun sayfasinda, urun isminde
        // case sensitive olmadan phone gectigini test edin
        WebElement urunisimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmiKucukHarf = urunisimElementi.getText().toLowerCase();

        if (actualUrunIsmiKucukHarf.contains(expectedIsimIcerik)){
            System.out.println("Urun isim testi PASSED");
        }else System.out.println("Urun isim testi FAILED");

        // sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}

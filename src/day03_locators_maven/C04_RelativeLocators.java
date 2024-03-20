package day03_locators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C04_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        /*
            ONEMLI NOT

            Eger biz bir sayfada locate aldiktan sonra,
            baska sauyfalara gidip, yeniden locate aldigimiz sayfaya donuyorsak

            driver, daha onceden locate ettigimiz elementleri GOREMEYEBILIR

            bu durumda StaleElementReferenceException verir

            Bu exception'i aldigimizda kullandigimiz webelement'lerin locate'lerini tazelememiz gerekir
         */

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin

        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin

        // - once hedef html elementi inceleyip kullanabilecegimiz bir ozelligini bulalim
        //   <li id="dslr-camera">
        //      <a id="pictext7" class="overlay" href="http://testotomasyonu.com/product/32">
        //      <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
        //      <span>DSLR Camera</span></a>
        //    </li>

        // - etrafinda kullanabilecegim webelementleri locate edip, kaydedelim
        WebElement appleHeadphone= driver.findElement(By.id("apple-headphone"));
        WebElement motorTelefon= driver.findElement(By.id("motor"));
        WebElement hpBilgisayar= driver.findElement(By.id("hp-victus"));

        WebElement dslr1 = driver.findElement(RelativeLocator.with(By.id("dslr-camera"))
                                                             .toRightOf(appleHeadphone)  );
        dslr1.click();

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.
        Thread.sleep(3000);

        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR relative locator1 testi PASSED");
        }else {
            System.out.println("DSLR relative locator1 testi FAILED");
        }


        // 2.relative locator olusturmak icin geriye gidelim

        driver.get("https://testotomasyonu.com/relativeLocators");

        motorTelefon= driver.findElement(By.id("motor"));
        WebElement dslr2 = driver.findElement(RelativeLocator.with(By.id("dslr-camera")).toLeftOf(motorTelefon));
        dslr2.click();

        urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR relative locator1 testi PASSED");
        }else {
            System.out.println("DSLR relative locator1 testi FAILED");
        }

        Thread.sleep(3000);

        // 3.relative locator olusturmak icin geriye gidelim
        driver.navigate().back();

        hpBilgisayar= driver.findElement(By.id("hp-victus"));

        WebElement dslr3 = driver.findElement(RelativeLocator.with(By.tagName("li")).above(hpBilgisayar));

        dslr3.click();

        urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR relative locator1 testi PASSED");
        }else {
            System.out.println("DSLR relative locator1 testi FAILED");
        }


        Thread.sleep(3000);
        driver.quit();

    }
}

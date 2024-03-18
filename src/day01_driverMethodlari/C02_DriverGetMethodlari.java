package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        // get(String url) verilen url'e gider
        // url yazarken www yazmasak da olabilir
        // ANCAK https:// yazmazsak kod calismaz

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/

        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

        // driver objesi kullandigi her bir window icin unique bir Window Handle Degeri uretir
        // driver her yeni calistirmada bu WHD'ini unique olarak yeniden olusturur
        // WHD bir driver ile birden fazla window actigimizda, bu window'lar arasinda gecis yapmamizi saglar
        // getWindowHandle() : driver'in icinde oldugu window'un WHD'ini getirir
        // getWindowHandles() : driver calismaya basladiktan sonra, birden fazla window olusturdu ise
        //                      olusturulan tum window'larin WHD'lerini bir Set olarak dondurur
        System.out.println(driver.getWindowHandle()); // DB9D8B42B0905D565DE2DC2951949A33
        System.out.println(driver.getWindowHandles()); // [DB9D8B42B0905D565DE2DC2951949A33]

        System.out.println(driver.getPageSource());

        Thread.sleep(3000);
        driver.quit();

    }
}

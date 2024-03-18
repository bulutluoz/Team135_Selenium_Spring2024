package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(2000);

        driver.navigate().to("https://www.bestbuy.com");
        Thread.sleep(2000);

        // tekrar testotomasyonu sayfasina donun
        driver.navigate().back();
        Thread.sleep(2000);

        // yeniden bestbuy sayfasina gidin

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();

        driver.quit();

    }
}

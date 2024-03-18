package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(3000);

        // sayfanin acilmasi
        // veya sayfada aradigimiz webelementleri bulmak icin
        // belirlenen maximum bekleme suresidir

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

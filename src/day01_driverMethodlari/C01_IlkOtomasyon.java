package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(5000);

        // driver.close();
        driver.quit();

    }
}

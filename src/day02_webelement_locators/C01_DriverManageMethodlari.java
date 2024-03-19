package day02_webelement_locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.manage().window().maximize();
        System.out.println("Maximize konum : " + driver.manage().window().getPosition());
        System.out.println("Maximize size : " + driver.manage().window().getSize());

        Thread.sleep(3000);

        driver.manage().window().fullscreen();
        System.out.println("Fullscreen konum : " + driver.manage().window().getPosition());
        System.out.println("Fullscreen size : " + driver.manage().window().getSize());

        Thread.sleep(3000);

        driver.manage().window().setPosition(new Point(300,300));
        driver.manage().window().setSize(new Dimension(500,700));
        System.out.println("Ozel window konum : " + driver.manage().window().getPosition());
        System.out.println("Ozel window size : " + driver.manage().window().getSize());
        Thread.sleep(3000);


        driver.manage().window().minimize();

        Thread.sleep(3000);

        driver.quit();
    }
}

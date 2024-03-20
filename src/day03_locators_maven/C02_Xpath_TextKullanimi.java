package day03_locators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath_TextKullanimi {

    public static void main(String[] args) {
        //System.setProperty("WebDriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonElementi = driver.findElement(By.xpath("//*[text()='Remove']"));

        if (removeButonElementi.isDisplayed()){
            System.out.println("Remove butonu gorunme testi PASSED");
        }else System.out.println("Remove butonu gorunme testi FAILED");

        //4- Remove tusuna basin

        removeButonElementi.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add/Remove yazi testi PASSED");
        }else System.out.println("Add/Remove yazi testi FAILED");


        driver.quit();
    }
}

package com.cool.testers.selenium;

import java.io.File;
import java.nio.file.Paths;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsEjemplo {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;

        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/popup.php");

        String originalTab = driver.getWindowHandle();
        System.out.println(originalTab);

        WebElement clickHere = driver.findElement(By.xpath("//*[contains(@href, 'popup.php')]"));
        clickHere.click();

        Set<String> ventanasAbiertas = driver.getWindowHandles();
        System.out.println(ventanasAbiertas);

        for (String tabNueva : driver.getWindowHandles()) {
            if (!originalTab.contentEquals(tabNueva)) {
                driver.switchTo().window(tabNueva);
                break;
            }
        }

        WebElement inputMail = driver.findElement(By.name("emailid"));
        inputMail.sendKeys("correo@correo.com");

        driver.switchTo().window(originalTab);
    }

}

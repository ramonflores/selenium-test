package com.cool.testers.selenium;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    public static void main(String[] args) {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        /** Implicitly wait **/
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement username = driver.findElement(By.id("txtUsername"));

        /** Explicitly wait **/
        WebElement webElement = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("txtUsername")));
        webElement.sendKeys("test");
    }

}

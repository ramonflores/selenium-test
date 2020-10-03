package com.cool.testers.selenium;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    public static void main(String[] args) {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        /** Implicitly wait **/
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement username = driver.findElement(By.id("txtUsername"));

        /** Explicitly wait **/
//        WebElement webElement = new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.elementToBeClickable(By.id("txtUsername")));
//        webElement.sendKeys("test");

        /** Fluent wait **/
        // El ignoring es lo que ignora el wait por el tiempo indicado
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

        WebElement txtUsername = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webdriver) {
                webdriver.navigate().refresh();
                return webdriver.findElement(By.id("txtUsername"));
            }
        });

        txtUsername.sendKeys("Admin");

    }

}

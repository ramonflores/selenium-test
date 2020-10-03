package com.cool.testers.selenium;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

    @Test
    public void equalsTituloPagina() {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void trueTituloPagina() {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

}

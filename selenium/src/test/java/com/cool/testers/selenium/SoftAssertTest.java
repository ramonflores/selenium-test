package com.cool.testers.selenium;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

    SoftAssert softAssert = new SoftAssert();

    /**
     * Permite continuar con la ejecución aun cuando falle alguno de los asserts.
     */
    @Test
    public void softAssertEquals() {

        int a = 5, b = 10, x = 8, y = 8;

        softAssert.assertEquals(a, b);
        softAssert.assertEquals(x, y);

        softAssert.assertAll();
    }
    
    @Test
    public void softAssertTitle( ) {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        String badTitle = "OrangeHR";

        softAssert.assertEquals(actualTitle, badTitle);
        softAssert.assertEquals(actualTitle, expectedTitle);

        softAssert.assertAll();

        driver.close();
    }

}

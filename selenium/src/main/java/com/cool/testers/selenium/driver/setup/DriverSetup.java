package com.cool.testers.selenium.driver.setup;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Regresa una instancia del WebDriver para ejecutar las pruebas automatizadas.
 * Aquí es donde se decide con qué navegador se harán las pruebas.
 * 
 * @author ramon.flores
 *
 */
public class DriverSetup {

    public static WebDriver setupDriver() {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

}

package com.cool.testers.selenium;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        WebElement buttonLogin = driver.findElement(By.id("btnLogin"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");

        buttonLogin.click();

        String url = driver.getCurrentUrl();
        System.out.println(url);

        List<WebElement> firstLevelMenu = driver.findElements(By.xpath("//*[@class='firstLevelMenu']/b"));

        System.out.println("Número de elementos: " + firstLevelMenu.size());

        for (int i = 0; i < firstLevelMenu.size(); i++) {
            System.out.println("Los menús son: " + firstLevelMenu.get(i).getText());
        }
    }

}

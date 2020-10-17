package com.cool.testers.selenium.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonMethods {

    public static void takeScreenshot(WebDriver driver, String testCaseName) {

        File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Lo deja en target/test-output
        String screenshotPath = Paths.get("").toAbsolutePath().toString() + File.separator + "test-output"
                + File.separator + testCaseName;

        try {

            FileHandler.createDir(new File(screenshotPath));

            // Funciona solo con PNG
            FileHandler.copy(screenFile, new File(screenshotPath + File.separator + "evidencia.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}

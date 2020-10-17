package com.cool.testers.selenium.navigation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cool.testers.selenium.constantes.VariablesGlobalesConstantes;
import com.cool.testers.selenium.driver.setup.DriverSetup;

public class CorrectLoginTest {

    private WebDriver driver = DriverSetup.setupDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @BeforeTest
    public void startWebDriver() {
        driver.get(VariablesGlobalesConstantes.HOME_PAGE);
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        loginPage.login(VariablesGlobalesConstantes.USER_ADMIN, VariablesGlobalesConstantes.PASSWORD_ADMIN);
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

}

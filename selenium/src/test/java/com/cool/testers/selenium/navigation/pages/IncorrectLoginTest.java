package com.cool.testers.selenium.navigation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cool.testers.selenium.constantes.VariablesGlobalesConstantes;
import com.cool.testers.selenium.driver.setup.DriverSetup;

public class IncorrectLoginTest {

    private WebDriver driver = DriverSetup.setupDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @BeforeTest
    public void startWebDriver() {
        driver.get(VariablesGlobalesConstantes.HOME_PAGE);
    }

    @Test
    public void loginTest() {

        final boolean incorrectLogin = loginPage.incorrectLogin(VariablesGlobalesConstantes.USER_ADMIN, "Hello");

        assertTrue(incorrectLogin);
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

}

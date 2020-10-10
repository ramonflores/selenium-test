package com.cool.testers.selenium.navigation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cool.testers.selenium.constantes.VariablesGlobalesConstantes;
import com.cool.testers.selenium.driver.setup.DriverSetup;

public class LogoutTest {

    private WebDriver driver = DriverSetup.setupDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private DashboardPage dashboardPage = new DashboardPage(driver);

    @BeforeTest
    public void startWebDriver() {
        driver.get(VariablesGlobalesConstantes.HOME_PAGE);
        driver.manage().window().maximize();
    }

    @Test
    public void logoutTest() {

        loginPage.login(VariablesGlobalesConstantes.USER_ADMIN, VariablesGlobalesConstantes.PASSWORD_ADMIN);

        assertTrue(driver.getCurrentUrl().contains("dashboard"));

        dashboardPage.logout();

        assertTrue(driver.getCurrentUrl().contains(VariablesGlobalesConstantes.HOME_PAGE));
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

}

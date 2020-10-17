package com.cool.testers.selenium.navigation.pages;

import org.testng.annotations.Test;

import com.cool.testers.selenium.common.CommonMethods;
import com.cool.testers.selenium.constantes.VariablesGlobalesConstantes;
import com.cool.testers.selenium.driver.setup.DriverSetup;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class LoginParameterTest {

    private WebDriver driver = DriverSetup.setupDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @BeforeTest
    public void beforeTest() {
        driver.get(VariablesGlobalesConstantes.HOME_PAGE);
    }

    @Test
    @Parameters({ "user", "password" })
    public void loginParameterTest(String user, String password) {

        loginPage.login(user, password);

        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @AfterTest
    public void afterTest() {
        CommonMethods.takeScreenshot(driver, "loginParameterTest");
        driver.quit();
    }

}

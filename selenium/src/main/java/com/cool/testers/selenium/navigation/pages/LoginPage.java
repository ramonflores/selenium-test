package com.cool.testers.selenium.navigation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "txtUsername")
    private WebElement usernameTxt;

    @FindBy(id = "txtPassword")
    private WebElement passwordTxt;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"spanMessage\"]")
    private WebElement msjError;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String password) {

        usernameTxt.sendKeys(user);
        passwordTxt.sendKeys(password);

        btnLogin.click();
    }

    public boolean incorrectLogin(String user, String password) {

        usernameTxt.sendKeys(user);
        passwordTxt.sendKeys(password);

        btnLogin.click();

        return msjError.getText().contains("Invalid credentials");
    }

}

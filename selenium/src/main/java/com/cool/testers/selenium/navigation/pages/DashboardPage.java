package com.cool.testers.selenium.navigation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @FindBy(id = "welcome")
    private WebElement btnWelcome;

//    @FindBy(xpath = "//*[@id=\"welcome-menu\"]/ul/li[2]/a")
//    @FindBy(xpath = "//a[text()=\"Logout\"]")
    @FindBy(xpath = "//*[@id=\"welcome-menu\"]/ul/li/a[text()=\"Logout\"]")
//    @FindBy(xpath = "xpath=//a[contains(@href,'logout')]") // Does not work
    private WebElement btnLogout;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logout() {

        btnWelcome.click();
        btnLogout.click();
    }

}

package ru.IraGolubkova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-test='username']")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = "['data-test='login-button']")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterLogin(String LoginName) {
        loginInput.click();
        loginInput.sendKeys(LoginName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        return this;

    }

    public InventoryPage clickLoginButton() {
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        return new InventoryPage(driver);
    }

}

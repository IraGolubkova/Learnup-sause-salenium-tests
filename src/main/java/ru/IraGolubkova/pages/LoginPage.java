package ru.IraGolubkova.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-test='username']")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = "['data-test='login-button']")
    private WebElement loginButton;
    @Getter
    @FindBy(css = "[data-test='error']")
    WebElement errorLogIn;
    @Getter
    @FindBy(className = "error-button")
    WebElement errorButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Вводим логин {loginName}")
    public LoginPage enterLogin(String LoginName) {
        loginInput.click();
        loginInput.sendKeys(LoginName);
        return this;
    }
    @Step("Вводим пароль {password}")
    public LoginPage enterPassword(String password) {
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        return this;

    }
    @Step("Нажимаем на кнопку 'Авторизоваться'")
    public InventoryPage clickLoginButton() {
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        return new InventoryPage(driver);
    }
    @Step("Удаляем поля авторизации")
    public LoginPage cleaningAuthorization() {
        errorButton.click();
        loginInput.clear();
        passwordInput.clear();
        return this;
    }
    public LoginPage checkLoginPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        return this;
    }

    public LoginPage checkErrorLogIn() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        assertThat(errorLogIn.getAccessibleName(), equalTo("Epic sadface: Username and password do not match any user in this service"));
        return this;
    }

    public LoginPage checkErrorLockedUser() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        assertThat(errorLogIn.getAccessibleName(), equalTo("Epic sadface: Sorry, this user has been locked out."));
        return this;
    }
}


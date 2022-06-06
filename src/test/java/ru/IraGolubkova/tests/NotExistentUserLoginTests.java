package ru.IraGolubkova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.IraGolubkova.pages.LoginPage;


@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты логина на сайте  https://www.saucedemo.com/ для несуществующего пользователя")
@Epic("Проблемный пользователь")
public class NotExistentUserLoginTests extends BaseTest {

    @Test
    void shouldStayOnLoginPageAndShowLogInError() {
        new LoginPage(driver)
                .enterLogin(notExistentUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkLoginPageUrl()
                .checkLoginIs(notExistentUsername)
                .checkPasswordIs(password)
                .checkErrorLogIn();
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

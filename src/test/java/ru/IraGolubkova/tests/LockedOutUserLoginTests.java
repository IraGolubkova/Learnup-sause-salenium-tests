package ru.IraGolubkova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.IraGolubkova.pages.LoginPage;


@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты логина на сайте https://www.saucedemo.com/ для заблокированного пользователя ")
@Epic("Заблокированный пользователь")
public class LockedOutUserLoginTests extends BaseTest {

    @Test
    void shouldStayOnLoginPageAndShowLogInError() {
        new LoginPage(driver)
                .enterLogin(lockedOutUsername)
                .enterPassword(lockedOutPassword)
                .clickLoginButton()
                .checkLoginPageUrl()
                .checkLoginIs(lockedOutUsername)
                .checkPasswordIs(lockedOutPassword)
                .checkErrorLockedUser();
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

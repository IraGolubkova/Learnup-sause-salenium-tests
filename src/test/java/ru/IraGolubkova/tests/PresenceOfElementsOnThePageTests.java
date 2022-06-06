package ru.IraGolubkova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.IraGolubkova.pages.BaseAuthorizedPage;
import ru.IraGolubkova.pages.LoginPage;


@Severity(SeverityLevel.CRITICAL)
@Feature("Тесты на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html для обычного пользователя")
@Story("Тесты на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html для обычного пользователя")
@Epic("Обычный пользователь")
public class PresenceOfElementsOnThePageTests extends BaseTest {

    @BeforeAll
    static void beforeAll() {
        username = properties.getProperty("standard.username");
        password = properties.getProperty("standard.password");
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    //на наличие элементов на странице https://www.saucedemo.com/checkout-step-one.html"
    @Test
    void PresenceOfElementsPositiveTest() {
        new BaseAuthorizedPage(driver)
                .checkTitleSite()
                .checkSideMenuButton()
                .checkLogoLabel()
                .checkCartButton()
                .clickToCartButton()
                .checkSideAllItemsButton()
                .checkSideLabelAllItemsButton()
                .checkSideAboutButton()
                .checkSideLabelAboutButton()
                .checkSideLogoutButton()
                .checkSideLabelLogoutButton()
                .checkSideResetAppStateButton()
                .checkSideLabelResetAppStateButton()
                .checkSideCrossButton()
                .checkTwitterButton()
                .checkFacebookButton()
                .checkLinkedInButton()
                .checkRobotInImage()
                .checkInformation()
                .goToFacebook();
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

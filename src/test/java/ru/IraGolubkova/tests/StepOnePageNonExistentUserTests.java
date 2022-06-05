package ru.IraGolubkova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.IraGolubkova.pages.LoginPage;
import ru.IraGolubkova.pages.StepOnePage;


@Severity(SeverityLevel.BLOCKER)
@Feature("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для несуществующего пользователя")
@Story("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для несуществующего пользователя")
@Epic("Несуществующего пользователя")
public class StepOnePageNonExistentUserTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(StepOnePageNonExistentUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        new LoginPage(driver)
                .enterLogin(username + "1111")
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();
        new LoginPage(driver)
                .checkErrorLogIn()
                .checkErrorLockedUser()
                .cleaningAuthorization()
                .checkLoginPageUrl();

        logger.info("Функциональные тесты на странице https://www.saucedemo.com/checkout-step-one.html для несуществующего пользователя пользователя");

    }

    @Test
    void errorChecksTests() {
        new StepOnePage(driver)
                .checkStepOnePageUrl()
                .enterFirstName()
                .enterLastName()
                .enterPostalCode()
                .clickToContinueButton()
                .checkFieldFirstName()
                .checkFieldLastName()
                .checkFieldPostalCode()
                .checkCancelButton()
                .checkLabelCancelButton()
                .checkContinueButton();

    }
    @Test
    void sendChecksTests() {
        logger.info("Проверка функциональности заполнения полей");
        new StepOnePage(driver)
                .enterFirstName()
                .enterLastName()
                .enterPostalCode()
                .clickToContinueButton()
                .clickToCartButton()
                .clickToCheckoutButton();
        logger.info("Проверка функциональности заполнения полей завершена");
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

package ru.IraGolubkova.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.IraGolubkova.pages.*;

public class AuthorisationTests extends BaseTest {

    static String username;
    static String password;


    @BeforeAll
    static void beforeAll() {
        username = properties.getProperty("standard.username");
        password = properties.getProperty("standard.password");
    }

    @Test
    void authorisationPositiveLoginPageTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();
        new InventoryPage(driver)
                .checkInventoryPageUrl()
                .checkInventoryCartOnThePage()
                .clickInventoryPageBackpack()
                .clickInventoryPageBasket();
        new CartPage(driver)
                .checkCartPageBasketUrl()
                .checkItemInTheCart()
                .clickToCheckoutButton();
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
        new StepTwoPage(driver)
                .checkStepTwoPageUrl()
                .checkStepTwoPageInformation()
                .clickToStepTwoPageFinishButton();
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

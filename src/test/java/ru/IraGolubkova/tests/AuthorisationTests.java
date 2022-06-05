package ru.IraGolubkova.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.IraGolubkova.pages.*;

@Severity(SeverityLevel.BLOCKER)
@Feature("Тесты на авторизацию в системе")
@Story("Тесты на авторизацию в системе")
public class AuthorisationTests extends BaseTest {

    @Test
    void authorisationPositiveLoginPageTest() {
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();
        new InventoryPage(driver)
                .checkInventoryPageUrl()
                .checkInventoryCartOnThePage()
                .clickInventoryPageBackpack()
                .checkInventoryRemoveBackpackButton()
                .clickInventoryPageBasket();
        new CartPage(driver)
                .checkCartPageBasketUrl()
                .checkItemInTheCart()
                .checkBikeLightInTheCart()
                .checkBoltTShirtInTheCart()
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
                .checkLabelInformation()
                .clickToStepTwoPageFinishButton();
        new CheckoutCompletePage(driver)
                .CheckTheTextOnThePage()
                .checkCompletePageUrl();

    }

    @Test
    void authorisationWithLoginPageNegativeTest() {
        driver.get(baseUrl);
        new LoginPage(driver)
                .enterLogin(username + "1111")
                .enterPassword(password)
                .clickLoginButton();
        new LoginPage(driver)
                .checkErrorLogIn()
                .cleaningAuthorization()
                .checkLoginPageUrl();

    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

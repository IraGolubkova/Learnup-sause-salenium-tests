package ru.IraGolubkova.tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.IraGolubkova.pages.*;

@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для обычного пользователя")
@Story("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для обычного пользователя")
@Epic("Обычный пользователь")
public class ProblemUserTests extends BaseTest {

    @BeforeAll
    static void beforeSuit() {
        new LoginPage(driver)
                .enterLogin(problemUsername)
                .enterPassword(problemPassword)
                .clickLoginButton();
    }

    @Test
    void shouldOrder() {
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

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

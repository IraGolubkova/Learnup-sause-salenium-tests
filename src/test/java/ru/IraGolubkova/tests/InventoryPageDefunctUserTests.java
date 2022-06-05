package ru.IraGolubkova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.IraGolubkova.pages.InventoryPage;
import ru.IraGolubkova.pages.LoginPage;


@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для несуществующего пользователя")
@Story("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для несуществующего пользователя")
@Epic("Несуществующий пользователь")
public class InventoryPageDefunctUserTests extends BaseTest {
    static final Logger logger = LoggerFactory.getLogger(InventoryPageDefunctUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        new LoginPage(driver)
                .enterLogin(username + "1111")
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl();
}
@Test
void PresenceOfElementsOnThePageTest() {
    new InventoryPage(driver)
            .checkInventoryPageUrl()
            .checkInventoryCartOnThePage()
            .clickInventoryPageBackpack()
            .checkInventoryRemoveBackpackButton()
            .clickInventoryPageBasket();
    new InventoryPage(driver)  //заходим на страницу
            .goPageBackpack()    .backToProducts()
            .goPageBikeLight()   .backToProducts()
            .goPageBoltTShirt()  .backToProducts();
    new InventoryPage(driver) //отоброжение кнопки ADD Remove
            .checkAddBackpackToCartButton()
            .checkAddBikeLightToCartButton()
            .checkAddBoltTShirtToCartButton()
            .clickRemoveBackpackButton()
            .clickAddBikeLightToCartButton()
            .clickRemoveBikeLightButton()
            .clickAddBoltTShirtToCartButton()
            .clickRemoveBoltTShirtButton();

    }
}

package ru.IraGolubkova.tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.IraGolubkova.pages.InventoryPage;
import ru.IraGolubkova.pages.LoginPage;

import static ru.IraGolubkova.elements.SortingDropDownValues.*;

@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для обычного пользователя")
@Story("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для обычного пользователя")
@Epic("Обычный пользователь")
public class ProductSortingTests extends BaseTest {

    static final Logger logger = LoggerFactory.getLogger(ProductSortingTests.class);

    @BeforeAll
    static void beforeSuit() {
        logger.info("логин " + username);
        logger.info("пароль " + password);
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();

        new InventoryPage(driver)
                .checkInventoryPageUrl();
    }

    @Test
    @Description("Тест на функцию сортировки AZ")
    void nameAZStandardUserTest() {
        logger.info("Тест на функцию сортировки AZ");
        new InventoryPage(driver)
                .chooseSortingOption(NAME_ASC)
                .checkAZSorting();
        logger.info("Тест на функцию сортировки AZ завершен");

    }

    @Test
    @Description("Тест на функцию сортировки ZA")
    void nameZAStandardUserTest() {
        new InventoryPage(driver)
                .chooseSortingOption(NAME_DESC)
                .checkZASorting();
    }

    @Test
    @Description("Тест на функцию сортировки LowToHigh")
    void priceLowToHighStandardUserTest() {
        logger.info("Тест на функцию сортировки LowToHigh");
        logger.info("ник " + username);
        logger.info("пароль " + password);
        new InventoryPage(driver)
                .chooseSortingOption(PRICE_ASC)
                .checkLowToHighSorting();
    }

    @Test
    @Description("Тест на функцию сортировки HighToLow")
    void priceHighToLowStandardUserTest() {
        logger.info("Тест на функцию сортировки HighToLow");
        logger.info("ник " + username);
        logger.info("пароль " + password);
        new InventoryPage(driver)
                .chooseSortingOption(PRICE_DESC)
                .checkHighToLowSorting();
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

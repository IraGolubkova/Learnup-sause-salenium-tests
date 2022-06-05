package ru.IraGolubkova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.IraGolubkova.pages.InventoryPage;
import ru.IraGolubkova.pages.LoginPage;

import static ru.IraGolubkova.elements.SortingDropDownValues.*;

@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для несуществующего пользователя")
@Story("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ для несуществующего пользователя")
@Epic("Несуществующий пользователь")

public class SortingNonExistentUserTests extends BaseTest {
    static final Logger logger = LoggerFactory.getLogger(SortingNonExistentUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        new LoginPage(driver)
                .enterLogin(username + "1111")
                .enterPassword(password)
                .clickLoginButton()
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
        logger.info("Тест на функцию сортировки ZA");
        new InventoryPage(driver)
                .chooseSortingOption(NAME_DESC)
                .checkZASorting();
        logger.info("Тест завершен");
    }

    @Test
    @Description("Тест на функцию сортировки ToHigh")
    void priceToHighStandardUserTest() {
        logger.info("Тест на функцию сортировки ToHigh");
        logger.info("ник " + username);
        logger.info("пароль " + password);
        new InventoryPage(driver)
                .chooseSortingOption(PRICE_ASC)
                .checkToHighSorting()
                .checkToLowSorting();
        logger.info("Тест завершен");
    }
}

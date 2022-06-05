package ru.IraGolubkova.tests.tech;

import groovy.util.logging.Slf4j;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.IraGolubkova.elements.SortingDropDownValues;
import ru.IraGolubkova.pages.InventoryPage;
import ru.IraGolubkova.pages.LoginPage;
import ru.IraGolubkova.tests.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.IraGolubkova.elements.SortingDropDownValues.NAME_ASC;

@Slf4j
@Epic("Технические тесты")
@Story("Тесты на удаление/добавление cookie")
public class CookiesTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(CookiesTests.class);
    @Getter
    static String baseUrl;
    @Getter
    static String username;
    @Getter
    static String password;
    @Getter
    static String defunctUsername;

    @Test
        // тест должен падать, так как мы подставляем сломанного пользователя
    void setCookiesTest() {
        InventoryPage inventoryPage = new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("session-username", "locked_out_user", "/"));
// тест должен падать
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
    }

    @Test
    void name() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .chooseSortingOption(SortingDropDownValues.valueOf(String.valueOf(NAME_ASC)));

        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
        logger.info("Тест на обнуление куки при входе с другим логином");
        logger.info("вход с  " + getDefunctUsername());
        logger.info("пароль " + getPassword());
        InventoryPage inventoryPage = new LoginPage(getDriver())
                .enterLogin(getDefunctUsername())
                .enterPassword(getPassword())
                .clickLoginButton()
                .clickAddBackpackToCartButton();
        assertThat(inventoryPage.checkInventoryCartOnThePage(), equalTo("1"));
        getDriver().manage().deleteAllCookies();
        logger.info("вход с  " + getUsername());
        getDriver().manage().addCookie(new Cookie("session-username", "problem_user", "/"));
        assertThat(inventoryPage.checkInventoryCartOnThePage(), equalTo("0"));
        logger.info("Тест на обнуление куки при входе с другим логином завершен");

    }

    private WebDriver getDriver() {
        return null;
    }

    @AfterEach
    void tearDown() {
        getDriver().get(getBaseUrl());
        new LoginPage(getDriver())
                .enterLogin(getUsername())
                .enterPassword(getPassword())
                .clickLoginButton();

    }
}


package ru.IraGolubkova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.IraGolubkova.pages.BaseAuthorizedPage;
import ru.IraGolubkova.pages.InventoryPage;
import ru.IraGolubkova.pages.LoginPage;


@Severity(SeverityLevel.TRIVIAL)
@Feature("Тесты перехода на страницы соц.сетей на сайте https://www.saucedemo.com/ для несуществующего пользователя")
@Story("Тесты перехода на страницы соц.сетей на сайте https://www.saucedemo.com/ для несуществующего пользователя пользователя")
@Epic("Проблемный пользователь")
public class DefunctUserBasementTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(DefunctUserBasementTests.class);


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

    }

    @Test
    void thePresenceOfElementsInTheBasementTest() {
        new BaseAuthorizedPage(driver)
                .checkTwitterButton()
                .checkFacebookButton()
                .checkLinkedInButton()
                .checkRobotInImage()
                .checkInformation();

    }

    @Test
    void footerPageTransitionsTest() {
        new InventoryPage(driver)
                .goToTwitter();


    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

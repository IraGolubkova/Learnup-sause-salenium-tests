package ru.IraGolubkova.tests;

import org.junit.jupiter.api.Test;
import ru.IraGolubkova.pages.LoginPage;

public class PageFooterTests extends BaseTest {

    @Test
    void goToLinkedInTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .goToLinkedIn();
    }
}

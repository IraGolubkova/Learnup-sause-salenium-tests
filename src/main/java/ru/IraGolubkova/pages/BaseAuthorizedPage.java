package ru.IraGolubkova.pages;

import io.qameta.allure.Step;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.IraGolubkova.utils.TabUtils.switchToTheNextTab;


public class BaseAuthorizedPage extends BasePage {
    //верхняя часть страницы
    @FindBy(id = "react-burger-menu-btn")
    WebElement sideMenuButton;
    @FindBy(className = "app_logo")
    WebElement logoLabel;
    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;
    //боковое меню
    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsButton;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutButton;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetButton;
    @FindBy(id = "react-burger-cross-btn")
    WebElement сrossButton;
    //подвал
    @FindBy(css = ".social_twitter a")
    WebElement twitterButton;
    @FindBy(css = ".social_facebook a")
    WebElement facebookButton;
    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton;
    @FindBy(css = ".footer_copy")
    WebElement footerInLabel;
    @FindBy(css = ".footer_robot")
    WebElement robotInImage;

    public BaseAuthorizedPage(final WebDriver driver) {
        super(driver);

    }

    public BaseAuthorizedPage checkTitleSite() {
        assertThat(driver.getTitle(), equalTo("Swag Labs"));
        return this;
    }

    public BaseAuthorizedPage checkSideMenuButton() {
        //assertThat(existsElement(sideMenuButton), equalTo(true));
        assertThat(driver.findElements(By.cssSelector("#react-burger-menu-btn")).size(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkLogoLabel() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        ;
        return this;
    }

    public BaseAuthorizedPage checkCartButton() {
        //assertThat(existsElement(cartButton), equalTo(true));
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public CartPage clickToCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }

    public BaseAuthorizedPage checkSideAllItemsButton() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkSideLabelAllItemsButton() {
        assertThat(allItemsButton.getAccessibleName(), equalTo(""));
        return this;
    }

    public BaseAuthorizedPage checkSideAboutButton() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkSideLabelAboutButton() {
        assertThat(aboutButton.getAccessibleName(), equalTo(""));
        return this;
    }

    public BaseAuthorizedPage checkSideLogoutButton() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkSideLabelLogoutButton() {
        assertThat(logoutButton.getAccessibleName(), equalTo(""));
        return this;
    }

    public BaseAuthorizedPage checkSideResetAppStateButton() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkSideLabelResetAppStateButton() {
        assertThat(resetButton.getAccessibleName(), equalTo(""));
        return this;
    }

    public BaseAuthorizedPage checkSideCrossButton() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkTwitterButton() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    String existsElement() {
        return null;
    }

    public void goToTwitter() {
        twitterButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("twitter.com"));
    }

    public BaseAuthorizedPage checkFacebookButton() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public void goToFacebook() {
        facebookButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("facebook.com"));
    }

    public BaseAuthorizedPage checkLinkedInButton() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public void goToLinkedIn() {
        linkedInButton.click();
        switchToTheNextTab(driver);
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));
    }

    public BaseAuthorizedPage checkRobotInImage() {
        assertThat(existsElement(), not(CoreMatchers.equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkInformation() {
        assertThat(footerInLabel.getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        return this;
    }

    void tearDown() {
        WebElement exitSideButton = null;
        assert false;
        exitSideButton.click();
        logoutButton.click();
    }

    @Step
    public LoginPage logOut() {
            sideMenuButton.click();
            resetButton.click();
            logoutButton.click();
            return new LoginPage(driver);

    }
}



package ru.IraGolubkova.pages;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPage extends BaseAuthorizedPage {

    @FindBy(id = "item_4_title_link")
    WebElement linkInBackpack;
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkCartPageBasketUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return this;
    }

    public CartPage checkItemInTheCart() {
        assertThat(existsElement(), CoreMatchers.equalTo(null));
        return this;
    }

    public StepOnePage clickToCheckoutButton() {
        checkoutButton.click();
        return new StepOnePage(driver);
    }

}


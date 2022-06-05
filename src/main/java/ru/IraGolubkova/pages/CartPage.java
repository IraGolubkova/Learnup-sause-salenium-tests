package ru.IraGolubkova.pages;

import lombok.Getter;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPage extends BaseAuthorizedPage {

    @Getter
    @FindBy(id = "#item_4_title_link")
    WebElement itemInBackpack;
    @Getter
    @FindBy(css = "#item_0_title_link")
    WebElement itemBikeTShirt;
    @Getter
    @FindBy(css = "#item_1_title_link")
    WebElement itemBoltTShirt;
    @Getter
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

    public CartPage checkBikeLightInTheCart() {
        assertThat(existsElement(itemBikeTShirt), equalTo(true));
        return this;
    }

    public CartPage checkBoltTShirtInTheCart() {
        assertThat(existsElement(itemBoltTShirt), equalTo(true));
        return this;
    }

    public StepOnePage clickToCheckoutButton() {
        checkoutButton.click();
        return new StepOnePage(driver);
    }

}


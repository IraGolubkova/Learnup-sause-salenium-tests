package ru.IraGolubkova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryPage extends BaseAuthorizedPage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage checkInventoryPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage checkInventoryCartOnThePage() {
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo(0)));
        return this;
    }

    public InventoryPage clickInventoryPageBackpack() {
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        return new InventoryPage(driver);
    }

    public InventoryPage clickInventoryPageBasket() {
        driver.findElement(By.cssSelector("[class='shopping_cart_link']")).click();
        return new InventoryPage(driver);
    }


}








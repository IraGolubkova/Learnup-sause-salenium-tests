package ru.IraGolubkova.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.IraGolubkova.elements.SortingDropDownValues;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class InventoryPage extends BaseAuthorizedPage {

    @Getter
    @FindBy(id = "shopping_cart_container")
    WebElement cartContainer;
    @Getter
    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;
    @Getter
    @FindBy(css = "[data-test=product_sort_container]")
    WebElement sortingDropdown;


    @Getter
    @FindBy(css = "#item_4_title_link")
    WebElement itemBackpack;
    @Getter
    @FindBy(css = "#item_1_title_link")
    WebElement itemBoltTShirt;
    @Getter
    @FindBy(css = "#item_0_title_link")
    WebElement itemBikeLight;

    @Getter
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpackButton;
    @Getter
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpackButton;
    @Getter
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addBoltTShirtButton;
    @Getter
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeBoltTShirtButton;
    @Getter
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLightButton;
    @Getter
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikeLightButton;

    @Getter
    @FindBy(css = "[data-test = back-to-products]")
    WebElement backToProductsButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
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

    public InventoryPage checkInventoryRemoveBackpackButton() {
        assertThat(existsElement(removeBackpackButton), equalTo(true));
        assertThat(driver.findElements(By.id("add-to-cart-sauce-labs-backpack")).size(), equalTo(0));
        return this;
    }

    // имя опции текстом
    public InventoryPage chooseSortingOption(String value) {
        sortingDropdown.click();
        By locator = SortingDropDownValues.valueOf(value).getElementLocator();
        driver.findElement(locator).click();
        return this;
    }

    // имя опции типом ENUM
    public InventoryPage chooseSortingOption(SortingDropDownValues value) {
        sortingDropdown.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }

    @Step("Заходим на страницу товара Sauce Labs Backpack")
    public InventoryPage goPageBackpack() {
        itemBackpack.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=4"));
        return this;
    }

    @Step("Заходим на страницу товара Sauce Labs Bolt T-Shirt")
    public InventoryPage goPageBoltTShirt() {
        itemBoltTShirt.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=1"));
        return this;
    }

    @Step("Заходим на страницу товара Sauce Labs Bike Light")
    public InventoryPage goPageBikeLight() {
        itemBikeLight.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory-item.html?id=0"));
        return this;
    }

    @Step("Возвращаемся со страницы товара в каталог товаров")
    public InventoryPage backToProducts() {
        backToProductsButton.click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage checkAddBackpackToCartButton() {
        assertThat(existsElement(addBackpackButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-sauce-labs-backpack")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkAddBikeLightToCartButton() {
        assertThat(existsElement(addBikeLightButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-to-cart-sauce-labs-bike-light")).size(), equalTo(0));
        return this;
    }

    public InventoryPage checkAddBoltTShirtToCartButton() {
        assertThat(existsElement(addBoltTShirtButton), equalTo(true));
        assertThat(driver.findElements(By.id("remove-to-cart-sauce-labs-bolt-t-shirt")).size(), equalTo(0));
        return this;
    }

    @Step("Кладем в корзину Backpack в каталоге")
    public InventoryPage clickAddBackpackToCartButton() {
        addBackpackButton.click();
        return this;
    }

    @Step("Убираем из корзины Backpack в каталоге")
    public InventoryPage clickRemoveBackpackButton() {
        removeBackpackButton.click();
        return this;
    }

    @Step("Кладем в корзину Bike Light ")
    public InventoryPage clickAddBikeLightToCartButton() {
        addBikeLightButton.click();
        return this;
    }

    @Step("Убираем из корзины Bike Light в каталоге")
    public InventoryPage clickRemoveBikeLightButton() {
        removeBikeLightButton.click();
        return this;
    }

    @Step("Кладем в корзину Bolt T-Shirt")
    public InventoryPage clickAddBoltTShirtToCartButton() {
        addBoltTShirtButton.click();
        return this;
    }

    @Step("Убираем из корзины Bolt T-Shirt в каталоге")
    public InventoryPage clickRemoveBoltTShirtButton() {
        removeBoltTShirtButton.click();
        return this;
    }

    public InventoryPage checkZASorting() {
        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductNamesTest = new ArrayList<>();
        listOfProductNamesTest.add(itemBoltTShirt.getAccessibleName());
        listOfProductNamesTest.add(itemBikeLight.getAccessibleName());
        listOfProductNamesTest.add(itemBackpack.getAccessibleName());

        for (int i = 0; i < listOfProductNamesTest.size(); i++) {
            assertThat(listOfProductNamesTest.get(i), equalTo(listOfProductNames.get(i)));
        }
        return this;
    }

    public InventoryPage checkAZSorting() {
        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductNamesTest = new ArrayList<>();
        listOfProductNamesTest.add(itemBackpack.getAccessibleName());
        listOfProductNamesTest.add(itemBikeLight.getAccessibleName());
        listOfProductNamesTest.add(itemBoltTShirt.getAccessibleName());


        for (int i = 0; i < listOfProductNamesTest.size(); i++) {
            assertThat(listOfProductNamesTest.get(i), equalTo(listOfProductNames.get(i)));
        }
        return this;
    }

    public InventoryPage checkToHighSorting() {
        List<String> listOfProductPrices = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductPricesTest = new ArrayList<>();
        listOfProductPrices.add(itemBackpack.getAccessibleName());
        listOfProductPrices.add(itemBikeLight.getAccessibleName());
        listOfProductPrices.add(itemBoltTShirt.getAccessibleName());


        for (int i = 0; i < listOfProductPricesTest.size(); i++) {
            assertThat(listOfProductPricesTest.get(i), equalTo(listOfProductPrices.get(i)));
        }
        return this;
    }

    public InventoryPage checkToLowSorting() {
        List<String> listOfProductPrices = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductPricesTest = new ArrayList<>();
        listOfProductPrices.add(itemBackpack.getAccessibleName());
        listOfProductPrices.add(itemBikeLight.getAccessibleName());
        listOfProductPrices.add(itemBoltTShirt.getAccessibleName());

        for (int i = 0; i < listOfProductPricesTest.size(); i++) {
            assertThat(listOfProductPricesTest.get(i), equalTo(listOfProductPrices.get(i)));
        }
        return this;
    }

}










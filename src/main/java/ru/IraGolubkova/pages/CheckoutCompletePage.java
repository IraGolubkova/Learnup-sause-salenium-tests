package ru.IraGolubkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutCompletePage extends BaseAuthorizedPage {

    @FindBy(className = "complete-header")
    WebElement CheckTheTextOnThePage;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage checkCompletePageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        return this;
    }

    public CheckoutCompletePage CheckTheTextOnThePage() {
        assertThat(CheckTheTextOnThePage.getText(), equalTo("THANK YOU FOR YOUR ORDER"));
        return this;
    }

}

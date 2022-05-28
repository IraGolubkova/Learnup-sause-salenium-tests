package ru.IraGolubkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.github.javafaker.Faker;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepOnePage extends BaseAuthorizedPage {
    Faker faker = new Faker();

    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(id = "cancel")
    WebElement cancelButton;

    public StepOnePage(WebDriver driver) {
        super(driver);
    }

    public StepOnePage checkStepOnePageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        return this;
    }

    public StepOnePage enterFirstName() {
        firstName.click();
        firstName.sendKeys(faker.name().fullName());
        return this;
    }

    public StepOnePage enterLastName() {
        lastName.click();
        lastName.sendKeys(faker.name().lastName());
        return this;
    }

    public StepOnePage enterPostalCode() {
        postalCode.click();
        postalCode.sendKeys(faker.code().toString());
        return this;
    }

    public StepOnePage clickToContinueButton() {
        continueButton.click();
        return new StepOnePage(driver);
    }

    public StepOnePage checkFieldFirstName() {
        assertThat(existsElement(), not(equalTo(0)));
        return this;
    }


    public StepOnePage checkFieldLastName() {
        assertThat(existsElement(), not(equalTo(0)));
        return this;
    }


    public StepOnePage checkFieldPostalCode() {
        assertThat(existsElement(), not(equalTo(0)));
        return this;
    }


    public StepOnePage checkCancelButton() {
        assertThat(existsElement(), not(equalTo(0)));
        return this;
    }

    public StepOnePage checkLabelCancelButton() {
        assertThat(cancelButton.getText(), equalTo("CANCEL"));
        return this;
    }

    public StepOnePage checkContinueButton() {
        assertThat(existsElement(), not(equalTo(0)));
        return this;
    }

}



package ru.IraGolubkova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepTwoPage extends BaseAuthorizedPage {

    @FindBy(className = "checkout_summary_container")
    private WebElement summaryInformation;
    @FindBy(id = "finish")
    private WebElement finishButton;


    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    public StepTwoPage checkStepTwoPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        return this;
    }

    public StepTwoPage checkStepTwoPageInformation() {
        assertThat(driver.findElements(By.cssSelector("#checkout_summary_container")).size(), not(equalTo(0)));
        return this;
    }

    public StepTwoPage clickToStepTwoPageFinishButton() {
        finishButton.click();
        return new StepTwoPage(driver);
    }

}



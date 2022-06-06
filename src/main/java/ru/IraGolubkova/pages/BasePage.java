package ru.IraGolubkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        this.driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30))
                .implicitlyWait(Duration.ofSeconds(4));

        initElements(this.driver, this);
    }

    public boolean existsElement(WebElement locator) {
        try {
            WebElement locator1 = locator;
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}

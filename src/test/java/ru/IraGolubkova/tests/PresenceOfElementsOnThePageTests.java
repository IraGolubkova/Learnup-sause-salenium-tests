package ru.IraGolubkova.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class PresenceOfElementsOnThePageTests extends AuthorisationTests {
    static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);

        // изменять размеры окна - на максимум
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void PresenceOfElementsPositiveTest ()  {
        // ввести логин
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // ввести пароль
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //нажать на кнопку логин
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        // проверка
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        //нажать на кнопку "добавить товар в корзину"
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        //нажать на кнопку корзина
        driver.findElement(By.cssSelector("[class='shopping_cart_link']")).click();
        // проверка
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        //нажать на кнопку Checkout
        driver.findElement(By.name("checkout")).click();
        // проверка
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));

        //окно для ввода имени
        driver.findElement(By.cssSelector("[data-test*=firstName]")).click();
        //окно для ввода фамилии
        driver.findElement(By.cssSelector("[data-test*=lastName]")).click();
         //окно для ввода индекса
        driver.findElement(By.cssSelector("[data-test*=postalCode]")).click();
        //Кнопка Продолжить
        driver.findElement(By.cssSelector("[data-test*=continue]")).click();
        //кнопка отмена
        driver.findElement(By.cssSelector("[data-test*=cancel]")).click();
        //кнопка бокового меню
        driver.findElement(By.id("react-burger-menu-btn")).click();
        //кнопка бокового меню "ALL ITEMS"
        assertThat(driver.findElements(By.cssSelector("#inventory_sidebar_link")).size(), not(equalTo(0)));
        //кнопка бокового меню "About"
        assertThat(driver.findElements(By.cssSelector("#about_sidebar_link")).size(), not(equalTo(0)));
        //кнопка бокового меню "Logout"
        assertThat(driver.findElements(By.cssSelector("#logout_sidebar_link")).size(), not(equalTo(0)));
        //кнопка бокового меню "Reset"
        driver.findElement(By.id("reset_sidebar_link")).click();
        //кнопка бокового меню "крестик"
        driver.findElement(By.id("react-burger-cross-btn")).click();
        //проверка подвала
        //кнопка перехода в твитер в
        driver.findElement(By.cssSelector("[class*=social_twitter]")).click();
        //кнопка перехода фейсбук
        driver.findElement(By.cssSelector("[class*=social_facebook]")).click();
        //кнапока перехода в линкен
        driver.findElement(By.cssSelector("[class*=social_linkedin]")).click();
        //информация внизу с странице
        driver.findElement(By.cssSelector("[class*=footer_copy]")).click();
        //рисунок робота
        driver.findElement(By.cssSelector("[class*=footer_robot]")).click();
        assertThat(driver.findElements(By.cssSelector("#react-burger-menu-btn")).size(), not(equalTo(0)));

    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

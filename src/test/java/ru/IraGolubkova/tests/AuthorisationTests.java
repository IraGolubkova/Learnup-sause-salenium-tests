package ru.IraGolubkova.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorisationTests {
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
    void authorisationPositiveTest()  {
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
        // Ввод данных
        //Оформление заказа
        // введите имя
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("first-name")).sendKeys("Sveta");
        // введите фамилию
        driver.findElement(By.id("last-name")).click();
        driver.findElement(By.id("last-name")).sendKeys("Ivanova");
        //введите индекс
        driver.findElement(By.id("postal-code")).click();
        driver.findElement(By.id("postal-code")).sendKeys("159753");
        // нажать на кнопку Continue
        driver.findElement(By.cssSelector("[data-test='continue']")).click();
        // проверки
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        //нажать на кнопку Finish
        driver.findElement(By.name("finish")).click();
        // проверка
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));

    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

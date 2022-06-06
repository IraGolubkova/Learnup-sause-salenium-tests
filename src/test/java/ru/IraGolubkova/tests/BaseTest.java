package ru.IraGolubkova.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static ru.IraGolubkova.ScreenshotMaker.makeScreenshotOnFailure;

public abstract class BaseTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    public static Properties properties = new Properties();
    public static WebDriver driver;
    @Getter
    static String baseUrl;
    @Getter
    static String username;
    @Getter
    static String password;
    @Getter
    static String notExistentUsername;
    @Getter
    static String lockedOutUsername;
    @Getter
    static String lockedOutPassword;
    @Getter
    static String problemUsername;
    @Getter
    static String problemPassword;

    @BeforeAll
    static void beforeAllTests() throws IOException {
        driver = WebDriverManager.chromedriver().create();
        properties.load(new FileInputStream(PATH_TO_PROPERTIES));
        baseUrl = properties.getProperty("base.url");
        username = properties.getProperty("standard.username");
        password = properties.getProperty("standard.password");
        lockedOutUsername = properties.getProperty("locked-out.username");
        lockedOutPassword = properties.getProperty("locked-out.password");
        problemUsername = properties.getProperty("problem.username");
        problemPassword = properties.getProperty("problem.password");
        notExistentUsername = properties.getProperty("not-existent.username");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);

        // изменять размеры окна - на максимум
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(baseUrl);

    }

    @AfterEach
    void afterEach() throws IOException {
        Allure.addAttachment("Page screenshot", new FileInputStream(makeScreenshotOnFailure(driver)));
        driver.manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);

    }
    @AfterAll
    static void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}


package ru.IraGolubkova;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserListener implements TestWatcher {

    @Override
    public void testSuccessful(final ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
    }
    WebDriver driver = new ChromeDriver();
    @Attachment(value = "{testName} - page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

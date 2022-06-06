package ru.IraGolubkova;

import io.qameta.allure.Attachment;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class ScreenshotMaker {
    @Attachment(value = "Screenshot", type = "image/png")
    public static File makeScreenshotOnFailure(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    }
}


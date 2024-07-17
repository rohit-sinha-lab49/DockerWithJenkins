package com.project.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        // Get current timestamp
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = now.format(formatter);

        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as File
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination path with random number appended
        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            // Copy the screenshot to the desired location
            FileUtils.copyFile(source, new File(destination));
            System.out.println("Screenshot captured: " + destination);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }

        return destination;
    }
}


package com.project.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver initializeDriver(String browserName) {
        if (driver == null) {

            // Initialize new WebDriver based on browserName
            switch (browserName.toLowerCase ()) {
                case "chrome":
                    driver = new ChromeDriver ();
                    break;
                case "firefox":
                    driver = new FirefoxDriver ();
                    break;
                case "edge":
                    driver = new EdgeDriver ();
                    break;
                default:
                    throw new IllegalArgumentException ("Unsupported browser: " + browserName);
            }
        }

        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


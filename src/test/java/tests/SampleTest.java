package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.project.base.WebDriverSingleton;
import com.project.pages.LoginPage;
import com.project.utils.ConfigReader;
import com.project.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

import com.project.utils.TestListener;

@Listeners (TestListener.class)
public class SampleTest {
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        // Get WebDriver instance from Singleton
        this.driver = WebDriverSingleton.initializeDriver (browser);
        driver.manage ().window ().maximize ();
    }

    @Test
    public void sampleTest() {
        Properties properties1 = ConfigReader.readPropertiesFile("config.properties");
        driver.get(properties1.getProperty("baseUrl"));

        // Initialize LoginPage and perform login
        LoginPage loginPage = new LoginPage(driver);
        String username = properties1.getProperty("username");
        String password = properties1.getProperty("password");
        loginPage.login(username, password);

        // Add assertions and test logic here
        Properties properties2 = ConfigReader.readPropertiesFile("testdata.properties");
        String actualTitle = driver.getTitle();
        System.out.println(driver.getTitle ());
        Assert.assertEquals (properties2.getProperty("expectedTitle"),actualTitle);
    }

    @AfterClass
    public void tearDown() {
        // Clean up
        WebDriverSingleton.quitDriver();
    }
}


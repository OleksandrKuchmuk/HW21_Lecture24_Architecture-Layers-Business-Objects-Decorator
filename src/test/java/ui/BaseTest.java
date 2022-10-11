package ui;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public void setDriver() {
        DriverManager.createDriver();
        driver = DriverManager.getDriver();
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}
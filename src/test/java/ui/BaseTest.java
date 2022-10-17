package ui;

import BisnesObjects.AllLaptopPageBO;
import BisnesObjects.BasketPageBO;
import BisnesObjects.FirstLaptopHPPageBO;
import BisnesObjects.RozetkaMainPageBO;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;
    RozetkaMainPageBO rozetkaMainPageBO;
    AllLaptopPageBO allLaptopPageBO;
    FirstLaptopHPPageBO firstLaptopHPPageBO;
    BasketPageBO basketPageBO;

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
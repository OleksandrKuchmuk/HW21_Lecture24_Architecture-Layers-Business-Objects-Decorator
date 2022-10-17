package ui;

import BisnesObjects.AllLaptopPageBO;
import BisnesObjects.BasketPageBO;
import BisnesObjects.FirstLaptopHPPageBO;
import BisnesObjects.RozetkaMainPageBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.PropertyReader;

public class RozetkaTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(RozetkaTest.class);

    @Test
    public void hpAddToBasketAndCheckPriceTest() throws InterruptedException {
        LOGGER.info("Start Test");
        driver.get(PropertyReader.getValue("url"));

        rozetkaMainPageBO = new RozetkaMainPageBO();
        rozetkaMainPageBO.clickOnSearchBarAndEnterQueryAndPressSearchButton("Laptop");


        allLaptopPageBO = new AllLaptopPageBO();
        allLaptopPageBO.chooseSellerRozetkaAndBrandHP();
        allLaptopPageBO.selectSortingFromHighToLowPriseInDropDownMenu();
        allLaptopPageBO.chooseFirstHPLaptopOnPage();

        firstLaptopHPPageBO = new FirstLaptopHPPageBO();
        firstLaptopHPPageBO.clickOnBuyButtonAndClickToOrderButtonNewWindow();

        basketPageBO = new BasketPageBO();

        Assert.assertEquals(basketPageBO.getCountProductInBasket(), 1);
        Assert.assertTrue(basketPageBO.getTotalPriceOfProductsInBasket() < 200000);

    }
}
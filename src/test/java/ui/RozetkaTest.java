package ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllLaptopPage;
import pages.BasketPage;
import pages.FirstLaptopHPPage;
import pages.RozetkaMainPage;
import util.PropertyReader;

public class RozetkaTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(RozetkaTest.class);

    @Test
    public void hpAddToBasketAndCheckPriceTest() throws InterruptedException {
        LOGGER.info("Start Test");

        driver.get(PropertyReader.getValue("url"));
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage();
        rozetkaMainPage
                .clickOnSearchBar()
                .clearSearchBar()
                .inputQueryToSearchBar("laptop")
                .pushSearchButton();

        AllLaptopPage allLaptopPage = new AllLaptopPage();
        Thread.sleep(2500);
        allLaptopPage.chooseSellerRozetka();
        Thread.sleep(2000);
        allLaptopPage.chooseCheckBoxHP();
        allLaptopPage.clickOnSortingDropDownMenu();
        allLaptopPage.selectFromHighToLowPriceInSortingDropDownMenu();
        Thread.sleep(1000);
        allLaptopPage.chooseFirstProduct();

        FirstLaptopHPPage firstLaptopHPPage = new FirstLaptopHPPage();
        firstLaptopHPPage.clickOnBuyButton();
        Thread.sleep(2000);
        firstLaptopHPPage.clickOnToOrderButtonInAlertWindow();

        BasketPage basketPage = new BasketPage();
        String countProductsInBasket = basketPage.getCountProductsInBasket();
        Integer totalPriceOfProductsInBasket = basketPage.getTotalPriceOfProductsInBasket();
        String expectedResultCountProductsInBasket = "1 товар на суму";
        Assert.assertEquals(countProductsInBasket, expectedResultCountProductsInBasket);
        Assert.assertTrue(totalPriceOfProductsInBasket < 200000);
    }
}
package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(BasketPage.class);

    @FindBy(xpath = "//dt[@class='checkout-total__label' and contains(text(), 'товар')]")
    private WebElement countProductsInBasket;

    @FindBy(xpath = "//dd[@class='checkout-total__value checkout-total__value_size_large']")
    private WebElement totalPriseIfProductsInBasket;

    public String getCountProductsInBasket() {
        LOGGER.info("");
        return countProductsInBasket.getText();
    }

    public int getTotalPriceOfProductsInBasket() {
        LOGGER.info("Getting total price from basket");
        return takeIntFromString(totalPriseIfProductsInBasket.getText());
    }

    private int takeIntFromString(String str) {
        LOGGER.info("Method to take integer number from string");
        String str1 = str.replaceAll("\\s", "").replaceAll(".$", "");
        return Integer.parseInt(str1);
    }
}
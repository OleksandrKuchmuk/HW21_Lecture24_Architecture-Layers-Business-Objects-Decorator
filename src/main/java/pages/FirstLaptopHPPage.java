package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstLaptopHPPage extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(FirstLaptopHPPage.class);

    @FindBy(xpath = "//span[@class='buy-button__label ng-star-inserted']")
    private WebElement buyButton;

    @FindBy(xpath = "//a[@data-testid='cart-receipt-submit-order']")
    private WebElement toOrderButtonOnAlertWindow;

    public FirstLaptopHPPage clickOnBuyButton(){
        LOGGER.info("Clicking on 'Buy' button");
        buyButton.click();
        return this;
    }

    public FirstLaptopHPPage clickOnToOrderButtonInAlertWindow(){
        LOGGER.info("Clicking on 'To order' button");
        toOrderButtonOnAlertWindow.click();
        return this;
    }
}
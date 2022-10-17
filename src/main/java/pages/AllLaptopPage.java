package pages;

import elements.CheckBox;
import elements.DropDownMenu;
import elements.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class AllLaptopPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(AllLaptopPage.class);


    @FindBy(xpath = "//select")
    private DropDownMenu sortingDropDownMenu;

    @FindBy(xpath = "//select/option[@value='2: expensive']")
    private DropDownMenu selectFromHighToLowPriceInSortingDropDownMenu;

    @FindBy(xpath = "//a[@data-id='Rozetka']")
    private CheckBox sellerRozetkaCheckBox;

    @FindBy(xpath = "//a[@class='checkbox-filter__link' and @ data-id='HP']")
    private CheckBox checkBoxHP;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted' and @title='Ноутбук HP ZBook Studio G8 (46N54AV_V1) Turbo Silver']")
    private Product firstLaptopOnPageHp;


    public AllLaptopPage clickOnSortingDropDownMenu() {
        LOGGER.info("Click on sorting drop-down menu");
        sortingDropDownMenu.click();
        return this;
    }

    public AllLaptopPage selectFromHighToLowPriceInSortingDropDownMenu() {
        LOGGER.info("Select 'From Higher to Lower Price' in sorting drop-down menu");
        selectFromHighToLowPriceInSortingDropDownMenu.click();
        return this;
    }

    public AllLaptopPage chooseSellerRozetka() {
        LOGGER.info("Choose seller 'Rozetka' in left side sorting menu");
        sellerRozetkaCheckBox.click();
        return this;
    }

    public AllLaptopPage chooseCheckBoxHP() {
        LOGGER.info("Choose brand 'HP' in left side sorting menu");
        checkBoxHP.click();
        return this;
    }

    public AllLaptopPage chooseFirstHPLaptop() {
        LOGGER.info("Choose first laptop on page after sorting");
        firstLaptopOnPageHp.click();
        return this;
    }
}
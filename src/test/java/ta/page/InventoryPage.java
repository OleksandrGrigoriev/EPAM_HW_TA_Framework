package ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(css = ".btn_inventory")
    private List<WebElement> itemsOnPage;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> itemsPrices;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    public static double orderPrice = 0;

    protected InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    protected InventoryPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Inventory page opened");
        return this;
    }

    public InventoryPage addItemsToCart(int itemsInCart) {
        for (int i = 0; i < itemsInCart; i++) {
            itemsOnPage.get(i).click();
            orderPrice += Double.parseDouble(itemsPrices.get(i).getText().substring(1));
        }
        logger.info(itemsInCart + " " + "items were added to cart");
        return this;
    }

    public ShoppingCartPage goToShoppingCart() {
        cartButton.click();
        return new ShoppingCartPage(driver);
    }
}

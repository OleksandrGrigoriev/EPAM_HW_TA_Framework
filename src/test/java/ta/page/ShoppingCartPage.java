package ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ta.util.Decorator;
import ta.util.LogDecorator;

public class ShoppingCartPage extends AbstractPage {

    private static final String PAGE_URL = "https://www.saucedemo.com/cart.html";
    private final Logger logger = LogManager.getRootLogger();
    private final Decorator logDecorator = new LogDecorator(logger);

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    protected ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ShoppingCartPage openPage() {
        driver.navigate().to(PAGE_URL);
        logDecorator.decorate("Shopping cart page opened");
        return this;
    }

    public CheckoutStepOnePage goToCheckoutStepOne() {
        checkoutButton.click();
        return new CheckoutStepOnePage(driver).openPage();
    }
}

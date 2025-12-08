package ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AbstractPage {

    private static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    protected ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    protected ShoppingCartPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CheckoutStepOnePage goToCheckoutStepOne() {
        checkoutButton.click();
        return new CheckoutStepOnePage(driver);
    }
}

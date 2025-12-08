package ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutStepTwoPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(xpath = "//*[@class='summary_subtotal_label']")
    private WebElement finalPrice;

    protected CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    protected CheckoutStepTwoPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Checkout overview page opened");
        return this;
    }

    public double getFinalPrice() {
        return Double.parseDouble(finalPrice.getText().substring(13));
    }
}

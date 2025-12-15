package ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ta.util.LogDecorator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CheckoutStepOnePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private LogDecorator logDecorator = new LogDecorator(logger);
    private static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(name = "firstName")
    private WebElement nameForm;

    @FindBy(css = "#last-name")
    private WebElement lastNameForm;

    @FindBy(css = "#postal-code")
    private WebElement postCodeForm;

    @FindBy(css = "#continue")
    private WebElement continueButton;

    protected CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    protected CheckoutStepOnePage openPage() {
        driver.navigate().to(PAGE_URL);
        logDecorator.decorate("Information checkout page opened");
        return this;
    }

    public CheckoutStepTwoPage goToCheckoutStepTwo() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/checkout.properties");
        prop.load(fis);
        nameForm.sendKeys(prop.getProperty("name"));
        lastNameForm.sendKeys(prop.getProperty("lastname"));
        postCodeForm.sendKeys(prop.getProperty("postcode"));
        fis.close();
        logDecorator.decorate("Information checkout performed");
        continueButton.click();
        return new CheckoutStepTwoPage(driver).openPage();
    }
}

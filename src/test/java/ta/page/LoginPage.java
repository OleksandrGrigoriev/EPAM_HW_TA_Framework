package ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ta.model.User;
import ta.util.Decorator;
import ta.util.LogDecorator;

public class LoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private Decorator logDecorator = new LogDecorator(logger);
    private static final String PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(css = "#user-name")
    private WebElement inputLogin;

    @FindBy(css = "#password")
    private WebElement inputPassword;

    @FindBy(css = "#login-button")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openPage() {
        driver.navigate().to(PAGE_URL);
        logDecorator.decorate("Login page opened");
        return this;
    }

    public InventoryPage login(User user) {
        inputLogin.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        buttonLogin.click();
        logDecorator.decorate("Login performed");
        return new InventoryPage(driver).openPage();
    }
}

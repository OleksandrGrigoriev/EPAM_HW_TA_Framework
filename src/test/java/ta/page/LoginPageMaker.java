package ta.page;

import org.openqa.selenium.WebDriver;

public class LoginPageMaker implements PageMaker {
    WebDriver driver;

    public LoginPageMaker(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AbstractPage createPage() {
        return new LoginPage(driver);
    }
}

package ta.page;

import org.openqa.selenium.WebDriver;
import ta.model.User;

public abstract class AbstractPage {
	protected WebDriver driver;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

	public abstract AbstractPage openPage();
}

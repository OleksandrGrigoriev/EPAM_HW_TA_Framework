package ta.page;

import org.openqa.selenium.WebDriver;


public class Factory {
    public static PageMaker getPageMakerByName(String name, WebDriver driver) {
        if(name.equalsIgnoreCase("login")) {
            return new LoginPageMaker(driver);
        }
        return null;
    }
}

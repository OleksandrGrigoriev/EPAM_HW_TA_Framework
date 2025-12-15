package ta.test;

import org.testng.annotations.Test;
import ta.model.User;
import ta.page.*;
import ta.service.UserCreator;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckFinalPriceTest extends CommonTestConditions {
    private final int ITEMS_IN_CART = 4;

    @Test
    public void checkFinalPriceTest() throws IOException {
        User testUser = UserCreator.withCredentialsFromProperty();

        PageMaker pageMaker = Factory.getPageMakerByName("login", driver);
        LoginPage loginPage = (LoginPage)pageMaker.createPage();

        double finalPrice = loginPage
                                .openPage()
                                .login(testUser)
                                .addItemsToCart(ITEMS_IN_CART)
                                .goToShoppingCart()
                                .goToCheckoutStepOne()
                                .goToCheckoutStepTwo()
                                .getFinalPrice();
        assertThat(finalPrice, is(equalTo(InventoryPage.orderPrice)));
    }
}

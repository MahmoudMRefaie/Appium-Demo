package android;

import base.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemDetails_Test extends AndroidBaseTest {

    private final String productName = "Sauce Labs Fleece Jacket";

    @Test
    public void verifyItemPrice() {

        String itemPrice = home.getItemPrice(productName);
        home.openItem(productName);
        Assert.assertEquals(productDetails.getItemPrice(), itemPrice);
        Assert.assertEquals(productDetails.getItemName(), productName);     //Assert on item name
    }

    @Test
    public void checkoutItem() {

        home.openItem(productName);
        productDetails.addItemToCart();
    }

    @BeforeMethod
    public void beforeMethod() {
        home.openMenu().openCatalog();
    }

}

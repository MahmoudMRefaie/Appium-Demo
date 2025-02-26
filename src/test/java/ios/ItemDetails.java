package ios;

import base.IOSBaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemDetails extends IOSBaseTest {

    String productName = "Sauce Labs Fleece Jacket";
    @Test
    public void checkItemDetails(){
        home.openItem(productName);
    }

    @Test(dependsOnMethods = "checkItemDetails")
    public void addItemToCart() {
        home.openItem(productName);
        home.addItemToCart();
    }

    @BeforeMethod
    public void beforeMethod() {
        home.openCatalog();
    }
}

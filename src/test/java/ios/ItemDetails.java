package ios;

import base.IOSBaseTest;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.ios.Home;

public class ItemDetails extends IOSBaseTest {

    Home home;

    @Test
    public void checkItemDetails(){
        home.openItem("Sauce Labs Fleece Jacket");
    }

    @Test(dependsOnMethods = "checkItemDetails")
    public void addItemToCart() {
        home.addItemToCart();
    }

    @BeforeMethod
    public void beforeMethod() {
        home.openCatalog();
    }
}

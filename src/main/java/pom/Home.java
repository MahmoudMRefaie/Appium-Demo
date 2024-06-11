package pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class Home {

    private final AppiumDriver driver;
    private By addToCartBtn;
    private By item(String itemName) { return AppiumBy.name(itemName); }

    public Home(BaseOptions options) {
        try {
            this.driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), options);     // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        addToCartBtn = By.name("Add To Cart button");
    }

    public void openItem(String itemName) {
        System.out.println("Open item: " + itemName);
        driver.findElement(item(itemName)).click();
    }

    public void addItemToCart() {
        System.out.println("Add the item to cart");
        driver.findElement(addToCartBtn).click();
    }
}

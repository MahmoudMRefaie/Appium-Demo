package pom.android;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetails extends BasePage {

    private By productName;
    private By productPrice;
    private By addToCartBtn;
    private By productDescription;
    private final WebDriverWait wait;

    private WebElement productItem(String itemName) {
        return driver.findElement(AppiumBy.xpath(String.format("//*[@text='%s']", itemName)))
                .findElement(AppiumBy.xpath("./ancestor::*[@content-desc='store item']"));
    }

    public ProductDetails(BaseOptions options) {
        super(options);

        //productName = new ByChained(containerHeader, AppiumBy.xpath("//*[@text]"));
        productName = AppiumBy.xpath("//*[@content-desc='container header'] //*[@text]");
        productPrice = AppiumBy.accessibilityId("product price");
        addToCartBtn = AppiumBy.accessibilityId("Add To Cart button");
        productDescription = AppiumBy.accessibilityId("product description");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getItemPrice() {
        System.out.println("Get item price");

        wait.until(ExpectedConditions.elementToBeClickable(productPrice));
        return driver.findElement(productPrice).getText().replace("$", "");
    }

    public String getItemName() {
        System.out.println("Get item name");

        wait.until(ExpectedConditions.elementToBeClickable(productName));
        return driver.findElement(productName).getText();
    }

    public String getItemDescription() {
        System.out.println("Get item name");

        wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription));
        return driver.findElement(productDescription).getText();
    }

    public ProductDetails addItemToCart() {
        System.out.println("Add the item to cart");

        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        driver.findElement(addToCartBtn).click();

        return this;
    }


}

package pom.android;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home extends BasePage {

    private final By menuBtn;
    private final By cartBadge;
    private final By catalogMenuItem;
    private final By menuItem_login;
    private final By menuItem_logout;
    private final WebDriverWait wait;

    private WebElement getProductItemElement(String itemName) {
        By itemLocator = AppiumBy.xpath(String.format("//*[@text='%s']/ancestor::*[@content-desc='store item']", itemName));        //parent content-desc=store item for item that its text is %s
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));

        return driver.findElement(itemLocator);
    }

    public Home(BaseOptions options) {
        super(options);

        menuBtn = AppiumBy.accessibilityId("open menu");
        catalogMenuItem = AppiumBy.accessibilityId("menu item catalog");
        menuItem_login = By.xpath("//*[@content-desc='menu item log in']");
        menuItem_logout = AppiumBy.accessibilityId("menu item log out");
        cartBadge = AppiumBy.accessibilityId("cart badge");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ProductDetails openItem(String itemName) {
        System.out.println("Open item: " + itemName);

        getProductItemElement(itemName).click();

        return new ProductDetails(options);
    }

    public String getItemPrice(String itemName) {
        System.out.println("Get price for item: " + itemName);

        String price = getProductItemElement(itemName).findElement(AppiumBy.xpath(".//*[@content-desc='store item price']")).getText();
        return price.replace("$", "");
    }

    public Home openMenu() {
        System.out.println("Open Menu");
        driver.findElement(menuBtn).click();

        return this;
    }

    public Login openLoginMenuItem(){
        System.out.println("Open Login");
        wait.until(ExpectedConditions.elementToBeClickable(menuItem_login));

        driver.findElement(menuItem_login).click();

        return new Login(options);
    }

    public void openCart() {
        System.out.println("Open Cart page");
        driver.findElement(cartBadge).click();
    }

    public Home openCatalog() {
        System.out.println("Open Catalog");

        wait.until(ExpectedConditions.elementToBeClickable(catalogMenuItem));
        driver.findElement(catalogMenuItem).click();

        return this;
    }

    public Login clickLogout() {
        System.out.println("Click Logout in menu item");

        wait.until(ExpectedConditions.elementToBeClickable(menuItem_logout));
        driver.findElement(menuItem_logout).click();

        return new Login(options);
    }
}

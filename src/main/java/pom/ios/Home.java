package pom.ios;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.By;

public class Home extends BasePage {

    private final By addToCartBtn;
    private final By menuBtn;
    private final By catalogBtn;
    private final By menuItem_login;
    private final By menuItem_logout;
    private final By username_textBox;
    private final By password_textBox;
    private final By loginBtn;
    private final By loginError;
    private final By confirmLogout;

    private By item(String itemName) { return AppiumBy.name(itemName); }

    public Home(BaseOptions options) {
        super(options);

        addToCartBtn = By.name("Add To Cart button");
        menuBtn = By.name("tab bar option menu");
        menuItem_login = By.name("menu item log in");
        username_textBox = By.name("Username input field");
        password_textBox = By.name("Password input field");
        loginBtn = By.name("Login button");
        loginError = By.name("generic-error-message");
        catalogBtn = By.name("tab bar option catalog");
        menuItem_logout = By.name("menu item log out");
        confirmLogout = By.name("Log Out");
    }

    public void openItem(String itemName) {
        System.out.println("Open item: " + itemName);
        driver.findElement(item(itemName)).click();
    }

    public void addItemToCart() {
        System.out.println("Add the item to cart");
        driver.findElement(addToCartBtn).click();
    }

    public void openMenu() {
        System.out.println("Open Menu");
        driver.findElement(menuBtn).click();
    }

    public void openLoginMenuItem(){
        System.out.println("Open Login");
        driver.findElement(menuItem_login).click();
    }

    public void login(String username, String password) {
        System.out.println("Login with user [" + username + "] and password [" + password + "]");
        driver.findElement(username_textBox).clear();
        driver.findElement(username_textBox).sendKeys(username);
        driver.findElement(password_textBox).clear();
        driver.findElement(password_textBox).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public String getLoginErrorMessage(){
        return driver.findElement(loginError).getText();
    }

    public void openCatalog() {
        System.out.println("Open Catalog Tab");
        driver.findElement(catalogBtn).click();
    }

    public void logout() throws InterruptedException {
        System.out.println("Logout");
        driver.findElement(menuItem_logout).click();
        Thread.sleep(3000);
        driver.findElement(confirmLogout).click();
    }

}

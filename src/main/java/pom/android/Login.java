package pom.android;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends BasePage {

    private final By username_textBox;
    private final By password_textBox;
    private final By loginBtn;
    private final By loginError;
    private final By confirmLogout;
    private final By loggedOutAlertOkBtn;
    private final WebDriverWait wait;

    public Login(BaseOptions options) {
        super(options);

        username_textBox = AppiumBy.accessibilityId("Username input field");
        password_textBox = AppiumBy.accessibilityId("Password input field");
        loginBtn = AppiumBy.accessibilityId("Login button");
        loginError = AppiumBy.xpath("//*[@content-desc='generic-error-message'] //*[@text]");
        confirmLogout = AppiumBy.xpath("//*[@text='LOG OUT']");
        loggedOutAlertOkBtn = new ByAll(AppiumBy.xpath("//*[@text='OK']"), By.id("username-responsive-field"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public Home login(String username, String password) {
        System.out.println("Login with user [" + username + "] and password [" + password + "]");
        wait.until(ExpectedConditions.elementToBeClickable(username_textBox));

        driver.findElement(username_textBox).clear();
        driver.findElement(username_textBox).sendKeys(username);
        driver.findElement(password_textBox).clear();
        driver.findElement(password_textBox).sendKeys(password);
        driver.findElement(loginBtn).click();

        return new Home(options);
    }

    public String getLoginErrorMessage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginError));

        return driver.findElement(loginError).getText();
    }

    public void logout() {
        System.out.println("Logout");

        wait.until(ExpectedConditions.elementToBeClickable(confirmLogout));
        driver.findElement(confirmLogout).click();

        wait.until(ExpectedConditions.elementToBeClickable(loggedOutAlertOkBtn));
        driver.findElement(loggedOutAlertOkBtn).click();
    }

}

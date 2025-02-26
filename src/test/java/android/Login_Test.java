package android;

import base.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Test extends AndroidBaseTest {

    @Test(description = "Login with valid credentials")
    public void loginValidUser() {

        home.openMenu().openLoginMenuItem().login("bob@example.com", "10203040");
        home.openMenu().clickLogout().logout();
    }

    @Test(description = "Login with locked user")
    public void loginLockedUser() {
        home.openMenu().openLoginMenuItem().login("alice@example.com", "10203040");

        Assert.assertEquals(login.getLoginErrorMessage(), "Sorry, this user has been locked out.");
        //Provided credentials do not match any user in this service.
    }

    @Test(description = "Login with invalid user")
    public void loginInvalidUser() {
        home.openMenu().openLoginMenuItem().login("invalid_user@example.com", "10203040");

        Assert.assertEquals(login.getLoginErrorMessage(), "Provided credentials do not match any user in this service.");
    }

}

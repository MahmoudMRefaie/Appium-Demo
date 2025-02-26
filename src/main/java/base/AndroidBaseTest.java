package base;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pom.android.Home;
import pom.android.Login;
import pom.android.ProductDetails;

public class AndroidBaseTest {

    //private BasePage basePage;
    protected Login login;
    protected Home home;
    protected ProductDetails productDetails;

    @BeforeClass
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 8 Pro API 30");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        login = new Login(options);
        home = new Home(options);
        productDetails = new ProductDetails(options);

    }

    @AfterClass
    public void tearDown(){
        home.quit();
    }
}

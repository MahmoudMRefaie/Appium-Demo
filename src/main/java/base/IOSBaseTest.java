package base;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pom.android.Login;
import pom.ios.Home;

public class IOSBaseTest {
    protected Home home;

    @BeforeClass
    public void setUp() {
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 15 Pro Max")
                .setApp(System.getProperty("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");

        home = new Home(options);
    }

    @AfterClass
    public void tearDown(){
        home.quit();
    }
}

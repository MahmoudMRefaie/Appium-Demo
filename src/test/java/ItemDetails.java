import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.Home;

public class ItemDetails {

    Home home;

    @Test
    public void checkItemDetails(){
        home.openItem("Sauce Labs Fleece Jacket");
    }

    @Test(dependsOnMethods = "checkItemDetails")
    public void addItemToCart() {
        home.addItemToCart();
    }

    @BeforeClass
    public void setup(){
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 15 Pro Max")
                .setApp(System.getProperty("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");

//        BaseOptions options = new BaseOptions();        //This code is implemented to be applicable to run over android and IOS, otherwise use: https://github.com/appium/java-client#Usage-Examples
//        options.setAutomationName("XCuiTest");
//        options.setPlatformName("IOS");
//        options.setCapability("deviceName", "iPhone 15 Pro Max");
//        options.setCapability("app", System.getProperty("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
        home = new Home(options);
    }

    @AfterClass
    public void tearDown(){

    }
}

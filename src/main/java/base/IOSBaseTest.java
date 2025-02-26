package base;

import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pom.ios.Home;

public class IOSBaseTest {
    protected Home home;

    @BeforeClass
    public void setUp() {
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 15 Pro Max")
                .setPlatformVersion("17.5")
                .setApp(System.getProperty("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");

        home = new Home(options);
    }

    @AfterClass
    public void tearDown(){
        home.quit();
    }
}

/**
 * *To Run iOS tests*
 * ls ~/.appium/node_modules/appium-webdriveragent      -> if appium-webdriveragent not exist, install it manually by cloning it:
 *
 * cd ~/.appium/node_modules
 * git clone https://github.com/appium/WebDriverAgent.git
 * cd WebDriverAgent
 * mkdir -p Resources/WebDriverAgent.bundle
 *
 * open ~/.appium/node_modules/WebDriverAgent/WebDriverAgent.xcodeproj
 * Select WebDriverAgentRunner in the Xcode project.
 * Navigate to Signing & Capabilities.
 * Select your Apple developer account.
 *
 * build WebDriverAgentRunner application using one from these two scripts depending on your target device and iOS version
 * xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'platform=iOS Simulator,name=iPhone 15 Pro Max' test
 * xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'platform=iOS Simulator,id=5E23DE24-9BBA-45AA-9FBE-4A8EB8265DCB,OS=17.5' test
 *
 * Then start your application
 *
 */
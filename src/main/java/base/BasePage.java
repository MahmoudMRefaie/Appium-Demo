package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {

    protected static AppiumDriver driver;       //driver is sharable between BasePage instances
    protected BaseOptions options;

    public BasePage(BaseOptions options) {
        this.options = options;

        initDriver(options);
    }

    private void initDriver(BaseOptions options) {

//        try {
//            this.driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), options);     // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }

        if (driver == null || driver.getSessionId() == null) {
            driver = new AppiumDriver(options);
        }

    }

    public void quit() {
        System.out.println("Quite driver");
        driver.quit();
        //driver = null;
    }
}

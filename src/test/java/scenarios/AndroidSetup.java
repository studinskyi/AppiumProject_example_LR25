package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.io.File;
import java.net.URL;




public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("d:\\QA_Hillel\\LR25_mobile\\myAppiumProject\\apps\\");
        //File appDir = new File("/myAppiumProject/apps");
        //File appDir = new File("/SeleniumTests/AppiumLR/apps");
        File app = new File(appDir, "linkedin-4-0-95.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public AndroidDriver getDriver() {
        return driver;
    }

}

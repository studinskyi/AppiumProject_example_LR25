package scenarios;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest_byAndroidUIAutomator extends AndroidSetup {
    private final static String strLoginUser = "DmitrStud_TestMob@mail.ru";
    private final static String strPasswordUser = "TestMob_2016_DmitrStud";

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        //        AndroidSetup androidSetup = new AndroidSetup();
        //        androidSetup.prepareAndroidForAppium();
        //        driver = androidSetup.getDriver();
    }

    //    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void loginTest() {
        String app_package_name = "com.linkedin.android:id/";
        By firstSignIn = By.id(app_package_name + "growth_prereg_fragment_sign_in_button");
        By userEmail = By.id(app_package_name + "growth_login_join_fragment_email_address");
        By userPassword = By.id(app_package_name + "growth_login_join_fragment_password");
        By showButton = By.id(app_package_name + "growth_login_join_show_hide_password");
        By signInButton = By.id(app_package_name + "growth_login_fragment_sign_in");
        By homeAppLauncher = By.id(app_package_name + "home_activity_app_launcher");

        // 2 вариант входа в приложение
        //waitForVisibilityOf(firstSignIn);
        driver.pressKeyCode(AndroidKeyCode.HOME);
        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Apps\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"LinkedIn\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Sign in\")").click();
        driver.findElement(userEmail).sendKeys(strLoginUser);
        driver.findElement(userPassword).sendKeys(strPasswordUser);
        driver.findElement(showButton).click();

        String typedUser = driver.findElement(userEmail).getText();
        Assert.assertEquals(typedUser, strLoginUser);

        String typedPass = driver.findElement(userPassword).getText();
        Assert.assertEquals(typedPass, strPasswordUser);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Sign in\")").click();

        // ожидание открытия рабочего окна аккаунта linkedin
        waitForVisibilityOf(homeAppLauncher);
        Assert.assertNotNull(homeAppLauncher);

    }

    protected void waitForVisibilityOf(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

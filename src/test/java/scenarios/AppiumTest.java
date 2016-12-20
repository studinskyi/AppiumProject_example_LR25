package scenarios;

import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppiumTest extends AndroidSetup {
    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }


    //    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void showTest() {

        String app_package_name = "com.linkedin.android:id/";
        By firstSignIn = By.id(app_package_name + "growth_prereg_fragment_sign_in_button");
        By userEmail = By.id(app_package_name + "growth_login_join_fragment_email_address");
        By userPassword = By.id(app_package_name + "growth_login_join_fragment_password");
        By showButton = By.id(app_package_name + "growth_login_join_show_hide_password");
        By signInButton = By.id(app_package_name + "growth_login_fragment_sign_in");

        // 1- вариант входа в приложение
        waitForVisibilityOf(firstSignIn);

        driver.findElement(firstSignIn).click();
        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys("DmitrStud_TestMob@mail.ru");
        driver.findElement(userPassword).sendKeys("TestMob_2016_DmitrStud");
        driver.findElement(showButton).click();

        String typedPass = driver.findElement(userPassword).getText();
        Assert.assertEquals(typedPass, "TestMob_2016_DmitrStud");

        driver.findElement(signInButton).click();


//        // 2 вариант входа в приложение
//        driver.pressKeyCode(AndroidKeyCode.HOME);
//        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Apps\")").click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"LinkedIn\")").click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Sign in\")").click();
//        driver.findElement(firstSignIn).click();
//        driver.findElement(userEmail).clear();
//        driver.findElement(userEmail).sendKeys("DmitrStud_TestMob@mail.ru");
//        driver.findElement(userPassword).sendKeys("TestMob_2016_DmitrStud");
//        driver.findElement(showButton).click();
//
//        typedPass = driver.findElement(userPassword).getText();
//        Assert.assertEquals(typedPass, "TestMob_2016_DmitrStud");
//
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Sign in\")").click();



    }


    protected void waitForVisibilityOf(By locator) {


        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

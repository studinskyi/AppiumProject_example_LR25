package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest_byId extends AndroidSetup {
    private final static String strLoginUser = "DmitrStud_TestMob@mail.ru";
    private final static String strPasswordUser = "TestMob_2016_DmitrStud";

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        //        AndroidSetup androidSetup = new AndroidSetup();
        //        androidSetup.prepareAndroidForAppium();
        //        driver = androidSetup.getDriver();
    }

    @AfterClass
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

        // 1 - вариант входа в приложение
        waitForVisibilityOf(firstSignIn);

        driver.findElement(firstSignIn).click();
        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys(strLoginUser);
        driver.findElement(userPassword).sendKeys(strPasswordUser);
        driver.findElement(showButton).click();

        String typedUser = driver.findElement(userEmail).getText();
        Assert.assertEquals(typedUser, strLoginUser);

        String typedPass = driver.findElement(userPassword).getText();
        Assert.assertEquals(typedPass, strPasswordUser);

        driver.findElement(signInButton).click();

        // ожидание открытия рабочего окна аккаунта linkedin
        waitForVisibilityOf(homeAppLauncher);
        Assert.assertNotNull(homeAppLauncher);

    }

    //    @Test (dependsOnMethods = "loginTest")
    //    public void sendMessageTest() {
    //
    //        String app_package_name = "com.linkedin.android:id/";
    //        By myContactsButton = By.name("My Network, Tab 2 of 5");
    //        By connection_home_button = By.id(app_package_name + "relationships_connection_home_button");
    //        By contact_ArthurPilyuk = By.name("Arthur Pilyuk");
    //        By message_primary_button = By.id(app_package_name + "profile_view_top_card_primary_button");
    //        By message_text_input_container = By.id(app_package_name + "msglib_keyboard_text_input_container");
    //        By message_send_button = By.id(app_package_name + "msglib_keyboard_send_button");
    //        String textMessage = "Message by Dmitryi Studinskyi for testing mobile applications linkedIn";
    //        By image_message_send = By.name(textMessage);
    //
    //
    //        // вход в список контактов аккаунта linkedin
    //        waitForVisibilityOf(myContactsButton);
    //        Assert.assertNotNull(myContactsButton);
    //        driver.findElement(myContactsButton).click();
    //
    //        // далее вход в список уже подтвержденных связей с людьми Connections
    //        waitForVisibilityOf(connection_home_button);
    //        Assert.assertNotNull(connection_home_button);
    //        driver.findElement(connection_home_button).click();
    //
    //        // вход в аккаунт Arthur Pilyuk
    //        waitForVisibilityOf(contact_ArthurPilyuk);
    //        Assert.assertNotNull(contact_ArthurPilyuk);
    //        driver.findElement(contact_ArthurPilyuk).click();
    //
    //        // подготовка и отсылка сообщения
    //        waitForVisibilityOf(contact_ArthurPilyuk);
    //        Assert.assertNotNull(contact_ArthurPilyuk);
    //        waitForVisibilityOf(message_primary_button);
    //        Assert.assertNotNull(message_primary_button);
    //        driver.findElement(message_primary_button).click();
    //        waitForVisibilityOf(message_text_input_container);
    //        Assert.assertNotNull(message_text_input_container);
    //        driver.findElement(message_text_input_container).click();
    //        driver.findElement(message_text_input_container).clear();
    //        driver.findElement(message_text_input_container).sendKeys(textMessage);
    //        driver.findElement(message_send_button).click();
    //        waitForVisibilityOf(image_message_send);
    //        Assert.assertNotNull(image_message_send);
    //    }

    protected void waitForVisibilityOf(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

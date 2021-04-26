package platform.mobile.miscellaneous;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import platform.utilities.DriverAction;
import platform.utilities.Utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StepDefs {
    Utilities util = new Utilities();
    AndroidDriver<MobileElement>  driver;
    DriverAction driverAction;

    @Given("^Open Decathlon Mobile Applications$")
    public void openDecathlonMobileApplications() throws MalformedURLException {
        String platformName = util.getProperty("platformName");
        String platformVersion = util.getProperty("platformVersion");
        String deviceName = util.getProperty("deviceName");
        String appActivity = util.getProperty("appActivity");
        String appPackage = util.getProperty("appPackage");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("platformVersion",platformVersion);
        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("appActivity",appActivity);
        capabilities.setCapability("appPackage",appPackage);
        driver = new AndroidDriver<MobileElement>(new URL(util.getProperty("domain")), capabilities);
        driverAction = new DriverAction(driver);
    }

    @And("Allow Permissions")
    public void allowPermissions() {
        driverAction.waitForElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"),20).click();
        driverAction.waitForElement(By.id("com.android.packageinstaller:id/permission_allow_button"), 20).click();
        driverAction.waitForElement(By.id("android:id/button2"), 20).click();

    }

    @And("Skip Tour")
    public void skipTour() {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/skip"),20).click();
    }

    @And("Skip Login")
    public void skipLogin() {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/txvSkip"),20).click();
    }

    @And("Skip Navigation Tour")
    public void skipNavigationTour() {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/btnDone"),20).click();
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/btnDone"),20).click();
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/btnDone"),20).click();
    }


    @When("Search For The {string}")
    public void searchForThe(String product) {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/txvSearchProducts"),20).click();
        MobileElement searchField = (MobileElement) driverAction.waitForElement(By.id("com.evamall.evacustomer:id/edtSearch"),20);
        searchField.sendKeys(product);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/txvExploreAll"),20).click();


    }

    @Then("Verify The List")
    public void verifyTheList() {
        boolean isListDisplayed = driverAction.waitForElement(By.id("com.evamall.evacustomer:id/recyclerView"),20).isDisplayed();
        Assert.assertTrue(isListDisplayed);
    }

    @And("Open The Product")
    public void openTheProduct() {
        driverAction.waitForElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"),20).click();
    }

    @And("Add To Bag")
    public void addToBag() {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/txvAddToBag"),20).click();
    }

    @And("Select {string}")
    public void select(String size) {
        driverAction.waitForElement(By.xpath("//android.widget.TextView[contains(@text,'"+size+"')]"),20).click();

    }

    @And("View Cart")
    public void viewCart() {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/txvCart"),20).click();

    }

    @Then("Verify The {string} In Cart")
    public void verifyTheInCart(String expectedProductName) {
        String actualProductName =driverAction.waitForElement(By.id("com.evamall.evacustomer:id/txvProductName"),20).getText();
        Assert.assertEquals(actualProductName,expectedProductName);
    }

    @And("Increase The Items")
    public void increaseTheItems() {
        int i=1;
        while (i<10){
            driverAction.waitForElement(By.id("com.evamall.evacustomer:id/btnPlus"),20).click();
            i++;
        }
    }

    @Then("Verify The {string}")
    public void verifyThe(String expectedPrice) throws InterruptedException {
        Thread.sleep(10000);
        String actualPrice = driverAction.waitForElement(By.id("com.evamall.evacustomer:id/txvCartPrice"),20).getText();
        Assert.assertEquals(actualPrice,expectedPrice);
    }

    @And("Navigate Back To List")
    public void navigateBackToList() {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/imvBackIcon"),20).click();
        driverAction.waitForElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),20).click();
    }

    @And("Open Second Product")
    public void openSecondProduct() {
        driverAction.waitForElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]"),20).click();
    }

    @And("Open Cart")
    public void openCart() {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/cartView"),20).click();
    }

    @And("Remove Product")
    public void removeProduct() {
        driverAction.waitForElement(By.id("com.evamall.evacustomer:id/btnMinus"),20).click();
    }
}



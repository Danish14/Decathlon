package platform.web.orderPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import platform.utilities.DriverAction;
import platform.utilities.DriverFactory;
import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StepDefs {
    WebDriver driver;
    DriverAction driverAction;
    DriverFactory factory = new DriverFactory();
    @Given("^Launch Browser$")
    public void launchBrowser() throws Exception {
        driver = factory.getDriver();
        driverAction = new DriverAction(driver);
        driver.manage().window().maximize();

    }

    @When("Open Decathlon Application")
    public void openDecathlonApplication() {
        driver.get("https://www.decathlon.in");
        driverAction.waitForElement(By.xpath("//*[@id='location-prompt']/div/div[1]"),20).click();
    }

    @And("Search For {string}")
    public void searchFor(String product) {
        WebElement searchField = driver.findElement(By.xpath("//input[@id='search']"));
        searchField.click();
        searchField.sendKeys(product);
        driverAction.waitForElement(By.xpath("//header/div[1]/div[4]/div[1]/div[2]/a[1]"),20).click();
    }

    @And("Open Product")
    public void openProduct() {
        driverAction.waitForElement(By.xpath("//*[@id='__next']/descendant::div[@class='algolia-clicks'][1]"), 20).click();
    }
    @Then("Close Browser")
    public void closeBrowser() {
        driver.quit();
    }

    @And("Select {string} And Add To Cart")
    public void selectAndAddToCart(String productSize) {
        WebElement addToCart = driverAction.waitForElement(By.xpath("//div[@class='product-button']/button"),40);
        driverAction.waitForElement(By.xpath("//div[contains(text(),'Select your size')]"),20).click();
        driverAction.waitForElement(By.xpath("//*[contains(text(),'"+productSize+"')]"),20).click();
        addToCart.click();
    }

    @And("Go To Cart")
    public void goToCart() {
        driverAction.waitForElement(By.xpath("//body/div[@id='__next']/div[3]/div[2]/div[6]/div[1]/div[2]/div[1]/div[3]/button[2]/span[1]"),20).click();
        driverAction.waitForElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"),20);
    }

    @Then("Validate Order {string} and {string} Details")
    public void validateOrderAndDetails(String price, String quantity) {
        String productQuantity = driverAction.waitForElement(By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/input[1]"),20).getAttribute("value");
        String productPrice = driverAction.waitForElement(By.xpath("//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/h4[1]"),20).getText();
        Assert.assertEquals(productPrice,price);
        Assert.assertEquals(productQuantity,quantity);

    }

    @And("Proceed To Checkout And Take ScreenShot")
    public void proceedToCheckoutAndTakeScreenShot() {
        driverAction.waitForElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"),20).click();
        driverAction.waitForElement(By.xpath("//*[@id='deca-login']/div"),20);
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/LoginPage"+timestamp+".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

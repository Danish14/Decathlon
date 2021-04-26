package platform.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverAction {

    WebDriver driver;
    public DriverAction(WebDriver userDriver){
        driver = userDriver;
    }

    public WebElement waitForElement(By by, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}

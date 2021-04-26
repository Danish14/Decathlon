package platform.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    WebDriver driver;
    Utilities util = new Utilities();
    String chromePath = "src/test/resources/drivers/chromedriver.exe";
    String fireFoxPath = "src/test/resources/drivers/geckodriver.exe";

    public WebDriver getDriver() throws Exception {
        String browser = util.getProperty("browser");
        switch(browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",chromePath);
                return driver = new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver",fireFoxPath);
                return driver = new FirefoxDriver();
            default:
                throw new Exception("Please check driver");
        }
    }
}

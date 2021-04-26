package platform.mobile.miscellaneous;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},
        features = {"src/test/java/platform/mobile/miscellaneous/miscellaneous.feature"},
        glue = {"platform.mobile.miscellaneous"}
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
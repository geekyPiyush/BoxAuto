import com.payoneer.cloud.box.commons.drivers.DriverFactory;
import com.payoneer.cloud.box.commons.drivers.DriverManager;
import com.payoneer.cloud.box.commons.factory.DeviceMetricsFactory;
import com.payoneer.cloud.box.commons.factory.EnvironmentFactory;
import com.payoneer.cloud.box.commons.logger.Log;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = {
                "src/test/resources/features/"
        },
        glue={
                "com.payoneer.cloud.box.steps",
                "com.payoneer.cloud.box.commons.hooks"
        },
        plugin = {
                "progress",
                "json:../target/cucumber-report/json/boxui.json",
                "html:../target/cucumber-report/html/boxui",
                "rerun:../target/cucumber-report/rerun/boxui.txt",
                "junit:../target/cucumber-report/xml/boxui.xml",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
        })
public class TestRunner extends AbstractTestNGCucumberTests {

    static{
        DeviceMetricsFactory.loadBrowsers();
        EnvironmentFactory.loadEnvResource();
    }

    @BeforeTest
    @Parameters(value = { "category", "id" })
    public void beforeEachTestNgTest(String category, String id) {
        Log.info("Initiating webdriver");
        WebDriver driver = DriverFactory.createInstance(category, id);
        DriverManager.setWebDriver(driver);
    }

    @AfterTest
    public void afterEachTestNgTest() {
        DriverManager.quitWebDriver();
    }
}

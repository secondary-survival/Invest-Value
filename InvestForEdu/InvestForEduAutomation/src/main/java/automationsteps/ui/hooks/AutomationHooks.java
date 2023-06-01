package automationsteps.ui.hooks;

import data.DataProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.LogManager;

import static utils.Browser.Capability.setOptions;

/**
 * Hooks class for all UI automation scripts.
 */
public class AutomationHooks {
    static WebDriver driver;

    /**
     * Performs setup actions before the test suite execution.
     * It initializes the logging, sets up the WebDriver, and opens the specified URL.
     */
    @Before
    public static void suiteSetup() {
        LogManager.getLogManager().getLogger("info").info("Suite Setup Started");
        System.setProperty("webdriver.chrome.driver", DataProvider.XMLDataProvider("./InvestValue/InvestForEdu/UI", "Chrome_Driver_Path"));
        driver = new ChromeDriver(setOptions());
        driver.get(DataProvider.XMLDataProvider("./InvestValue/InvestForEdu/UI", "URL"));
    }

    /**
     * Performs teardown actions after the test suite execution.
     * It logs the suite teardown, and quits the WebDriver instance.
     */
    @After
    public void suiteTearDown() {
        LogManager.getLogManager().getLogger("info").info("Suite Teardown Started");
        driver.quit();
    }
}
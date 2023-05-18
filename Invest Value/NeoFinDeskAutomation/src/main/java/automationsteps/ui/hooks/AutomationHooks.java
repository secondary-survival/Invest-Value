package automationsteps.ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.LogManager;

import static data.DataProvider.dataProvider;
import static utils.Browser.Capability.setOptions;

/**
 * Hooks class for all UI automation scripts.
 */
public class AutomationHooks {
    static WebDriver driver;

    /**
     * this method helps in launching of neofindesk
     */
    @Before
    public static void suiteSetup() {
        LogManager.getLogManager().getLogger("info").info("Suite Setup Started");
        System.setProperty("webdriver.chrome.driver", dataProvider("chrome.driver.path"));
        driver = new ChromeDriver(setOptions());
        driver.get(dataProvider("url"));
    }

    /**
     * this method helps in closing of all browsers
     */
    @After
    public void suiteTearDown() {
        LogManager.getLogManager().getLogger("info").info("Suite Teardown Started");
        driver.quit();
    }
}
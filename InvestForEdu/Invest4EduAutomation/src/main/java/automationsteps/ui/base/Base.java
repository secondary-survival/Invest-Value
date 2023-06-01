package automationsteps.ui.base;

import data.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.logging.LogManager;

import static utils.Browser.Capability.setOptions;

/**
 * AutomationBase class for performing setup and teardown actions before and after the test suite execution.
 */
public class Base {
    static WebDriver driver;

    /**
     * Performs setup actions before the test suite execution.
     * It initializes the logging, sets up the WebDriver, and opens the specified URL.
     */
    @BeforeSuite
    public static void suiteSetup() {
        System.setProperty("webdriver.chrome.driver", DataProvider.XMLDataProvider("./InvestValue/InvestForEdu/UI", "Chrome_Driver_Path"));
        driver = new ChromeDriver(setOptions());
        driver.get(DataProvider.XMLDataProvider("./InvestValue/InvestForEdu/UI", "URL"));
    }

    /**
     * Performs teardown actions after the test suite execution.
     * It logs the suite teardown, and quits the WebDriver instance.
     */
    @AfterSuite
    public void suiteTearDown() {
        driver.quit();
    }
}
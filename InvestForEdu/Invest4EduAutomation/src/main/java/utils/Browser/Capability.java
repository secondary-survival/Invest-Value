package utils.Browser;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Arrays;
public class Capability {
    public static ChromeOptions setOptions() {
        ChromeOptions opt = new ChromeOptions();
        DesiredCapabilities dc = new DesiredCapabilities();
        opt.addArguments("start-maximized");
        opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        dc.setCapability(ChromeOptions.CAPABILITY, opt);
        opt.merge(dc);
        return opt;
    }
}

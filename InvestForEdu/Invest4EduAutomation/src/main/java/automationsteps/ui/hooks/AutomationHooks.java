package automationsteps.ui.hooks;

import org.junit.After;
import org.junit.Before;

import java.util.logging.LogManager;

public class AutomationHooks {

    /**
     * Performs setup actions before each test method execution.
     * It logs the start of the suite setup.
     */
    @Before
    public void beforeHooks() {
        LogManager.getLogManager().getLogger("info").info("Suite Setup Started");
    }

    /**
     * Performs teardown actions after each test method execution.
     * It logs the start of the suite teardown.
     */
    @After
    public void afterHooks() {
        LogManager.getLogManager().getLogger("info").info("Suite Teardown Started");
    }
}
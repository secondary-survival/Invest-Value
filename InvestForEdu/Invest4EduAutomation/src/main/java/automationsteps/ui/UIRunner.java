package automationsteps.ui;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/WebApp/Features/HomePage/UI", glue = "automationsteps.ui", tags = "@UIRegression")
public class UIRunner {
}
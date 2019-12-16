package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHTML-report","pretty","json:target/cucumber.json"},
        features = {"src/test/resources/uiFeatures","src/test/resources/dbFeatures"},
        glue = "stepDefs",
        dryRun =false,
        tags = "@ProjectDay"


)
public class UiTest {

}

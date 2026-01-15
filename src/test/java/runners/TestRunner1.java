package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\AUTOMATION\\Frameworks\\src\\test\\Features\\Emp1.feature",
        glue = {"stepDefinitions2", "hooks"},
        tags = "@hjhfbjhns",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        monochrome = true,
        dryRun = false
)

public class TestRunner1 {
        // kjdfjhjnmsdnm
}

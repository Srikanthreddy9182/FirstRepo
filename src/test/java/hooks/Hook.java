package hooks;

import io.cucumber.java.*;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.time.Duration;

public class Hook {
    static WebDriver driver;

    @BeforeAll
    public static void launchBrowser() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev.urbuddi.com/login");
    }

    @After
    public void loginsetup(Scenario scenario) {
        System.out.println("Login scenario setup");
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        // D
    }

    @AfterAll
    public static void teardown() {
        //DriverManager.quitDriver();
    }
}

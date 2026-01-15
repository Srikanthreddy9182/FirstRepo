package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\.jdks\\openjdk-23\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
        // Close only if employee added successfully
        if (scenario.getName().contains("Add employee") && scenario.isFailed() == false) {
            driver.quit();
        }
    }
}

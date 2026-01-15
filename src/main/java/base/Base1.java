package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Base1 {
    protected WebDriver driver;

// This is for cross browser testing

    @BeforeClass
    public void setup(){
        String [] browsers = {"chrome", "firefox", "edge"};
        //String [] browsers = {"chrome"};
        for (String browser : browsers) {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("https://dev.urbuddi.com/login");
        }
    }
}

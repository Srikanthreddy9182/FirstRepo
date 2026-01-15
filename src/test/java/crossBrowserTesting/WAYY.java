package crossBrowserTesting;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class WAYY  {
    public static WebDriver driver;
    public static void main(String [] args) {
        String [] browsers = {"chrome", "firefox", "edge"};
        for (String browser : browsers) {
            if (browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://dev.urbuddi.com/login");
            //LOGIN
            driver.findElement(By.id("userEmail")).sendKeys("srikanthreddy.udumula@optimworks.com");
            driver.findElement(By.id("userPassword")).sendKeys("Srikrishna@123");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            // EMPLOYEE CREATION
            driver.findElement(By.xpath("(//a[@class='remove-line-nav-item'])[2]")).click();
            driver.findElement(By.xpath("//button[text()='Add Employee']")).click();
            driver.findElement(By.name("firstName")).sendKeys("Srikanth");
            driver.findElement(By.name("lastName")).sendKeys("Srikanthhhhh");
            driver.findElement(By.id("employeeID")).sendKeys("IIIT010");
            driver.findElement(By.name("email")).sendKeys("Srikrishnaa10@gmail.com");
            driver.findElement(By.name("password")).sendKeys("Srikrishna@123");
            driver.findElement(By.name("department")).sendKeys("MCA");
            driver.findElement(By.name("mobileNumber")).sendKeys("9876543210");
            driver.findElement(By.name("designation")).sendKeys("INTERN");
            driver.findElement(By.name("location")).sendKeys("VIZAG");
            driver.findElement(By.name("dob")).sendKeys("10-10-2001");
            driver.findElement(By.name("joiningDate")).sendKeys("17-11-2025");
            driver.findElement(By.id("salary")).sendKeys("15000");
            Select role = new Select(driver.findElement(By.name("role")));
            role.selectByVisibleText("Admin");
            Select qualification = new Select(driver.findElement(By.id("qualifications")));
            qualification.selectByIndex(3);
            Select gender = new Select(driver.findElement(By.id("gender")));
            gender.selectByVisibleText("Male");
            Select blood = new Select(driver.findElement(By.id("bloodGroup")));
            blood.selectByIndex(4);
            //JavascriptExecutor jse = new JavascriptExecutor() ;


            Select reporting = new Select(driver.findElement(By.xpath("//select[@id='reportingTo']")));
            reporting.selectByVisibleText("srikanthreddy.udumula@optimworks.com");
            //report.selectByVisibleText("srikanthreddy.udumula@optimworks.com");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }
    }
}

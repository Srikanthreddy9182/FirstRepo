package crossBrowserTesting;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Way1 {
    static WebDriver driver;
    public static void main(String [] args) throws InterruptedException {
        String browserName = "chrome";
        if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://dev.urbuddi.com/login");

        // LOGIN
        driver.findElement(By.id("userEmail")).sendKeys("srikanthreddy.udumula@optimworks.com");
        driver.findElement(By.id("userPassword")).sendKeys("Srikrishna@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // EMPLOYEE CREATION
        Thread.sleep(1000);
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

        Select qualification = new Select(driver.findElement(By.name("qualifications")));
        qualification.selectByIndex(2);

        Select gender = new Select(driver.findElement(By.name("gender")));
        gender.selectByValue("Male");

        Select bloodGroup = new Select(driver.findElement(By.name("bloodGroup")));
        bloodGroup.selectByIndex(3);

        Select reportto = new Select(driver.findElement(By.name("reportingTO")));
        reportto.selectByContainsVisibleText("srikanthreddy.");

        WebElement report = wait.until(ExpectedConditions.elementToBeClickable(By.name("reportingTo")));
        report.click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}

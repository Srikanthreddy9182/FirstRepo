package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GroupTesting {
    WebDriver driver;
    @Test (priority = 1)
    public void launchBrowser() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev.urbuddi.com/login");
    }
    @Test(priority = 2 , groups = "smoke")
    public void loginTest() {
        driver.findElement(By.id("userEmail")).sendKeys("srikanthreddy.udumula@optimworks.com");
        driver.findElement(By.id("userPassword")).sendKeys("Srikrishna@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test(priority = 3, groups = "regression", dependsOnMethods = "loginTest")
    public void employeeCreation() {
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

        Select role = new Select(driver.findElement(By.name("role")));
        role.selectByVisibleText("Admin");

        Select qualification = new Select(driver.findElement(By.name("qualifications")));
        qualification.selectByIndex(2);

        Select gender = new Select(driver.findElement(By.name("gender")));
        gender.selectByValue("Male");

        Select bloodGroup = new Select(driver.findElement(By.name("bloodGroup")));
        bloodGroup.selectByIndex(3);

        Select reportingTo = new Select(driver.findElement(By.name("reportingTo")));
        reportingTo.selectByVisibleText("srikanthreddy.udumula@optimworks.com");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}

package groupTesting;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GroupTest1 extends Base {

    @Test(groups = {"smoke"})
    public void launchUrBuddi() {
        driver.get("https://dev.urbuddi.com/login");
    }

    @Test(groups = {"smoke"}, dependsOnMethods = "launchUrBuddi")
    public void loginToUrbuddi() {
        driver.findElement(By.id("userEmail")).sendKeys("srikanthreddy.udumula@optimworks.com");
        driver.findElement(By.id("userPassword")).sendKeys("Srikrishna@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(groups = {"regression"},dependsOnMethods = "loginToUrbuddi")
    public void createEmployee() {
        driver.findElement(By.xpath("(//a[@class='remove-line-nav-item'])[2]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        driver.findElement(By.name("firstName")).sendKeys("Srikanthhhhh");
        driver.findElement(By.name("lastName")).sendKeys("Srikanthhhhh");
        driver.findElement(By.name("email")).sendKeys("srikrishnaa@gmail.com");
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
        bloodGroup.selectByVisibleText("0+");

        Select reportingTo = new Select(driver.findElement(By.name("reportingTo")));
        reportingTo.selectByVisibleText("srikanthreddy,udumula@optimworks.com");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}

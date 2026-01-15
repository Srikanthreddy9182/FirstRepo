package stepDefinitions2;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ApplyLeave {
    WebDriver driver;
    @Given("User is On Leave Management Page")
    public void user_is_on_leave_management_page() {
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("(//a[@class='remove-line-nav-item'])[3]")).click();
        driver.findElement(By.xpath("//button[text()='Apply Leave']")).click();
        driver.findElement(By.xpath("(//button[text()='Ok'])[2]")).click();
    }
    @When("User enters Leave details")
    public void user_enters_leave_details(DataTable dataTable) {
        List<Map<String , String>> data = dataTable.asMaps();
        String fromDate = data.get(0).get("fromDate");
        String toDate = data.get(0).get("toDate");
        String subject = data.get(0).get("subject");
        String reasonForLeave = data.get(0).get("reasonForLeave");

        Select lead = new Select(driver.findElement(By.name("lead")));
        lead.selectByIndex(0);

        driver.findElement(By.id("fromDate")).sendKeys(fromDate);
        driver.findElement(By.id("toDate")).sendKeys(toDate);
        driver.findElement(By.name("subject")).sendKeys(subject);
        driver.findElement(By.name("reason")).sendKeys(reasonForLeave);
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("Leave should be applied")
    public void leave_should_be_applied() {
        Assert.assertTrue(driver.getPageSource().contains("Employee added successfully"));
    }
}

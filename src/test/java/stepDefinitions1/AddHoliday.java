package stepDefinitions1;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AddHoliday {
        WebDriver driver;

        @Given("User is on dashboard")
        public void user_is_on_dashboard() {
            driver = DriverManager.getDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("(//a[@class='remove-line-nav-item'])[1]")).click();
            driver.findElement(By.xpath("//button[text()='Add Holidays']")).click();
        }

        @When("User enter holiday details")
        public void user_enter_holiday_details(DataTable dataTable) {
            List<Map<String , String>> data = dataTable.asMaps();
            String occassion = data.get(0).get("occassion");
            String date = data.get(0).get("date");
            driver.findElement(By.name("event")).sendKeys(occassion);
            driver.findElement(By.name("date")).sendKeys(date);
            driver.findElement(By.xpath("//button[@type='submit']"));
        }
        @Then("Holiday should be added successfully")
        public void holiday_should_be_added_successfully() {
            Assert.assertTrue(driver.getPageSource().contains("Holiday added successfully"));
    }
}

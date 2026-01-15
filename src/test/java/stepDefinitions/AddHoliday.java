package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddHolidaysPage;
import utils.DriverManager;

public class AddHoliday {
    WebDriver driver;
    AddHolidaysPage ahp;
    @Given("User is on dashboard")
    public void user_is_on_dashboard() {
        driver = DriverManager.getDriver();
        ahp = new AddHolidaysPage(driver);
        ahp.clickDashboard();
        ahp.clickAddHoliday();
    }
    @When("User enter holiday details")
    public void user_enter_holiday_details() {
        ahp.enterOccassion("New Year");
        ahp.enterDate("01-01-2026");
        ahp.clickSubmit();
    }
    @Then("Holiday should be added successfully")
    public void holiday_should_be_added_successfully() {
        Assert.assertTrue(driver.getPageSource().contains("Holiday added successfully"));
    }
}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ApplyLeavePage;
import utils.DriverManager;

public class ApplyLeave {
    WebDriver driver;
    ApplyLeavePage alp;
    @Given("User is On Leave Management Page")
    public void user_is_on_leave_management_page() {
        driver = DriverManager.getDriver();
        alp = new ApplyLeavePage(driver);
        alp.clickLeaveManagement();
        alp.clickApplyLeavePage();
        alp.confirmToApplyLeave();
    }
    @When("User enters Leave details")
    public void user_enters_leave_details() {
        alp.enterFromDate("30-12-2025");
        alp.enterToDate("02-01-2026");
        alp.enterReason("jhjfchnyjj");
        alp.enterSubject("LEAVE");
        alp.selectLead();
        alp.selectReqType();
        alp.clickSubmit();
    }
    @Then("Leave should be applied")
    public void leave_should_be_applied() {
        Assert.assertTrue(driver.getPageSource().contains("Employee added successfully"));
    }
}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddEmployee;
import utils.DriverManager;

public class AddEmployeeCucumber {
    WebDriver driver;
    AddEmployee addEmpl;
    @Given("User is on employee page")
    public void user_is_on_employee_page() {
        driver = DriverManager.getDriver();
        addEmpl = new AddEmployee(driver);

    }
    @When("User enters details and add a new employee")
    public void user_enters_details_and_add_a_new_employee() {
        addEmpl.addEmp("Srikanthh","Srikanthh","IIIT01","srikrishna01@gmail.com","Srikrishna@123","MCA","INTERN","9876543210","VIZAG","17-11-2025","10-10-2001","20000");
    }
    @Then("Employee should be created successfully")
    public void employee_should_be_created_successfully() {
        Assert.assertTrue(driver.getPageSource().contains("employee added successfully"));
    }

}

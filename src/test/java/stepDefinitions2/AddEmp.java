package stepDefinitions2;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AddEmp {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on employee page")
    public void user_is_on_employee_page() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("(//a[@class='remove-line-nav-item'])[2]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    }
    @When("User enters details and add a new employee")
    public void user_enters_details_and_add_a_new_employee(DataTable dataTable) throws InterruptedException {
        List<Map<String,String>> data = dataTable.asMaps();
        String firstname = data.get(0).get("firstname");
        String lastname = data.get(0).get("lastname");
        String employeeID = data.get(0).get("employeeID");
        String email = data.get(0).get("email");
        String password = data.get(0).get("password");
        String department = data.get(0).get("department");
        String designation = data.get(0).get("designation");
        String mobileno = data.get(0).get("mobileNumber");
        String location = data.get(0).get("location");
        String dob = data.get(0).get("dob");
        String joiningDate = data.get(0).get("joiningDate");
        String qualification = data.get(0).get("qualification");
        String role = data.get(0).get("role");
        String gender = data.get(0).get("gender");
        String bloodGroup = data.get(0).get("bloodGroup");
        String salary = data.get(0).get("salary");
        String reportingTo = data.get(0).get("ReportingTo");


        driver.findElement(By.name("firstName")).sendKeys(firstname);
        driver.findElement(By.name("lastName")).sendKeys(lastname);
        driver.findElement(By.id("employeeID")).sendKeys(employeeID);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("department")).sendKeys(department);
        driver.findElement(By.name("designation")).sendKeys(designation);
        driver.findElement(By.name("mobileNumber")).sendKeys(mobileno);
        driver.findElement(By.name("location")).sendKeys(location);
        driver.findElement(By.name("dob")).sendKeys(dob);
        driver.findElement(By.name("joiningDate")).sendKeys(joiningDate);
        driver.findElement(By.id("salary")).sendKeys(salary);
        Select qualificationdd = new Select(driver.findElement(By.id("qualifications")));
        qualificationdd.selectByVisibleText(qualification);
        Select roledd = new Select(driver.findElement(By.name("role")));
        roledd.selectByVisibleText(role);
        Select genderdd = new Select(driver.findElement(By.id("gender")));
        genderdd.selectByVisibleText(gender);
        Select bloodGroupdd = new Select(driver.findElement(By.id("bloodGroup")));
        bloodGroupdd.selectByIndex(Integer.parseInt(bloodGroup));
        //wait.until(ExpectedConditions.);

        WebElement reportingToField = wait.until(ExpectedConditions.elementToBeClickable(By.id("reportingTo")));
        reportingToField.click();
//        reportingToField.clear();
//        Thread.sleep(50000);
        reportingToField.sendKeys(reportingTo);
        By option =
                By.xpath("//li[normalize-space()='" + reportingTo + "']");

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//li[contains(text(),'" + reportingTo + "')]")
//        )).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("Employee should be created successfully")
    public void employee_should_be_created_successfully() {
        Assert.assertTrue(driver.getPageSource().contains("employee added successfully"));
    }
}

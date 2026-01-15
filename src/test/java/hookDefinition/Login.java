package hookDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    }
    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps();
        String username = data.get(0).get("username");
        String password = data.get(0).get("password");

        driver.findElement(By.id("userEmail")).sendKeys(username);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }
    @Then("User should be redirected to Home Page")
    public void user_should_be_redirected_to_home_page() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "urBuddi";
        assertEquals("User is on Homepage",expectedTitle,actualTitle);
        System.out.println("Page title verified : " + actualTitle);
    }

    @Given("User is on employee page")
    public void user_is_on_employee_page() {
        driver.get("https://your-app-url.com/employees"); // Replace with employee page
    }

    @When("User enters details and add a new employee")
    public void user_enters_details_and_add_a_new_employee(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> emp = data.get(0);

        driver.findElement(By.id("firstName")).sendKeys(emp.get("firstname"));
        driver.findElement(By.id("lastName")).sendKeys(emp.get("lastname"));
        driver.findElement(By.id("employeeId")).sendKeys(emp.get("employeeID"));
        driver.findElement(By.id("email")).sendKeys(emp.get("email"));
        driver.findElement(By.id("password")).sendKeys(emp.get("password"));
        driver.findElement(By.id("department")).sendKeys(emp.get("department"));
        driver.findElement(By.id("designation")).sendKeys(emp.get("designation"));
        driver.findElement(By.id("mobileNumber")).sendKeys(emp.get("mobileNumber"));
        driver.findElement(By.id("location")).sendKeys(emp.get("location"));
        driver.findElement(By.id("dob")).sendKeys(emp.get("dob"));
        driver.findElement(By.id("joiningDate")).sendKeys(emp.get("joiningDate"));
        driver.findElement(By.id("qualification")).sendKeys(emp.get("qualification"));
        driver.findElement(By.id("role")).sendKeys(emp.get("role"));
        driver.findElement(By.id("gender")).sendKeys(emp.get("gender"));
        driver.findElement(By.id("bloodGroup")).sendKeys(emp.get("bloodGroup"));
        driver.findElement(By.id("salary")).sendKeys(emp.get("salary"));

        // ---------------- Reporting To Dropdown ----------------
        WebElement reportingToField = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("reportingTo")));
        reportingToField.click();

        // Type partial text for autocomplete
        String reportingTo = emp.get("ReportingTo");
        reportingToField.sendKeys(reportingTo.substring(0, 4));

        // Wait and select from dropdown
        By option = By.xpath("//li[contains(text(),'" + reportingTo + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        // Submit
        driver.findElement(By.id("submitBtn")).click();
    }

    @Then("Employee should be created successfully")
    public void employee_should_be_created_successfully() {
        WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("successMsg")));
        System.out.println("Employee added: " + successMsg.getText());
    }
}

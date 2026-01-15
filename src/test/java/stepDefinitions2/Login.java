package stepDefinitions2;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class Login {
    WebDriver driver;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver = DriverManager.getDriver();
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
}

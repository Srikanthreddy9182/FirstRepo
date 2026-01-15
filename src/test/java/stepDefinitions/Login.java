package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.DriverManager;

import static org.testng.AssertJUnit.assertEquals;

public class Login {
    WebDriver driver;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver = DriverManager.getDriver();
        driver.get("https://dev.urbuddi.com/login");
    }
    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        driver.findElement(By.id("userEmail")).sendKeys("srikanthreddy.udumula@optimworks.com");
        driver.findElement(By.id("userPassword")).sendKeys("Srikrishna@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("User should be redirected to Home Page")
    public void user_should_be_redirected_to_home_page() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "urBuddi";
        assertEquals("User is on Homepage",expectedTitle,actualTitle);
        System.out.println("Page title verified : " + actualTitle);
    }
}

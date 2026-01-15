//package stepDefinitions2;
//
//import io.cucumber.java.en.Given;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import utils.DriverManager;
//
//public class BackgroundStepDefinition {
//    @Given("User is logged into the application")
//    public void user_is_logged_in() {
//        WebDriver driver = DriverManager.getDriver();
//        driver.get("https://dev.urbuddi.com/login");
//
//        driver.findElement(By.id("userEmail"))
//                .sendKeys("srikanthreddy.udumula@optimworks.com");
//        driver.findElement(By.id("userPassword"))
//                .sendKeys("Srikrishna@123");
//        driver.findElement(By.xpath("//button[contains(text(),'Login')]"))
//                .click();
//    }
//
//}

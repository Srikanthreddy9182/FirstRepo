package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userMail = By.id("userEmail");
    By passWord = By.id("userPassword");
    By submit = By.xpath("//button[text()='Login']");

    public void enterUserMail(String email) {
        driver.findElement(userMail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passWord).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submit).click();
    }

    public void login(String username, String password) {
        enterUserMail(username);
        enterPassword(password);
        clickSubmit();
    }
}

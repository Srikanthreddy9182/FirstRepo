package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddHolidaysPage {
    WebDriver driver;

    public AddHolidaysPage(WebDriver driver){
        this.driver = driver;
    }
    By dashoard = By.xpath("//a[@class='remove-line-nav-item']");
    By addHoliday = By.xpath("//button[text()='Add Holidays']");
    By occassion = By.name("event");
    By date = By.name("date");
    By submit = By.xpath("//button[@type='submit']");

    public void clickDashboard(){
        driver.findElement(dashoard).click();
    }
    public void clickAddHoliday(){
        driver.findElement(addHoliday).click();
    }
    public void enterOccassion(String event){
        driver.findElement(occassion).sendKeys(event);
    }
    public void enterDate(String dt){
        driver.findElement(date).sendKeys(dt);
    }
    public void clickSubmit(){
        driver.findElement(submit).click();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ApplyLeavePage {
    WebDriver driver;

    public ApplyLeavePage(WebDriver driver) {
        this.driver = driver;
    }

    By leavemng = By.xpath("(//a[@class='remove-line-nav-item'])[3]");
    By applyLeave = By.xpath("//button[text()='Apply Leave']");
    By confirm = By.xpath("(//button[text()='Ok'])[2]");
    By fromDate = By.id("fromDate");
    By toDate = By.id("toDate");
    By subject = By.name("subject");
    By lead = By.name("lead");
    By reason = By.name("reason");
    By reqType = By.xpath("(//input[@type='radio'])[2]");
    By sub = By.xpath("//button[@type='submit']");

    public void clickLeaveManagement() {
        driver.findElement(leavemng).click();
    }
    public void clickApplyLeavePage() {
        driver.findElement(applyLeave).click();
    }
    public void confirmToApplyLeave(){
        driver.findElement(confirm).click();
    }
    public void enterFromDate(String fDate) {
        driver.findElement(fromDate).sendKeys(fDate);
    }
    public void enterToDate(String tDate) {
        driver.findElement(toDate).sendKeys(tDate);
    }
    public void enterSubject(String sub) {
        driver.findElement(subject).sendKeys(sub);
    }
    public void selectLead(){
        Select leadd = new Select(driver.findElement(lead));
        leadd.selectByIndex(1);
    }
    public void enterReason(String reas) {
        driver.findElement(reason).sendKeys(reas);
    }
    public void selectReqType(){
        driver.findElement(reqType).click();
    }
    public void clickSubmit() {
        driver.findElement(sub).click();
    }

}

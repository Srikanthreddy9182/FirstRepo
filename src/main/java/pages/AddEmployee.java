package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployee {
    WebDriver driver;

    public AddEmployee(WebDriver driver){
        this.driver = driver;
    }
    By employee = By.xpath("(//a[@class='remove-line-nav-item'])[2]");
    By addEmployee = By.xpath("(//button[@type='button'])[3]");
    By firstname = By.name("firstName");
    By lastname = By.name("lastName");
    By employeeID = By.id("employeeID");
    By email = By.name("email");
    By password = By.name("password");
    By department = By.name("department");
    By designation = By.name("designation");
    By mobileno = By.name("mobileNumber");
    By location = By.name("location");
    By dob = By.name("dob");
    By joindate = By.name("joiningDate");
    By salary = By.id("salary");
    By sumbit = By.xpath("//button[@type='submit']");

    public void clickEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(employee)).click();
    }
    public void clickAddEmployee() {
        driver.findElement(addEmployee).click();
    }
    public void clickRole(){
        Select rolee = new Select(driver.findElement(By.name("role")));
        rolee.selectByIndex(2);
    }
    public void clickQualification(){
        Select qual = new Select(driver.findElement(By.id("qualifications")));
        qual.selectByIndex(3);
    }
    public void clickGender(){
        Select gen = new Select(driver.findElement(By.id("gender")));
        gen.selectByVisibleText("Male");
    }
    public void clickBloodGroup(){
        Select blood = new Select(driver.findElement(By.id("bloodGroup")));
        blood.selectByIndex(4);
    }
    public void clickReport(){
        Select report = new Select(driver.findElement(By.id("reportingTo")));
        report.selectByVisibleText("srikanthreddy.udumula@optimworks.com");
    }
    public void enterfirstName(String fName){
        driver.findElement(firstname).sendKeys(fName);
    }
    public void enterlastName (String lName){
        driver.findElement(lastname).sendKeys(lName);
    }
    public void enteremployeID(String empID){
        driver.findElement(employeeID).sendKeys(empID);
    }
    public void enterEmail(String eMail){
        driver.findElement(email).sendKeys(eMail);
    }
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void enterDesignation(String desig){
        driver.findElement(designation).sendKeys(desig);
    }
    public void enterDepartment(String depart){
        driver.findElement(department).sendKeys(depart);
    }
    public void enterMobileNo(String mobNo){
        driver.findElement(mobileno).sendKeys(mobNo);
    }
    public void enterLocation(String loc){
        driver.findElement(location).sendKeys(loc);
    }
    public void enterDOB(String birthdate) {
        driver.findElement(dob).sendKeys(birthdate);
    }
    public void enterJoindate(String joiningDate){
        driver.findElement(joindate).sendKeys(joiningDate);
    }
    public void enterSalary(String sal){
        driver.findElement(salary).sendKeys(sal);
    }
    public void clickSubmit(){
        driver.findElement(sumbit).click();
    }

    public void addEmp(String fname, String lname, String empID, String email, String passw, String dep, String design, String mobNO, String loc, String joinDATE,String birthDTAE,String Salary){
        clickEmployee();
        clickAddEmployee();
        enterfirstName(fname);
        enterlastName(lname);
        enteremployeID(empID);
        enterEmail(email);
        enterPassword(passw);
        enterDepartment(dep);
        enterDesignation(design);
        enterMobileNo(mobNO);
        enterLocation(loc);
        enterJoindate(joinDATE);
        enterDOB(birthDTAE);
        enterSalary(Salary);
        clickRole();
        clickGender();
        clickBloodGroup();
        clickReport();
        clickQualification();
        clickSubmit();
    }
}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.UploadFile;
import utils.DriverManager;

import java.awt.*;

public class UploadExcelFile {
    WebDriver driver;
    UploadFile uf ;
    @Given("User is on employee page to upload doc")
    public void user_is_on_employee_page_to_upload_doc() {
        driver = DriverManager.getDriver();
        uf = new UploadFile(driver);
        uf.clickEmpPage();
        uf.clickImportDoc();
    }
    @When("User selct a file and upload")
    public void user_selct_a_file_and_upload() throws AWTException {
        uf.clickUpload();
        uf.clickSubmit();
    }
    @Then("Document should be uploaded successfully")
    public void document_should_be_uploaded_successfully() {
        Assert.assertTrue(driver.getPageSource().contains("File uploaded successfully"));
    }
}
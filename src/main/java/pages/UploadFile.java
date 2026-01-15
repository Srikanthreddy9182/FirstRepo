package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile {
    WebDriver driver;

    public UploadFile(WebDriver driver){
        this.driver = driver;
    }

    By empPage = By.xpath("(//a[@class='remove-line-nav-item'])[2]");
    By importDoc = By.xpath("//button[text()='Import Excel Sheet']");
    By upload = By.id("uploadBtn");
    By submit = By.xpath("//button[text()='Submit']");


    public void clickEmpPage(){
        driver.findElement(empPage).click();
    }
    public void clickImportDoc(){
        driver.findElement(importDoc).click();
    }
    public void clickUpload() throws AWTException {
        driver.findElement(upload).click();
        StringSelection select = new StringSelection("C:\\Users\\admin\\Downloads\\WhatsApp Image 2025-12-22 at 11.01.04 AM (2).jpeg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select,null);

        Robot r = new Robot();
        r.setAutoDelay(300);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }
    public void clickSubmit(){
        driver.findElement(submit).click();
    }
}

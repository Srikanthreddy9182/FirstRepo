package crossBrowserTesting;

import base.Base;
import base.Base1;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.LoginPage;

public class Way extends Base1 {

    @Test(priority = 1)
    public void loginpage(){
        LoginPage lp = new LoginPage(driver);
        lp.login("srikanthreddy.udumula@optimworks.com","Srikrishna@123");
    }
    @Test(priority = 2, dependsOnMethods = "loginpage")
    public void addemppage(){
        AddEmployee ae = new AddEmployee(driver);
        ae.addEmp("srikanth","krishna","IIIT001","srikrishna01@gmial.com","Srikrishna@123","MCA","INTERN","9876543210","VIZAG","17-11-2025","10-10-2001","15000");
    }
}

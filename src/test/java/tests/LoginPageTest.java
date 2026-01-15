package tests;

import base.Base;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends Base {

    @Test
    public void loginpage() {
        LoginPage lp = new LoginPage(driver);
        lp.login("srikanthreddy.udumula@optimworks.com", "Srikrishna@123");
    }
}

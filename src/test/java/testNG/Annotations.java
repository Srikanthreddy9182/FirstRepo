package testNG;

import org.testng.annotations.*;

public class Annotations {
    @BeforeTest
    public void A() {
        System.out.println("test case a");
    }
    @AfterClass
    public void B() {
        System.out.println("test case b");
    }
    @Test
    public void C() {
        System.out.println("test case c");
    }
    @BeforeMethod
    public void D() {
        System.out.println("test case d");
    }
    @BeforeSuite
    public void E() {
        System.out.println("test case e");
    }
    @AfterSuite
    public void F() {
        System.out.println("test case f");
    }
    @AfterTest
    public void G() {
        System.out.println("test case g");
    }
    @AfterMethod
    public void H() {
        System.out.println("test case h");
    }
    @BeforeClass
    public void I() {
        System.out.println("test case i");
    }

}

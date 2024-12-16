package testcases;

import basepage.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    public LoginPage loginPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        init();
        loginPage = new LoginPage();
    }

    @Test
    public void search_test(){
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("domain"));
    }

}

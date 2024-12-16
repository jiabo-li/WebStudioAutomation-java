package testcases;

import basepage.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MachineCatalogsPage;

public class MachineCatalogPageTest extends TestBase {
    public LoginPage loginPage;
    public MachineCatalogsPage machineCatalogsPage;

    public MachineCatalogPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        init();
        loginPage = new LoginPage();
        machineCatalogsPage = new MachineCatalogsPage();
        loginPage.login(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("domain"));
    }

    @Test(priority = 1)
    public void testCreateMachineCatalog(){
        boolean is_singSesssion = true;
        machineCatalogsPage.createMachineCatalog(is_singSesssion,"PNQXC-VDA-1","VDICatalog");
    }

    @Test(priority = 2)
    public void deleteMachineCatalog(){
        machineCatalogsPage.deleteCatalog("VDICatalog");
    }

}

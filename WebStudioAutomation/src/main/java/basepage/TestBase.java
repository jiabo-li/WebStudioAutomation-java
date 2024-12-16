package basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import util.WebEventListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver ori_driver;
    public static Properties prop;
    public static WebDriver driver;
    public static WebEventListener driverListener;

    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream file =  new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
            prop.load(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void  init(){
        String browserName = prop.getProperty("browser");
        String webdriver_path = prop.getProperty("webdirver");
        System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver-win64\\chromedriver.exe");

        if(browserName.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-ssl-errors=yes");
            options.addArguments("--ignore-certificate-errors");
            ori_driver = new ChromeDriver(options);
        }else if(browserName.equals("FF")) {
            ori_driver = new FirefoxDriver();
        }
        driverListener =new WebEventListener();
        driver = new EventFiringDecorator(driverListener).decorate(ori_driver);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

}

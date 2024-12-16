package basepage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;


public class login {

    @Test
    public void login_page(){
        ChromeOptions option = new ChromeOptions();

        String webdriver_path = "C:\\software\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",webdriver_path);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        
        
    }


}

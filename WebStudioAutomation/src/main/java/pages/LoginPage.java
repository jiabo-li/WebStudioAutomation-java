package pages;

import basepage.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WebEventListener;

public class LoginPage extends TestBase {

    @FindBy(id="username")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="domain")
    WebElement domain;

    @FindBy(className="main-btn")
    WebElement sign_btn;

    public  LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void login(String username,String password,String domain){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.domain.sendKeys(domain);

        sign_btn.click();
    }
}

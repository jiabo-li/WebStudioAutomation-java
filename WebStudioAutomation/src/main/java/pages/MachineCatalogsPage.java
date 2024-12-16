package pages;

import basepage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v128.dom.model.ShadowRootType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MachineCatalogsPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"MachineCatalogs_Node\"]")
    WebElement machineCatalogNode;

    @FindBy(xpath = "//*[@id=\"CreateMachineCatalog\"]")
    //@FindBy(xpath = "//*[@id=\"87\"]")
    private WebElement machineCatalog;

    @FindBy(css = "application-loader")
    WebElement appLoader;

    @FindBy(linkText = "Create Folder")
    WebElement createFolderButton;

    @FindBy(xpath = "//*[@id=\"cancleButton\"]")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"radio1\"]")
    WebElement multiSessionRadio;

    @FindBy(xpath = "//*[@id=\"radio2\"]")
    WebElement singleSessionRadio;

    private SearchContext shadowRoot;

    private  WebDriverWait wait;


    public MachineCatalogsPage(){
        PageFactory.initElements(driver,this);
        Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver,duration);
    }

    private WebElement getShadowElement(String selectorString){
        return shadowRoot.findElement(By.cssSelector(selectorString));
    }

    private WebElement getShadowButton(String buttonTage,String buttonText){
        List<WebElement> buttons = shadowRoot.findElements(By.cssSelector(buttonTage));
        for(WebElement button: buttons){
            System.out.println(button.getText());
            if(button.getText().equals(buttonText)){
                System.out.println("Get the  button " + button.getText());
                return  button;
            }
        }
        return null;
    }

    public void deleteCatalog(String catalogName){
        machineCatalogNode.click();
        shadowRoot = appLoader.getShadowRoot();

        WebElement catalog = getShadowButton("#machinecatalog-name",catalogName);
        catalog.click();

        //#\39 1 > span
        WebElement deleteCatalog = getShadowElement("#\\39 1");
        deleteCatalog.click();

        WebElement matCheckbox = getShadowElement("#mat-mdc-checkbox-1-input");
        matCheckbox.click();

        WebElement deleteButton = getShadowElement("#mcDeleteMachineCatalog");
        deleteButton.click();

    }

    public void createMachineCatalog(boolean singSession,String VDAName,String catalogName){
        //Duration duration = Duration.ofSeconds(10);
        //WebDriverWait wait =  new WebDriverWait(driver,duration);

        wait.until(ExpectedConditions.visibilityOf(machineCatalogNode));

        machineCatalogNode.click();
        //driver.switchTo().frame(1);

        shadowRoot = appLoader.getShadowRoot();

        WebElement catalogCreate = getShadowElement("#CreateMachineCatalog");
        wait.until(ExpectedConditions.visibilityOf(catalogCreate));
        catalogCreate.click();

        WebElement nextButton = getShadowButton("stud-button","Next");
        nextButton.click();

        //#radio2 > form > label > div > span
        if(singSession){
            WebElement sSessionRadio = getShadowElement("#radio2");
            sSessionRadio.click();
        }else{
            WebElement mSessionRadio = getShadowElement("#radio1");
            mSessionRadio.click();
        }
        //click next button 4 times
        for(int i=0;i<3;i++) {
            nextButton = getShadowButton("stud-button", "Next");
            nextButton.click();
        }
        //
        WebElement addMachine =  getShadowButton("stud-button","Add machines");
        addMachine.click();

        WebElement addMachineInput =  shadowRoot.findElement(By.cssSelector("#accountPickerInputter"));
        addMachineInput.sendKeys(VDAName);

        WebElement checkNames = getShadowButton("stud-button","Check names");
        checkNames.click();

        WebElement doneButton =  getShadowButton("stud-button","Done");
        doneButton.click();


        nextButton = getShadowButton("stud-button", "Next");
        nextButton.click();
        System.out.println("Click the next button for the first time");
        nextButton = getShadowButton("stud-button", "Next");
        nextButton.click();
        System.out.println("Click the next button for the second time");

        WebElement nameInput = getShadowElement("#name");
        nameInput.sendKeys(catalogName);

        WebElement finishtButton =  getShadowButton("stud-button","Finish");
        finishtButton.click();

    }
}

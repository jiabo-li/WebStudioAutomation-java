package pages;

import basepage.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryGroupsPage extends TestBase {
    ////*[@id="DeliveryGroups_Node"]/span/span[1]
    @FindBy(xpath = "//*[@id=\"DeliveryGroups_Node\"]")
    WebElement deliveryGroupsNode;

    ////*[@id="deliverygroup-name"]

    public DeliveryGroupsPage(){
        PageFactory.initElements(driver,this);
    }
    public void createDeliveryGroup(String deiveryGroupName,String VDAName){
        
    }

    public void getDeliveryGroup(String deliveryGroupName,boolean expectedExist){
        deliveryGroupsNode.click();
    }
}



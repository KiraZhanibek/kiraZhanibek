package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeMainPage {
    WebDriver driver;
    public OrangeMainPage(){
        this.driver= Driver.DriverSetup("Chrome");
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminButton;

    @FindBy(xpath = "//a[@href='saveSystemUser?userId=2']")
    public WebElement lindaAndersonButton;
}

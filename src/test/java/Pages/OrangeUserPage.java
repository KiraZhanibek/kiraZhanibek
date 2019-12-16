package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;



public class OrangeUserPage {
    WebDriver driver;
    public OrangeUserPage(){
        this.driver= Driver.DriverSetup("Chrome");
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "btnSave")
    public WebElement editButton;

    @FindBy(id="systemUser_chkChangePassword")
    public WebElement changePassword;

    @FindBy(id="systemUser_password")
    public WebElement password;

   @FindBy(id="systemUser_confirmPassword")
    public WebElement confirmPassword;

   @FindBy(id="btnSave")
    public WebElement saveButton;

   @FindBy(id="welcome")
    public WebElement welcomeLinda;

   @FindBy(xpath = "//a[@href='/index.php/auth/logout']")
    public WebElement logOutButton;

   @FindBy(id = "welcome")
    public WebElement welcomeAdmin;





}

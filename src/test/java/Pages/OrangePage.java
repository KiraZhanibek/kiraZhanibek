package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangePage {
    WebDriver driver;
    public OrangePage(){
        this.driver= Driver.DriverSetup("Chrome");
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "txtUsername")
    public WebElement logIn;

    @FindBy(id="txtPassword")
    public WebElement password;

    @FindBy(id="btnLogin")
    public WebElement logInButton;











}

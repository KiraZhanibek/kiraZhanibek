package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class FreeShippingPage {
    WebDriver driver;

    public FreeShippingPage (){
        this.driver= Driver.DriverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

   @FindBy(id = "global-enhancements-search-query")
    public WebElement searchingField;

  @FindBy(xpath = "//input[@name='free_shipping']")
    public WebElement freeShippingButton;

  @FindBy(xpath = "//span[@class='text-body-smaller no-wrap']")
    public List<WebElement> FreeShippingList;

  @FindBy(xpath = "//a[@data-path='Over $1,000']")
    public WebElement over1000Checkboxes;

  @FindBy(xpath = "//ul[@class=‘responsive-listing-grid wt-grid wt-grid--block justify-content-flex-start pl-xs-0’]//span[@class=‘currency-value’]")
    public List<WebElement> resultPrace;


}

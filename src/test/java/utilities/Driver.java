package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //we are using driver class to initialize our webdriver

    public static WebDriver driver;
    public static WebDriver DriverSetup(String browser){  //utelity class-helpfull class.helps us to set up w driver,

        if(driver!=null) {
            return driver;
        }
        switch (browser.toLowerCase()){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver =new ChromeDriver();
                break;
            case ("ff"):
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver=new OperaDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
        }
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }
    public static void closeDriver(){
        if(driver !=null){
            driver.quit();
            driver=null;
        }
    }
}









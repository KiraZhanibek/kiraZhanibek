package stepDefs;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class Hooks {
   @Before
    public void setUp(){

       WebDriver driver= Driver.DriverSetup("chrome");
       //after driver we have to put implicit wait
      // driver.manage().timeouts().implicitlyWait(10000)
   }
   @After
    //Taking screenShot
    public void tearDown(Scenario scenario){
      if(scenario.isFailed()) {
        final byte[]screenShot=((TakesScreenshot)Driver.driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot,"image.png");
      }
      Driver.closeDriver();
   }
}

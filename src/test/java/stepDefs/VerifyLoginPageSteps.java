package stepDefs;

import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import utilities.Configuration;
import utilities.Driver;

public class VerifyLoginPageSteps {
//   WebDriver driver= Driver.Drive

   LoginPage loginPage=new LoginPage();
    @Given("^navigate to login page$")
    public void navigate_to_login_page() throws Throwable {
        Driver.driver.get(Configuration.fileReader("browserUrl"));

     Thread.sleep(2000);

    }

    @Then("^user logs in with valid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_valid_credentials_username_password(String userName, String password) throws Throwable {
     loginPage.userName.sendKeys(userName);
     loginPage.password.sendKeys(password);
     loginPage.loginButton.click();


    }

    @Then("^Verify user is in Homepage$")
    public void verify_user_is_in_Homepage() throws Throwable {
     String actualTitle=Driver.driver.getTitle();
     String expectedTitle="Web Orders";

        Assert.assertEquals(expectedTitle,actualTitle);

    }
    @Then("^user logs in with invalid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_invalid_credentials_username_password(String userName, String Password) throws Throwable {
       loginPage.userName.sendKeys(userName);
       loginPage.password.sendKeys(Password);
       loginPage.loginButton.click();


    }

    @Then("^Verify user gets error message \"([^\"]*)\"$")
    public void verify_user_gets_error_message(String errorMessage) throws Throwable {

        String actualResult=loginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage,actualResult);

    }


}

package stepDefs;

import Pages.OrangeMainPage;
import Pages.OrangePage;
import Pages.OrangeUserPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Configuration;
import utilities.Driver;

import java.io.IOException;

public class OrangeStep {
    OrangePage orangePage=new OrangePage();
    OrangeMainPage orangeMainPage=new OrangeMainPage();
    OrangeUserPage orangeUserPage=new OrangeUserPage();
    WebDriverWait wait=new WebDriverWait(Driver.driver,10);
    @Given("^navigate to  Orange login page$")
    public void navigateToOrangeLoginPage() throws IOException {
        Driver.driver.get(Configuration.fileReader("orangePageUrl1"));
    }
    @Then("^user provides  logIn \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_provides_logIn_and_password(String userName, String Password) throws Throwable {
       orangePage.logIn.sendKeys(userName);
       orangePage.password.sendKeys(Password);
       orangePage.logInButton.click();
       Thread.sleep(4000);
    }

    @Then("^Change password for Fiona Grace$")
    public void change_password_for_Fiona_Grace() throws Throwable {
   orangeMainPage.adminButton.click();
        wait.until(ExpectedConditions.visibilityOf(orangeMainPage.adminButton));
        orangeMainPage.lindaAndersonButton.click();
        orangeUserPage.editButton.click();
        orangeUserPage.changePassword.click();
        orangeUserPage.password.sendKeys("12345678");
        orangeUserPage.confirmPassword.sendKeys("12345678");
        orangeUserPage.saveButton.click();
        orangeUserPage.welcomeLinda.click();
        Thread.sleep(2000);
        orangeUserPage.welcomeAdmin.click();
        orangeUserPage.logOutButton.click();





    }

    @Then("^Verify is changed by singing in again$")
    public void verify_is_changed_by_singing_in_again() throws Throwable {
        orangePage.logIn.sendKeys("Linda.anderson");
        orangePage.password.sendKeys("12345678");
        orangePage.logInButton.click();
     String actualResult=orangeUserPage.welcomeLinda.getText();
     Assert.assertEquals("Welcome Linda",actualResult);







    }


}

package stepDefs;

import Pages.FreeShippingPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.Driver;

import java.io.IOException;

public class FreeShippingStep {
    FreeShippingPage freeShippingPage = new FreeShippingPage();

    @Given("^navigate to Home page$")
    public void navigateToHomePage() throws IOException {
        Driver.driver.get(Configuration.fileReader("etsyurl"));
    }


    @Then("^input you item  click search button$")
    public void inputYouItemClickSearchButton() {
        freeShippingPage.searchingField.sendKeys("Wireless iphone charger"+ Keys.ENTER);


    }

    @And("^user click on free shipping button$")
    public void userClickOnFreeShippingButton() {
        BrowserUtils.hover(freeShippingPage.freeShippingButton, Driver.driver);



    }

    @Then("^Verify user in free shipping page$")
    public void verifyUserInFreeShippingPage() {
        for (WebElement list : freeShippingPage.FreeShippingList) {
            Assert.assertTrue(list.getText().contains("FREE shipping"));
        }
    }


}

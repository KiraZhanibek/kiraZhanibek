package stepDefs;

import Pages.FreeShippingPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class EtsySteps {
    FreeShippingPage freeShippingPage = new FreeShippingPage();

    @When("^User searching for \"([^\"]*)\"$")
    public void userSearchingFor(String arg0) throws Throwable {
        freeShippingPage.searchingField.sendKeys("Carpet" + Keys.ENTER);
    }


    @And("^User click on Over Price checkbox$")
    public void userClickOnOverPriceCheckbox() {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(freeShippingPage.over1000Checkboxes));
        freeShippingPage.over1000Checkboxes.click();

    }

    @Then("^user verifyies$")
    public void userVerifyies() {
        for (WebElement element : freeShippingPage.resultPrace) {
            String number = element.getText().replace(",", "");
            System.out.println(number);
            if (!number.isEmpty()) {
                double price = Double.parseDouble(number);
                Assert.assertTrue(price >= 799);
            }
        }
    }


    }

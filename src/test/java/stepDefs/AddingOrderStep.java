package stepDefs;
import Pages.OrderHomePage;
import Pages.OrdersPage;
import com.google.common.collect.Maps;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AddingOrderStep {
  OrderHomePage orderHomePage = new OrderHomePage();
  OrdersPage ordersPage = new OrdersPage();
  int initalOrderCount;
 OrderHomePage deleteButton=new OrderHomePage();

  @Then("^User clicks on Order$")
  public void user_clicks_on_Order() throws Throwable {

    initalOrderCount = orderHomePage.orderRows.size();
    orderHomePage.orderbutton.click();
  }

  @Then("^user creates new Order$")
  public void user_creates_new_Order(DataTable dataTable) throws Throwable {
    List<Map<String, Object>> listOfMaps = dataTable.asMaps(String.class, Object.class);
    Select select = new Select(ordersPage.ProductName);
    //  Thread.sleep(5000);
    select.selectByVisibleText(listOfMaps.get(0).get("Product Name").toString());
    ordersPage.Quantity.sendKeys(listOfMaps.get(0).get("Quantity").toString());
    ordersPage.customerName.sendKeys(listOfMaps.get(0).get("Customer Name").toString());
    ordersPage.Street.sendKeys(listOfMaps.get(0).get("Street").toString());
    ordersPage.city.sendKeys(listOfMaps.get(0).get("City").toString());
    ordersPage.Street.sendKeys(listOfMaps.get(0).get("State").toString());
    ordersPage.zipCode.sendKeys(listOfMaps.get(0).get("Zip").toString());
    ordersPage.cardNumber.sendKeys(listOfMaps.get(0).get("Card Number").toString());
    ordersPage.expiredData.sendKeys(listOfMaps.get(0).get("Expire Date").toString());
    ordersPage.paymentOption.click();
    ordersPage.prossesButton.click();
    Thread.sleep(5000);

  }

  @Then("^User verifies Order is created$")
  public void user_verifies_Order_is_created() throws Throwable {

    ordersPage.orderViewButton.click();
    int afterOrderCreated = orderHomePage.orderRows.size();
    Assert.assertEquals(initalOrderCount + 1, afterOrderCreated);


  }

  @Then("^User verifies Order is not created$")
  public void userVerifiesOrderIsNotCreated() {

    ordersPage.orderViewButton.click();
    int afterOrderCreated = orderHomePage.orderRows.size();
    Assert.assertEquals(initalOrderCount, afterOrderCreated);

  }
  //Deleting name drom list

  @And("^User deletes \"([^\"]*)\" from table$")
  public void userDeletesFromTable(String name) throws Throwable {
   for(int i=0; i<orderHomePage.Names.size();i++){
     if(orderHomePage.Names.get(i).getText().equalsIgnoreCase(name)){
        orderHomePage.checkBoxes.get(i).click();
     }
   }
    Thread.sleep(2000);
   deleteButton.deleteButton.click();
  }


  @Then("^User vaidate that \"([^\"]*)\" is deleted$")
  public void userVaidateThatIsDeleted(String name) throws Throwable {
     for(WebElement el:orderHomePage.Names){
       Assert.assertFalse(el.getText().equalsIgnoreCase(name));
     }
  }
}
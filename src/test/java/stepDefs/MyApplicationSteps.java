package stepDefs;

import Pages.MyApplicationPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Configuration;
import utilities.Driver;
import utilities.JDBCUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplicationSteps {
    MyApplicationPage myApplicationPage=new MyApplicationPage();
    Map<String,Object>uiData= new HashMap<String, Object>();
    List<Map<String,Object>>dbData=new ArrayList<>();
    @Given("^naviagate to my application$")
    public void naviagate_to_my_application() throws Throwable {
        Driver.driver.get(Configuration.fileReader("MyApplication"));

    }

    @When("^user gets employee info for employee_id \"([^\"]*)\" from UI$")
    public void userGetsEmployeeInfoForEmployee_idFromUI(String employee_id) throws Throwable {
       int indexofRow=0;
        for(int i=0;i<myApplicationPage.employeesID.size();i++){
           if(myApplicationPage.employeesID.get(i).getText().equalsIgnoreCase(employee_id)){
               indexofRow=i;

           }
       }//for(int i=0;i<4;i++){
            List<WebElement>elements=Driver.driver.findElements(By.xpath("//table//tr["+(indexofRow)+"]//td"));
            uiData.put("first_name",elements.get(0).getText());
            uiData.put("Last_name",elements.get(1).getText());
            uiData.put("job_title",elements.get(3).getText());

        }

        @And("^User gets data for employee_id \"([^\"]*)\" from database$")
    public void userGetsDataForEmployee_idFromDatabase(String employee_id) throws Throwable {
        String query="select e.first_name, e.last_name, j.job_title\n" +
                "from employees e join jobs j on\n" +
                "e.job_id=j.job_id\n" +
                "where employee_id="+employee_id;

        JDBCUtils.establishConnection();
            dbData=JDBCUtils.runSQLQuery(query);



    }

    @Then("^Validate data are matching$")
    public void validate_data_are_matching() throws Throwable {
        Assert.assertEquals(dbData.get(0).get("FIRST_NAME"),uiData.get("first_name"));
        Assert.assertEquals(dbData.get(0).get("LAST_NAME"),uiData.get("last_name"));
        Assert.assertEquals(dbData.get(0).get("JOB_TITLE"),uiData.get("job_title"));
    }
}

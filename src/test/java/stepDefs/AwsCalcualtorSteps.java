package stepDefs;

import Pages.AwsCalculationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.Configuration;
import utilities.Driver;
import utilities.ExcelUtills;

public class AwsCalcualtorSteps {
   AwsCalculationPage awsCalculationPage=new AwsCalculationPage();


    @Given("^user  Navigate to AWS Calculator Homepage$")
    public void user_Navigate_to_AWS_Calculator_Homepage() throws Throwable {
        Driver.driver.get(Configuration.fileReader("awsUrl"));
    }

    @When("^user adds (\\d+) EC(\\d+) Instances$")
    public void user_adds_EC_Instances(int numofInstances, int arg2) throws Throwable {
     awsCalculationPage.ec2InstanceAddButton.click();
     Driver.driver.findElement(By.xpath("(//*[@class=\"cell firstCell\"])[3]")).click();
     Thread.sleep(5000);
    }

    @When("^user adds (\\d+) EC(\\d+) Dedicated Hosts$")
    public void user_adds_EC_Dedicated_Hosts(int arg1, int arg2) throws Throwable {
     Driver.driver.findElement(By.xpath("(//*[@class=\"cell firstCell\"])[6]")).click();
     Driver.driver.findElement(By.xpath("(//*[@class=\"cell firstCell\"])[7]")).click();
     Thread.sleep(2000);
    }

    @Then("^Total estimated cost has to match with prices on \"([^\"]*)\" \"([^\"]*)\"  excel file$")
    public void total_estimated_cost_has_to_match_with_prices_on_excel_file(String excelName, String sheetName) throws Throwable {
  awsCalculationPage.estimateOfMBillPart.click();
  String totalAmount=awsCalculationPage.totalAmount.getAttribute("value");
        System.out.println(totalAmount);
        ExcelUtills.openExcelFIle(excelName,sheetName);
       String ec2Price= ExcelUtills.getValue(1,1);
       double ec2PriceCalculated=Double.parseDouble(ec2Price)*2;
       String ec2Hostes=ExcelUtills.getValue(2,1);
       double ec2Hosts2=Double.parseDouble(ec2Hostes)*2;
       double expectedTotalAmount=ec2PriceCalculated+ec2Hosts2;
        double actualTotalAmount=Double.parseDouble(totalAmount);
        Assert.assertEquals(expectedTotalAmount,actualTotalAmount);



    }
}

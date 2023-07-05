package myApp.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUtils {


    /*
    we use DataProvider cause ;
    ***DataProvider allows you to create more comprehensive test scenarios
    by repeating the same test with different data sets.
    ***This enables testing various inputs and scenarios.
    When there are changes in test scenarios,
    updating the data set can be sufficient.
    **It is easy to update the data set and rerun the tests without
    modifying the test code, ensuring data maintainability.
    */
//    We need 2 methods : ****@DataProvider ***@Test method
//    DATA SOURCE
    @DataProvider
    public Object[][] productListProvider(){
        Object productList[][]={
                {"tesla"},
                {"rivian"},
                {"nio"},
                {"lucid"},
                {"bmw"},
                {"volvo"}
        };
        return productList;
    }
    //    ADDING ONE MORE DATA SOURCE
    @DataProvider(name = "smokeTestProvider")//***name      : used to override the method name
    public Object[][] adminInfoProvider(){
        Object [][]adminInfo = {
                {"admin1", "12345","CEO","LA","60"},
                {"admin2", "41241","CFO","NYC","50"},
                {"admin3", "12356","CMO","LONDON","40"}
        };
        return adminInfo;
    }

    //    TEST CLASS
    @Test(dataProvider = "productListProvider")//NO NEED TO USE  dataProviderClass = Day22_DataProvider2.class WHEN IN THE SAME CLASS
    public void productTest(String data){
//        {"tesla"},{"rivian"},{"nio"},{"lucid"},{"bmw"},{"volvo"}
//        Data provider atomatically loops through the list. In this example Data provider will loops 6 times
        System.out.println(data);
//        DO GOOGLE SEARCH WITH THE DATA THAT COMES FROM THE DATA SOURCE
        Driver.getDriver().get("https://www.google.com");
//        TO HANDLE COOKIES IF YOU HAVE COOKIE USE THIS
        try {
            Driver.getDriver().findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        }catch (Exception e){

        }
//        Type the data in the google search box and clicking ENTER. getting the data from productListProvider
        Driver.getDriver().findElement(By.name("q")).sendKeys(data+ Keys.ENTER);
//        Asserting if title contains the data that is sent
        Assert.assertTrue(Driver.getDriver().getTitle().contains(data));
//        close the driver
        Driver.closeDriver();

    }

    @Test(dataProvider = "smokeTestProvider", groups = "regression1")
    public void adminLoginTest(String userName,String pass,String title,String city, String age){
//        Data provider has 5 paramater therefore I must use 5 parameter in the test method
//        However I don't have to use all of them inside the method body
        System.out.println(userName+" | "+pass+" | ");
    }

    @DataProvider
    public Object[][] customerCredentials(){
//        This is data source
        Object[][] cusomerInfo={
                {"cust1","123",21},
                {"cust2","678",23},
                {"cust3","345",45},
                {"cust4","012",12}
        };
        return cusomerInfo;
    }

    @DataProvider
    public Object[][] cities(){
        Object[][] cities={
                {"Mary","MR","150000"},
                {"Asgabat","AG","30000"},
                {"Balkan","BN","900000"}
        };
        return cities;
    }

//    Data for LogIn Test
    @DataProvider
    public Object[][] customerDataProvider(){
        Object [][] customerInfo={
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
        return customerInfo;
    }

//    This data source will get the data from excel sheet
    @DataProvider
    public Object[][] excelCustomerDataProvider(){
        String path="src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="customer_info";
        ExcelUtils excelUtils=new ExcelUtils(path,sheetName);
        return excelUtils.getDataArrayWithoutFirstRow();

    }
}

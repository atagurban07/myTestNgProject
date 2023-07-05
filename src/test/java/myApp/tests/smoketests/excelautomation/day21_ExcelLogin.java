package myApp.tests.smoketests.excelautomation;

import myApp.pages.RentalHomePage;
import myApp.pages.RentalLoginPage;
import myApp.utilities.*;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class day21_ExcelLogin {
    ExcelUtils excelUtils;
    List<Map<String,String>> dataList;
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;
    @Test
    public void customerLoginTest(){
        String path="src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="customer_info";
        excelUtils=new ExcelUtils(path,sheetName);
        dataList=excelUtils.getDataList();
        //[{password=c!fas_art, username=sam.walker@bluerentalcars.com}, {password=tad1$Fas, username=kate.brown@bluerentalcars.com}, {password=v7Hg_va^, username=raj.khan@bluerentalcars.com}, {password=Nga^g6!, username=pam.raymond@bluerentalcars.com}]
        System.out.println(dataList);
        for (Map<String, String> w : dataList) {
            rentalHomePage = new RentalHomePage();
            rentalLoginPage = new RentalLoginPage();

//        Go to homepage
            Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));

            //Sign In
//        Click on Login
            WaitUtils.waitFor(1);
            rentalHomePage.loginLink.click();

//        Enter email
            WaitUtils.waitFor(1);
            rentalLoginPage.userEmail.sendKeys(w.get("username"));

//        Enter password
            WaitUtils.waitFor(1);
            rentalLoginPage.userPassword.sendKeys(w.get("password"));

//        Click on login
            WaitUtils.waitFor(1);
            rentalLoginPage.submitButton.click();

//        Verify login
            WaitUtils.waitFor(1);
            ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);

            //Sign Out
//        Click on id
            WaitUtils.waitFor(1);
            rentalHomePage.userID.click();

//        Click on logout
            WaitUtils.waitFor(1);
            rentalHomePage.logOut.click();

//        Click on OK
            WaitUtils.waitFor(1);
            rentalHomePage.OK.click();
        }

        Driver.closeDriver();
    }
//        Go to homepage
//        Click on Login
//        Enter email
//        enter password
//        Click on login
//        Verify login
//        Click on Id
//        Click on logout
//        Click on OK
    }
    /*
        Loop This Steps:
        Click on Login
        Enter email
        enter password
        Click on login
        Verify login
        Click on Id
        Click on logout
        Click on OK
    */
/*
    pseudo code:
        Go to homepage
        Click on Login
        Enter email
        enter password
        Click on login
        Verify login
        Click on Id
        Click on logout
        Click on OK

        Click on Login
        Enter email
        enter password
        Click on login
        Verify login
        Click on Id
        Click on logout
        Click on OK

        Click on Login
        Enter email
        enter password
        Click on login
        Verify login
        Click on Id
        Click on logout
        Click on OK

        Click on Login
        Enter email
        enter password
        Click on login
        Verify login
        Click on Id
        Click on logout
        Click on OK
*/


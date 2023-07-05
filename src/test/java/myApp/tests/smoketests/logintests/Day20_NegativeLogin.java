package myApp.tests.smoketests.logintests;

import myApp.pages.RentalHomePage;
import myApp.pages.RentalLoginPage;
import myApp.utilities.ReusableMethods;
import myApp.utilities.ConfigReader;
import myApp.utilities.Driver;
import myApp.utilities.WaitUtils;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Day20_NegativeLogin {

    @Test
    public void US100208_Negative_Login(){
//    As admin or customer,I should be able to see error message,when I don't provide
//      a correct email or password in a pop up
        RentalHomePage rentalHomePage=new RentalHomePage();
        RentalLoginPage rentalLoginPage=new RentalLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();
        rentalLoginPage.userEmail.sendKeys("fake@bluerentalcars.com");
        rentalLoginPage.userPassword.sendKeys("Fakepass");
        rentalLoginPage.submitButton.click();
//        Without waiting,test cases fails because the alert element
        //There are 2 types waits we can use:
        //1st: Hard Wait
        WaitUtils.waitFor(3); //--> This uses hard wait, it is NOT recommended
        //2nd: Explicit Wait
//        WaitUtils.waitForVisibility(rentalLoginPage.errorMessage_incorrectEmailAndPassword,5); //-->This uses explicit wait, it is recommended

//    Error message: User with email fake@bluerentalcars.com not found

        String expectedErrorText="User with email fake@bluerentalcars.com not found";
        String actualErrorText=rentalLoginPage.errorMessage_incorrectEmailAndPassword.getText();
        assertEquals(expectedErrorText,actualErrorText);

        //We can also use a reusable method to do text assertion quicker
        ReusableMethods.verifyExpectedAndActualTextsMatch(expectedErrorText, rentalLoginPage.errorMessage_incorrectEmailAndPassword);

        Driver.closeDriver();
    }
}

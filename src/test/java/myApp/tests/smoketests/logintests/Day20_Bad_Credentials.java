package myApp.tests.smoketests.logintests;

import myApp.pages.RentalHomePage;
import myApp.pages.RentalLoginPage;
import myApp.utilities.ConfigReader;
import myApp.utilities.Driver;
import myApp.utilities.ReusableMethods;
import myApp.utilities.WaitUtils;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Day20_Bad_Credentials {

    @Test
    public void US170208_Bad_Credentials(){
        RentalHomePage rentalHomePage=new RentalHomePage();
        RentalLoginPage rentalLoginPage=new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();
        rentalLoginPage.userEmail.sendKeys("jack@gmail.com");
        rentalLoginPage.userPassword.sendKeys("Fakepass");
        rentalLoginPage.submitButton.click();

        ReusableMethods.verifyExpectedAndActualTextsMatch("Bad credentials", rentalLoginPage.errorMessage_incorrectEmailAndPassword);

        Driver.closeDriver();
    }
}

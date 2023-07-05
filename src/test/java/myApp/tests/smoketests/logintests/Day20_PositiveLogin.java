package myApp.tests.smoketests.logintests;

import myApp.pages.RentalHomePage;
import myApp.pages.RentalLoginPage;
import myApp.utilities.ConfigReader;
import myApp.utilities.Driver;
import myApp.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class Day20_PositiveLogin {
    @Test
    public void US100201_Admin_Login(){
//    As admin,I should be able to log in the application
//    https://www.bluerentalcars.com/
        RentalHomePage rentalHomePage=new RentalHomePage();
        RentalLoginPage rentalLoginPage=new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();
//    Admin email: jack@gmail.com
        rentalLoginPage.userEmail.sendKeys("jack@gmail.com");
//    Admin password: 12345
        rentalLoginPage.userPassword.sendKeys("12345");
        rentalLoginPage.submitButton.click();
        ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);

        Driver.closeDriver();
    }
}

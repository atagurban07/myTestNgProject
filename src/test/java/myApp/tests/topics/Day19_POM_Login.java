package myApp.tests.topics;


    import myApp.pages.OrangeHRMDashboardPage;
    import myApp.pages.OrangeHRMLoginPage;
    import myApp.utilities.ConfigReader;
    import myApp.utilities.Driver;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class Day19_POM_Login {
        //    Create a test case to login the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//    Using page object model
        @Test
        public void loginTest() {
        /*
        1.Locate Page object in Page class
        2.Create page object and call those page objects
        */
            OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
            OrangeHRMDashboardPage orangeHRMDashboardPage=new OrangeHRMDashboardPage();
            Driver.getDriver().get(ConfigReader.getProperty("orange_app_url"));
            orangeHRMLoginPage.username.sendKeys("Admin");
            orangeHRMLoginPage.password.sendKeys("admin123");
            orangeHRMLoginPage.submitButton.click();

//            Verify the login is successful
            Assert.assertTrue(orangeHRMDashboardPage.profile.isDisplayed());
//            Then logout the application
            orangeHRMDashboardPage.profile.click();
            orangeHRMDashboardPage.logout.click();
//            Then verify logout is successful
            String actualUrl=Driver.getDriver().getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("auth"));

//            Close driver
            Driver.closeDriver();
        }
    }

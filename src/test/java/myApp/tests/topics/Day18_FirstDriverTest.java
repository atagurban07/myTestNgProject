package myApp.tests.topics;

import myApp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_FirstDriverTest  {
    @Test
    public void firstDriverTest(){
//        driver.get()
        Driver.getDriver().get("https://www.google.com");
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.toLowerCase().contains("google"));

//        closing driver
        Driver.closeDriver();
    }
}

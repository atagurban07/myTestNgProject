package myApp.tests.topics;

import myApp.utilities.ConfigReader;
import myApp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_FirstConfigTest {
    @Test
    public void firstConfigTest(){
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.toLowerCase().contains(ConfigReader.getProperty("google_title")));
        Driver.closeDriver();
    }
}

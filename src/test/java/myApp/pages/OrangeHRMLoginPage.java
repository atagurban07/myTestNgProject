package myApp.pages;

import myApp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {

//    All page classes must have a constructor to use page factory

    public OrangeHRMLoginPage() {
//        Page factory is used to initiate the objects
//        If we don't use this, we get null pointer exception
        PageFactory.initElements(Driver.getDriver(),this);
    }

//    public WebElement username=driver.findElement(By.name("username"));//Traditional way

//    POM(Page object Model) way
//    @FindBy: used to locate the webElement
    @FindBy(name = "username") public WebElement username;
    @FindBy(xpath = "//input[@type='password']") public WebElement password;
    @FindBy(xpath = "//button[@type='submit']") public WebElement submitButton;


}

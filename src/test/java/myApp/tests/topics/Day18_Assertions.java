package myApp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day18_Assertions {

    @Test
    public void hardAssertion(){
        /*
        Hard assertion will stop if the assertion fails
        */
        System.out.println("Starting the test case");
        Assert.assertTrue(true);//pass so continue
        System.out.println("Line 15 codes");
        Assert.assertEquals(3,4);//Fails so stop and get out of the test method
        System.out.println("Lines 17 codes");//will now execute
    }
    @Test
    public void softAssertions(){
        /*
        Test case will continue to execute EVEN IF A TEST ASSERTION FAIL
        We must use SoftAssert object to do soft assertion.
        assertAll we must be used to do actual assertion.It makes the test case as FAILED IF assertion fails
        */
        System.out.println("Starting the test case");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(true);//pass to continue
        System.out.println("Lines 30 codes");
        softAssert.assertEquals(3,4);//Fails but continue without problem until end of the method
        System.out.println("Line 32 codes");
        softAssert.assertAll("Test case completed");//assertAll must be used at the end to mark the test case as fails
//        System.out.println("Line 34 codes");
    }

    @Test
    public void javaAssertion(){
        /*
        Java assert is like Hard Assertion.This is not used a lot.We should use TestNg assertion in a TestNG framework
        */
        System.out.println("Starting the test case ");
        if(3<=4) throw new AssertionError("Message::");
        assert 3<4;//if the statement is True than continue.if the statement is false THEN THROW java.long.AssertionError
        assert "apple".contains("a");
        assert "Apple".toLowerCase().equals("apple");
        assert 9==9;
        System.out.println("Line 44");
    }
}

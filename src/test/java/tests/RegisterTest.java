package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Register;

public class RegisterTest extends BaseTest{

    Register register;

    @BeforeMethod (alwaysRun = true)
    public void localSetUp(){
        register = new Register(driver);
    }

    @Test (groups = "basic")
    public void registerUserTest(){
        register.goToRegisterPage()
                .fillInAllDataToRegisterUser()
                .clickOnContinueButton();
        softAssert.assertTrue(register.isUserRegistered());
        softAssert.assertTrue(register.isLogoutButtonPresent());
        softAssert.assertAll();
    }
}

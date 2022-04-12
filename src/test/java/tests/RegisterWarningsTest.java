package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Register;

public class RegisterWarningsTest extends BaseTest{


    Register register;

    @BeforeMethod(alwaysRun = true)
    public void localSetUp(){
        register = new Register(driver);
    }

    @Test (groups = "basic")
    @Parameters ({"warningColor"})
    public void registerUserWarningsTest (String warningColor){
        register.goToRegisterPage()
                .clickOnContinueButton();
        softAssert.assertTrue(register.isFirstNameFieldWarningNotificationPresent(warningColor));
        softAssert.assertTrue(register.isLastNameFieldWarningNotificationPresent(warningColor));
        softAssert.assertTrue(register.isEmailFieldWarningNotificationPresent(warningColor));
        softAssert.assertTrue(register.isTelephoneFieldWarningNotificationPresent(warningColor));
        softAssert.assertTrue(register.isPasswordFieldWarningNotificationPresent(warningColor));
        softAssert.assertTrue(register.isEmptyPrivacyPolicyWarningPresent(warningColor));
        softAssert.assertAll();
    }


}

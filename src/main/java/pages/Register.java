package pages;

import model.RegisterUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends BasePage{

    private By myAccountNavBar = By.cssSelector("a[title='My Account']");
    private By navbarRegisterOption = By.xpath("//a[text()='Register']");
    private By firstNameField = By.cssSelector("#input-firstname");
    private By lastNameField = By.cssSelector("#input-lastname");
    private By emailField = By.cssSelector("#input-email");
    private By telephoneField = By.cssSelector("#input-telephone");
    private By passwordField = By.cssSelector("#input-password");
    private By confirmPasswordField = By.cssSelector("#input-confirm");
    private By privacyPolicyCheckbox = By.cssSelector("input[name='agree']");
    private By continueButton = By.cssSelector("input[type='submit']");
    private By successMessage = By.xpath("//div[@id='content']/h1");
    private By logoutButton = By.xpath("//div[@class='list-group']//a[text()='Logout']");


    private By firstNameFieldWarningMessage = By.xpath("//input[@id='input-firstname']/../div[@class='text-danger']");
    private By lastNameFieldWarningMessage = By.xpath("//input[@id='input-lastname']/../div[@class='text-danger']");
    private By emailFieldWarningMessage = By.xpath("//input[@id='input-email']/../div[@class='text-danger']");
    private By telephoneFieldWarningMessage = By.xpath("//input[@id='input-telephone']/../div[@class='text-danger']");
    private By passwordFieldWarningMessage = By.xpath("//input[@id='input-password']/../div[@class='text-danger']");
    private By uncheckedPrivacyPolicyWarningMessage = By.xpath("//div[contains (@class, 'alert')]");

    private String warningMessageColorCssAttribute = "color";





    public Register(WebDriver driver) {
        super(driver);
    }

    public Register goToRegisterPage(){
        clickOnElement(myAccountNavBar);
        clickOnElement(navbarRegisterOption);
        return this;
    }

    public Register fillInAllDataToRegisterUser() {
        RegisterUser user = new RegisterUser();
        typeIn(firstNameField, user.getFirstName());
        typeIn(lastNameField, user.getLastName());
        typeIn(emailField, user.getEmail());
        typeIn(telephoneField, user.getPhoneNumber());
        typeIn(passwordField, user.getPassword());
        typeIn(confirmPasswordField, user.getPassword());
        clickOnElement(privacyPolicyCheckbox);
        return this;
    }

    public Register clickOnContinueButton(){
        clickOnElement(continueButton);
        return this;
    }

    public boolean isUserRegistered(){
        String expectedSuccessText = "Your Account Has Been Created!";
        return  matchesExpectedText(successMessage, expectedSuccessText); //  umesto return getTextFromElement(successMessage).equals(expectedSuccessText);

    }

    public boolean isLogoutButtonPresent(){

        return isElementDisplayed(logoutButton);

    }

    public boolean isFirstNameFieldWarningNotificationPresent(String warningTextColor){
        String expectedWarningText = "First Name must be between 1 and 32 characters!";
        return matchesExpectedText(firstNameFieldWarningMessage, expectedWarningText)
                && matchesExpectedColor(firstNameFieldWarningMessage, warningMessageColorCssAttribute, warningTextColor);
    }

    public boolean isLastNameFieldWarningNotificationPresent(String warningTextColor){
        String expectedWarningText = "Last Name must be between 1 and 32 characters!";
        return matchesExpectedText(lastNameFieldWarningMessage, expectedWarningText)
                && matchesExpectedColor(lastNameFieldWarningMessage, warningMessageColorCssAttribute, warningTextColor);
    }

    public boolean isEmailFieldWarningNotificationPresent(String warningTextColor){
        String expectedWarningText = "E-Mail Address does not appear to be valid!";
        return matchesExpectedText(emailFieldWarningMessage, expectedWarningText)
                && matchesExpectedColor(emailFieldWarningMessage, warningMessageColorCssAttribute, warningTextColor);
    }

    public boolean isTelephoneFieldWarningNotificationPresent(String warningTextColor){
        String expectedWarningText = "Telephone must be between 3 and 32 characters!";
        return matchesExpectedText(telephoneFieldWarningMessage, expectedWarningText)
                && matchesExpectedColor(telephoneFieldWarningMessage, warningMessageColorCssAttribute, warningTextColor);
    }

    public boolean isPasswordFieldWarningNotificationPresent(String warningTextColor){
        String expectedWarningText = "Password must be between 4 and 20 characters!";
        return matchesExpectedText(passwordFieldWarningMessage, expectedWarningText)
                && matchesExpectedColor(passwordFieldWarningMessage, warningMessageColorCssAttribute, warningTextColor);
    }

    public boolean isEmptyPrivacyPolicyWarningPresent(String warningTextColor){
        String expectedWarningText = "Warning: You must agree to the Privacy Policy!";
        return matchesExpectedText(uncheckedPrivacyPolicyWarningMessage, expectedWarningText)
                && matchesExpectedColor(uncheckedPrivacyPolicyWarningMessage, warningMessageColorCssAttribute, warningTextColor);
    }


}

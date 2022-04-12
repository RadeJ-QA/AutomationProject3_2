package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    protected WebElement getElement(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator)); // provera na svakih 500ms ->pooling
//        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    protected void typeIn(By locator, String text){
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clickOnElement (By locator){

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    protected String getTextFromElement(By locator){

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();

    }

    protected boolean isElementDisplayed (By locator){
        boolean isElementVisible = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed(); // za isDisplayed elementi moraju obavezno da se čekaju
        if (isElementVisible){
            System.out.println("PASSED --- Element je prisutan!!!");
            return true;
        } else {
            System.out.println("PASSED --- Element nije prisutan!!!");
        }
        return false;

    }

    protected boolean matchesExpectedText (By locator, String expectedText){

        WebElement element = getElement(locator);
        if (element.getText().trim().equals(expectedText)){
            System.out.println("Text u elementu: "+ element.getText() + " je jednak ocekivanom tekstu.");
            return true;
        } else {
            System.out.println("Text u elementu: "+ element.getText() + " nije jednak ocekivanom tekstu!!!");
        }
        return false;

    }


    protected double getAmountByRegex(String value){

        return Double.parseDouble(value.replaceAll("[\\D]", ""))/100;
    }

    protected String getElementsColor (By locator, String cssColorAttributeName){

        return getElement(locator).getCssValue(cssColorAttributeName);
    }

    protected boolean matchesExpectedColor (By locator, String cssAttributeName, String expectedColor){

        if (getElementsColor(locator, cssAttributeName).equals(expectedColor)){
            System.out.println("Boja " + cssAttributeName + " attributa elementa: " + getElementsColor(locator, cssAttributeName) + " je jednaka ocekivanoj boji.") ;
            return true;
        }else {
            System.out.println("Boja " + cssAttributeName + " attributa elementa: " + getElementsColor(locator, cssAttributeName) + " nije jednaka ocekivanoj boji!!!");
        }
        return false;

    }





}

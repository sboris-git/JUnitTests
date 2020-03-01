package pages;

import org.openqa.selenium.By;
import utils.SeleniumWrapper;

public class LoginPage {

    //private WebDriver driver;
    private SeleniumWrapper seleniumWrapper;
    private String text;

    // Constructor
    public LoginPage(SeleniumWrapper seleniumWrapper) {

        this.seleniumWrapper = seleniumWrapper;
        this.text = text;
    }

    // Web Elements Locators
    By usernameBy = By.name("email");
    By passwordBy = By.name("password");
    By loginButtonBy = By.cssSelector("button[value=\"Login\"]");
    By signInButtonBy = By.cssSelector(".mt-5");
    public static final By errorMessageUsernameBy = By.cssSelector("p[class*=\"MuiFormHelperText-filled\"]");
    //Required
    public static final By errorMessagePasswordBy = By.cssSelector("p[class=\"MuiFormHelperText-root Mui-error\"]");
    //Password:
    public static final By errorMessagePasswordHelpBy = By.cssSelector("input[name=\"password\"]");
    //Invalid password
    public static final By wrongPasswordMessageBy = By.cssSelector("p[class*=\"text-danger\"");

    // Page Data
    String baseURL = "http://34.65.101.58:5002/home/events/?page=1";

    // Page Methods
    //Go to Homepage
    public LoginPage goToHomePage(){
        seleniumWrapper.getDriver().get(baseURL);
        return this;
    }

    // Go to Login Page
    public LoginPage clickSignInButton (){
        seleniumWrapper.click(signInButtonBy);
        return this;
    }

    // Do login
    public LoginPage doLogin(String username, String password){
        //Enter Username(Email)
        seleniumWrapper.writeText(usernameBy,username);
        //Enter Password
        seleniumWrapper.writeText(passwordBy, password);
        //Click Login Button
        seleniumWrapper.click(loginButtonBy);
        return this;
    }
    // Read test from element
    public LoginPage getText(By elementBy) {
        this.text = seleniumWrapper.readText(elementBy);
        return this;
    }
    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
        seleniumWrapper.assertEquals(errorMessageUsernameBy, expectedText);
    }
    //Verify Username Condition by assertJ
    public void verifyLoginUserNameAssertJ (String expectedText) {
        seleniumWrapper.assertEqualsAssertJ(errorMessageUsernameBy, expectedText);
    }

    //Verify Password Condition - Invalid password
    public void verifyLoginWrongPasswordMsg (String expectedText) {
        seleniumWrapper.assertEquals(wrongPasswordMessageBy, expectedText);
    }
    //Verify Password Condition by assertJ - Invalid password
    public void verifyLoginWrongPasswordMsgAssertJ (String expectedText) {
        seleniumWrapper.assertEqualsAssertJ(wrongPasswordMessageBy, expectedText);
    }

    //Verify Blank Password Type - Required
    public void verifyLoginErrorPasswordMsg (String expectedText) {
        seleniumWrapper.assertEquals(errorMessagePasswordBy, expectedText);
    }

    //Verify Blank Password Type Help Notation - Password:
    public void verifyLoginErrBlankPasswordHelpMsg (String expectedText) {
        seleniumWrapper.assertEquals(errorMessagePasswordHelpBy, expectedText);
    }
}

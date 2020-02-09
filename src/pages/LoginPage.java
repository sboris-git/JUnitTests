package pages;

import org.openqa.selenium.By;

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
    public static final By errorMessagePasswordBy = By.cssSelector("p[class=\"MuiFormHelperText-root Mui-error\"]");

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
    public LoginPage verifyLoginUserName (String expectedText) {
        seleniumWrapper.assertEquals(errorMessageUsernameBy, expectedText);
        return this;
    }

    //Verify Password Condition
    public LoginPage verifyLoginPassword (String expectedText) {
        seleniumWrapper.assertEquals(errorMessagePasswordBy, expectedText);
        return this;
    }
}

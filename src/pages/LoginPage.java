package pages;

import org.openqa.selenium.By;

public class LoginPage {

    //private WebDriver driver;
    private BasePage page;

    // Constructor
    public LoginPage(BasePage page) {
        this.page = page;
    }

    // Web Elements Locators
    By usernameBy = By.name("email");
    By passwordBy = By.name("password");
    By loginButtonBy = By.cssSelector("button[value=\"Login\"]");
    By errorMessageUsernameBy = By.cssSelector("p[class*=\"MuiFormHelperText-filled\"]");
    By errorMessagePasswordBy = By.cssSelector("p[class=\"MuiFormHelperText-root Mui-error\"]");
    By signInButtonBy = By.cssSelector(".mt-5");

    // Page Data
    String baseURL = "http://34.65.101.58:5002/home/events/?page=1";

    // Page Methods
    //Go to Homepage
    public LoginPage goToHomePage(){
        page.driver.get(baseURL);
        return this;
    }

    // Go to Login Page
    public LoginPage clickSignInButton (){
        page.click(signInButtonBy);
        return this;
    }

    // Do login
    public LoginPage doLogin(String username, String password){
        //Enter Username(Email)
        page.writeText(usernameBy,username);
        //Enter Password
        page.writeText(passwordBy, password);
        //Click Login Button
        page.click(loginButtonBy);
        return this;
    }

    //Verify Username Condition
    public LoginPage verifyLoginUserName (String expectedText) {
        page.assertEquals(errorMessageUsernameBy, expectedText);
        return this;
    }

    //Verify Password Condition
    public LoginPage verifyLoginPassword (String expectedText) {
        page.assertEquals(errorMessagePasswordBy, expectedText);
        return this;
    }
}

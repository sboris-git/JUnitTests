package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SeleniumWrapper;
import pages.LoginPage;
import pages.PageObj;

import static data.Creds.*;

public class TestsNegative {

    private PageObj pageObj;

    @Before
    public void setUp() {
        //Create a Chrome driver. All tests use this.
        System.setProperty("webdriver.chrome.driver", "/home/stable/IdeaProjects/libs/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Declare objects
        SeleniumWrapper seleniumWrapper = new SeleniumWrapper(driver);
        LoginPage loginPage = new LoginPage(seleniumWrapper);
        // Instantiate Page Object instance
        pageObj = new PageObj(driver, seleniumWrapper, loginPage);
    }

    @Test
    public void testUserName() {

        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, USERPASSWORD)
                .verifyLoginUserName("Invalid email address");
    }

    @Test
    public void testNoPassword() {
        //Check for blank edit box
        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, "")
                .verifyLoginErrorPasswordMsg("Required");
    }

    @Test
    public void testNoPasswordHelp() {
        //Check for blank edit box
        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, "")
                .verifyLoginErrBlankPasswordHelpMsg("Password:");
    }

    @Ignore("it doesn't display error message below Selenium WebDriver")
    @Test
    public void testWrongPassword() {
        //Verify error text "Invalid password" displayed under password text box
        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, USERPASSWORD)
                .verifyLoginWrongPasswordMsg("Invalid password");
    }

    @After
    public void tearDown() {
        pageObj.getDriver().quit();
    }

}

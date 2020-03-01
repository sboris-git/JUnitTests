package tests;

// entry point for all assertThat methods and utility methods (e.g. entry)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PageObj;
import utils.SeleniumWrapper;

import static data.Creds.USERNAME;
import static data.Creds.USERPASSWORD;
import static org.assertj.core.api.Assertions.*;

public class TestNGassertJ {
    private PageObj pageObj;

    @BeforeTest
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
        // Verify error message display on wrong e-mail typed
        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, USERPASSWORD)
                .verifyLoginUserNameAssertJ("Invalid email address");
    }

    @Test
    public void testNoPassword() {
        //Check for blank edit box - fails ToDo
        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, "")
                .verifyLoginWrongPasswordMsgAssertJ("Required");
    }

    @Test
    public void testNoPasswordHelp() {
        //Check for blank edit box - fails ToDo
        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, "")
                .verifyLoginErrBlankPasswordHelpMsg("Password:");
    }

    //@Ignore("it doesn't display error message under Selenium WebDriver")
    @Test(enabled = false)
    public void testWrongPassword() {
        //Verify error text "Invalid password" displayed under password text box
        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, USERPASSWORD)
                .verifyLoginWrongPasswordMsg("Invalid password");
    }

    @AfterTest
    public void tearDown() {
        pageObj.getDriver().quit();
    }
}

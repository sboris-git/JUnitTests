package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SeleniumWrapper;
import pages.LoginPage;
import pages.PageObj;

import static data.Creds.*;

public class Tests {

    private PageObj pageObj;

    @Before
    public void setUp() {
        //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.chrome.driver", "/home/stable/IdeaProjects/libs/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
        SeleniumWrapper seleniumWrapper = new SeleniumWrapper(driver);
        LoginPage loginPage = new LoginPage(seleniumWrapper);
        pageObj = new PageObj(driver, seleniumWrapper, loginPage);
    }

    @Test
    public void testUserNamePositive() {

        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, USERPASSWORD)
                .verifyLoginUserName("Invalid email address");
                //.verifyLoginPassword(""); css = input[placeholder="Password:"] the text is "Password:"
    }
    @Test
    public void testPasswordPositive() {

        pageObj.getLoginPage()
                .goToHomePage()
                .clickSignInButton()
                .doLogin(USERNAME, USERPASSWORD)
//                .verifyLoginUserName(errorMessageUsernameBy,"Invalid email address");
                .verifyLoginPassword(""); // css = input[placeholder="Password:"] the text is "Password:"
    }

    @After
    public void tearDown() {
        pageObj.getDriver().quit();
    }

}

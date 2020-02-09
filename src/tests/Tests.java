package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.PageObj;
import pages.WebBrowserDriver;

import static data.Creds.*;


public class Tests {
    public static void main(String[] args) {

//        @BeforeClass
//        public void setup() {
//       //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.chrome.driver", "/home/stable/IdeaProjects/junit/lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Maximize Window
//          driver.manage().window().maximize();
        WebBrowserDriver theDriver = new WebBrowserDriver("Chrome");
        BasePage page = new BasePage(driver);
        LoginPage loginPage = new LoginPage(page);
        PageObj thePage = new PageObj(theDriver, page, loginPage);
//        }
//        thePage.getTheDriver().setDriver();
//        thePage.getLoginPage().verifyLoginPassword();
//        thePage.getLoginPage()
//                .goToHomePage()
//                .clickSignInButton();

        thePage.getLoginPage().goToHomePage().clickSignInButton().doLogin(USERNAME, USERPASSWORD);
//        thePage.getTheDriver().getDriver().close();
        thePage.getPage().driver.close();


//        loginPage.goToHomePage();
//        loginPage.clickSignInButton();
//        loginPage.doLogin(USERNAME, USERPASSWORD);

//        page.driver.close();

    }

//    @AfterClass
//    public void teardown(BasePage page) {
//
//        page.driver.close();
//    }
}

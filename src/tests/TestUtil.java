package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.PageObj;
import pages.SeleniumWrapper;

public class TestUtil {

    private WebDriver driver;
    public PageObj pageObj;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.chrome.driver", "/home/stable/IdeaProjects/libs/chromedriver");
        driver = new ChromeDriver();
        //Maximize Window
//          driver.manage().window().maximize();
        SeleniumWrapper seleniumWrapper = new SeleniumWrapper(driver);
        loginPage = new LoginPage(seleniumWrapper);
        pageObj = new PageObj(driver, seleniumWrapper, loginPage);
    }

    @After
    public void tearDown() {
        pageObj.getDriver().quit();
    }
}

package utils;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.PageObj;


public class TestUtil {
    // Not yet implemented

    public PageObj pageObj;

    @BeforeMethod
    public void setUp() {
        //Create a Chrome driver.
        System.setProperty("webdriver.chrome.driver", "/home/stable/IdeaProjects/libs/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Maximize Window
//          driver.manage().window().maximize();
        SeleniumWrapper seleniumWrapper = new SeleniumWrapper(driver);
        LoginPage loginPage = new LoginPage(seleniumWrapper);
        pageObj = new PageObj(driver, seleniumWrapper, loginPage);
    }

    @AfterMethod
    public void tearDown() {
        pageObj.getDriver().quit();
    }
}

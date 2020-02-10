package pages;

import org.openqa.selenium.WebDriver;
import utils.SeleniumWrapper;

public class PageObj {

    private WebDriver driver;
    private SeleniumWrapper seleniumWrapper;
    private LoginPage loginPage;

    // Constructor
    public PageObj(WebDriver driver, SeleniumWrapper seleniumWrapper, LoginPage loginPage) {
        this.driver = driver;
        this.seleniumWrapper = seleniumWrapper;
        this.loginPage = loginPage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public SeleniumWrapper getSeleniumWrapper() {
        return seleniumWrapper;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
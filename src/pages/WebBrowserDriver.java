package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowserDriver {

    private String browserName;
    private WebDriver driver;

    // Constructor
    public WebBrowserDriver(String browserName) {
        this.browserName = browserName;
//        this.driver = driver;
        //WebDriverWait wait = new WebDriverWait(driver, 15);
    }

    // Set instance of a WebDriver
    public WebDriver setDriver() {
        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/stable/IdeaProjects/junit/lib/chromedriver");
            this.driver = new ChromeDriver();
        }
        return driver;
    }

    // Set instance of a WebDriver
    public WebDriver getDriver() {
            return driver;
    }
//    }

        // Close instance of a WebDriver
//    public void setDriver(WebDriver driver) {
//        driver.close();
//    }
}

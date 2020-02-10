package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebBrowserDriver {
    private WebDriver driver;

    // Set instance of a WebDriver
    public org.openqa.selenium.WebDriver setDriver() {
            System.setProperty("webdriver.chrome.driver", "/home/stable/IdeaProjects/junit/lib/chromedriver");
            this.driver = new ChromeDriver();
            this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }
}

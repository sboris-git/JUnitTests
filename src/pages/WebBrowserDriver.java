package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowserDriver {

    private org.openqa.selenium.WebDriver driver;

    // Set instance of a WebDriver
    public org.openqa.selenium.WebDriver setDriver() {
            System.setProperty("webdriver.chrome.driver", "/home/stable/IdeaProjects/junit/lib/chromedriver");
            this.driver = new ChromeDriver();
        return driver;
    }
}

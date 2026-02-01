package utils;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver createDriver() {
        WebDriver driver;

        switch (Config.BROWSER) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(Config.IMPLICIT_WAIT));
        return driver;
    }
}

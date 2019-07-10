package herokuapptests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static Browser browser;
    private WebDriver driver;

    private Browser() {

    }

    public static Browser getInstance() {
        if (browser == null) {
            init();
        }
        return browser;
    }

    private static void init() {
        browser = new Browser();
        browser.initDriver();
    }

    WebDriver getDriver() {
        return driver;
    }

    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver reinitBrowser() {
        driver.close();
        initDriver();
        return driver;
    }
}

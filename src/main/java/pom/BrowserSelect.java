package pom;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserSelect extends ExternalResource {
    private WebDriver driver;

    private ChromeOptions options =  new ChromeOptions();

    private String YANDEX_DRIVER_PATH = "/usr/local/chromedriver/yandexdriver";
    private String CHROME_DRIVER_PATH = "/usr/local/chromedriver/chromedriver";
    private String YANDEX_BROWSER_PATH = "/Applications/Yandex.app/Contents/MacOS/Yandex";


    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() {

        String browser = System.getenv("browser");

        if ("ya".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER_PATH);
            options.setBinary(YANDEX_BROWSER_PATH);
            driver = new ChromeDriver(options);
        } else {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Override
    protected void after() {
        driver.quit();
    }
}

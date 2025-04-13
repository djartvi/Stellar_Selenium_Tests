package pom;

import lombok.Getter;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.logging.Logger;

@Getter
public class BrowserSelect implements BeforeEachCallback, AfterEachCallback {

    private WebDriver driver;

    private static final String YANDEX_DRIVER_PATH = "/usr/local/chromedriver/yandexdriver";
    private static final String CHROME_DRIVER_PATH = "/Users/alex/Desktop/chromedriver/chromedriver";
    private static final String YANDEX_BROWSER_PATH = "/Applications/Yandex.app/Contents/MacOS/Yandex";

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {

        ChromeOptions options =  new ChromeOptions();

//      options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        String browser = System.getProperty("browser");
        String path = null;

        if (browser.equals("yandex")) {
            path = YANDEX_BROWSER_PATH;
            options.setBinary(path);
        } else if (browser.equals("chrome")) {
            path = CHROME_DRIVER_PATH;
        }

//        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        driver.quit();
    }
}

package pom;

import lombok.Getter;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserSelect extends ExternalResource {

    @Getter
    private WebDriver driver;

    private static final String YANDEX_DRIVER_PATH = "/usr/local/chromedriver/yandexdriver";
    private static final String CHROME_DRIVER_PATH = "/usr/local/chromedriver/chromedriver";
    private static final String YANDEX_BROWSER_PATH = "/Applications/Yandex.app/Contents/MacOS/Yandex";

    @Override
    protected void before() {
        ChromeOptions chromeOptions =  new ChromeOptions()
                .addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        String browser = System.getProperty("browser");

        if ("yandex".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER_PATH);

            chromeOptions.setBinary(YANDEX_BROWSER_PATH);

            driver = new ChromeDriver(chromeOptions);
        } else if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Override
    protected void after() {
        driver.quit();
    }
}

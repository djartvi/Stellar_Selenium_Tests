package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    private final By cabinetButton = By.xpath("//*[text()='Личный Кабинет']");
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By bunsButton = By.xpath("//*[contains(@class, 'tab_tab')]/*[text()='Булки']");
    private final By sousesButton = By.xpath("//*[contains(@class, 'tab_tab')]/*[text()='Соусы']");
    private final By filingsButton = By.xpath("//*[contains(@class, 'tab_tab')]/*[text()='Начинки']");
    private final By containerBuns = By.xpath("//*[contains(@class, 'menuContainer')]/*[text()='Булки']");
    private final By containerSouses = By.xpath("//*[contains(@class, 'menuContainer')]/*[text()='Соусы']");
    private final By containerFilings = By.xpath("//*[contains(@class, 'menuContainer')]/*[text()='Начинки']");
    private final By constructor = By.xpath("//*[text()='Соберите бургер']");
    private final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open page " + URL)
    public MainPage open() {
        driver.get(URL);
        return this;
    }

    public static String getURL() {
        return URL;
    }

    public By getContainerBuns() {
        return containerBuns;
    }

    public By getContainerSouses() {
        return containerSouses;
    }

    public By getContainerFilings() {
        return containerFilings;
    }

    @Step("Click account button in header")
    public void clickAccountButton() {
        driver.findElement(cabinetButton).click();
    }

    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Select buns in constructor")
    public MainPage clickBunsButton() {
        driver.findElement(bunsButton).click();
        return this;
    }

    @Step("Select souses in constructor")
    public MainPage clickSousesButton() {
        driver.findElement(sousesButton).click();
        return this;
    }

    @Step("Select filings in constructor")
    public MainPage clickFilingsButton() {
        driver.findElement(filingsButton).click();
        return this;
    }

    @Step("Get Y coordinate of first visible ingredient in constructor")
    public int getElementLocation(By element) throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(element).getLocation().getY();
    }

    @Step("Check visibility of constructor on main page")
    public boolean isDisplayed() {
        return driver.findElements(constructor).size() > 0;
    }

    @Step("Check visibility of main page for registered user")
    public boolean registeredView() {
        return driver.findElements(makeOrderButton).size() > 0;
    }
}

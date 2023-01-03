package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    private By shopLogo = By.xpath("//*[@class='http://www.w3.org/2000/svg']");
    private By cabinetButton = By.xpath("//*[text()='Личный Кабинет']");
    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By bunsButton = By.xpath("//*[contains(@class, 'tab_tab')]/*[text()='Булки']");
    private By sousesButton = By.xpath("//*[contains(@class, 'tab_tab')]/*[text()='Соусы']");
    private By filingsButton = By.xpath("//*[contains(@class, 'tab_tab')]/*[text()='Начинки']");
    private By containerBuns = By.xpath("//*[contains(@class, 'menuContainer')]/*[text()='Булки']");
    private By containerSouses = By.xpath("//*[contains(@class, 'menuContainer')]/*[text()='Соусы']");
    private By containerFilings = By.xpath("//*[contains(@class, 'menuContainer')]/*[text()='Начинки']");
    private By constructor = By.xpath("//*[text()='Соберите бургер']");
    private By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

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

    public void clickShopLogo() {
        driver.findElement(shopLogo).click();
    }

    public void clickAccountButton() {
        driver.findElement(cabinetButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public MainPage clickBunsButton() {
        driver.findElement(bunsButton).click();
        return this;
    }

    public MainPage clickSousesButton() {
        driver.findElement(sousesButton).click();
        return this;
    }

    public MainPage clickFilingsButton() {
        driver.findElement(filingsButton).click();
        return this;
    }

    public int getElementLocation(By element) throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(element).getLocation().getY();
    }

    public boolean isDisplayed() {
        return driver.findElements(constructor).size() > 0;
    }

    public boolean registeredView() {
        return driver.findElements(makeOrderButton).size() > 0;
    }
}

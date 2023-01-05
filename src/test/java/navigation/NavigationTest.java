package navigation;

import credentials.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

import static org.junit.Assert.assertTrue;

public class NavigationTest {
    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private MainPage mainPage;
    private LoginPage loginPage;

    @Before
    public void openMainPage() {
        mainPage = new MainPage(browserSelect.getDriver());
        loginPage = new LoginPage(browserSelect.getDriver());

        mainPage.open();
    }

    @Test
    @DisplayName("Check navigation to constructor from login page")
    public void goToConstructorTest() {
        mainPage.clickAccountButton();

        loginPage.clickConstructor();

        assertTrue(mainPage.isDisplayed());
    }

    @Test
    @DisplayName("Check navigation to constructor from logo")
    public void goToConstructorFromLogoTest() {
        mainPage.clickAccountButton();

        loginPage.clickLogo();

        assertTrue(mainPage.isDisplayed());
    }

    @Test
    @DisplayName("Check navigation to login page")
    @Description("User is unregistered")
    public void goToAccountPage() {
        mainPage.clickAccountButton();

        assertTrue(loginPage.isDisplayed());
    }

    @Test
    @DisplayName("Check navigation to account")
    @Description("User is logged in")
    public void goToAccountUserLoggedIn() {
        loginPage = new LoginPage(browserSelect.getDriver());
        AccountPage accountPage = new AccountPage(browserSelect.getDriver());
        RegisterPage registerPage = new RegisterPage(browserSelect.getDriver());
        User user = User.randomUser();

        mainPage
                .open()
                .clickAccountButton();

        loginPage
                .scrollToRegister()
                .clickRegister();

        registerPage
                .registerUser(user)
                .waitRegistration();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        mainPage.clickAccountButton();

        assertTrue(accountPage.isDisplayed());
    }
}

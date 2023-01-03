package Navigation;

import credentials.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

import static org.junit.Assert.assertTrue;

public class Navigation {
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
    public void goToConstructorTest() {
        mainPage.clickAccountButton();

        loginPage.clickConstructor();

        assertTrue(mainPage.isDisplayed());
    }

    @Test
    public void goToAccountPage() {
        mainPage.clickAccountButton();

        assertTrue(loginPage.isDisplayed());
    }

    @Test
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

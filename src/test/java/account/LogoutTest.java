package account;

import credentials.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

import static org.junit.Assert.assertTrue;

public class LogoutTest {
    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private MainPage mainPage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Before
    public void registerUser() {
        mainPage = new MainPage(browserSelect.getDriver());
        loginPage = new LoginPage(browserSelect.getDriver());
        accountPage = new AccountPage(browserSelect.getDriver());
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
    }

    @Test
    public void logoutTest() {
        mainPage
                .clickAccountButton();

        accountPage
                .clickLogoutButton();

        assertTrue(loginPage.isDisplayed());
    }

}

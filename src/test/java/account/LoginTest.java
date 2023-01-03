package account;

import credentials.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private User user;

    @Before
    public void registerUser() {
        mainPage = new MainPage(browserSelect.getDriver());
        loginPage = new LoginPage(browserSelect.getDriver());
        registerPage = new RegisterPage(browserSelect.getDriver());
        user = User.randomUser();

        mainPage
                .open()
                .clickAccountButton();

        loginPage
                .scrollToRegister()
                .clickRegister();

        registerPage
                .registerUser(user);
    }

    @Test
    public void loginFromLoginButtonTest() {
        mainPage
                .open()
                .clickLoginButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }

    @Test
    public void loginFromAccountButtonTest() {
        mainPage
                .open()
                .clickAccountButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }

    @Test
    public void loginFromRegisterPageTest() {

        loginPage
                .scrollToRegister()
                .clickRegister();

        registerPage
                .scrollToLoginButton()
                .clickLoginButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }

    @Test
    public void loginFromPasswordRecoveryPageTest() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(browserSelect.getDriver());

        loginPage
                .scrollToPasswordRecovery()
                .clickPasswordRecoveryButton();

        passwordRecoveryPage
                .clickLoginButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }
}

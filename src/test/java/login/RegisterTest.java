package login;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.BrowserSelect;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterTest {
    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private RegisterPage registerPage;

    @Before
    public void goToRegisterPage() {
        MainPage mainPage = new MainPage(browserSelect.getDriver());
        LoginPage loginPage = new LoginPage(browserSelect.getDriver());
        registerPage = new RegisterPage(browserSelect.getDriver());

        mainPage
                .open()
                .clickAccountButton();

        loginPage
                .scrollToRegister()
                .clickRegister();
    }

    @Test
    public void registerTest() {
        registerPage.registerRandomUser(6);

        assertTrue(registerPage.isRegistered());
    }

    @Test
    public void wrongPasswordTestTest() {
        registerPage.registerRandomUser(5);

        assertTrue(registerPage.isWrongPassword());
    }
}

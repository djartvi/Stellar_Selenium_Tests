package account;

import api.Token;
import api.UserClient;
import credentials.User;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
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
    private Response login;

    private final UserClient userClient = new UserClient();
    private final User user = User.randomUser();
    private final Token token = new Token();

    @Before
    public void loginUser() throws InterruptedException {

        mainPage = new MainPage(browserSelect.getDriver());
        loginPage = new LoginPage(browserSelect.getDriver());
        accountPage = new AccountPage(browserSelect.getDriver());

        mainPage.open();

        userClient.register(user);
        login = userClient.login(user);
        token.storeTokens(browserSelect.getDriver(), login);
    }

    @Test
    @DisplayName("Check user logout")
    public void logoutTest() {

        mainPage.clickAccountButton();

        accountPage.clickLogoutButton();

        assertTrue(loginPage.isDisplayed());
    }

    @After
    public void deleteUser() throws InterruptedException {
        userClient.getTokenAndDeleteUser(login);
    }
}

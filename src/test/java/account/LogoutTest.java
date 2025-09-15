package account;

import api.Token;
import api.UserClient;
import base.BaseTest;
import credentials.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pom.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private Response login;

    private final UserClient userClient = new UserClient();
    private final User user = new User().randomUser();
    private final Token token = new Token();

    @BeforeEach
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

    @AfterEach
    @DisplayName("Delete user")
    public void deleteUser() throws InterruptedException {
        userClient.getTokenAndDeleteUser(login);
    }
}

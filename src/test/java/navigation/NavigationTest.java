package navigation;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pom.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeEach
    public void openMainPage() {

        mainPage = new MainPage(browserSelect.getDriver());
        loginPage = new LoginPage(browserSelect.getDriver());
    }

    @Test
    @DisplayName("Check navigation to login page")
    @Description("User is unregistered")
    public void goToAccountPage() {

        mainPage
                .open()
                .clickAccountButton();

        assertTrue(loginPage.isDisplayed());
    }
}

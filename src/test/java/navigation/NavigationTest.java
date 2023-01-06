package navigation;

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

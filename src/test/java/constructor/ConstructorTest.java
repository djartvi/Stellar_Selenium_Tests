package constructor;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pom.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void openMainPage() {

        mainPage = new MainPage(browserSelect.getDriver());

        mainPage.open();
    }

    @Test
    @DisplayName("Check buttons switching in constructor section")
    public void constructorButtonsTest() throws InterruptedException {

        int sousesY = mainPage
                .clickSousesButton()
                .getElementLocation(mainPage.getContainerSouses());

        int filingsY = mainPage
                .clickFilingsButton()
                .getElementLocation(mainPage.getContainerFilings());

        int bunsY = mainPage
                .clickBunsButton()
                .getElementLocation(mainPage.getContainerBuns());

        assertTrue(sousesY==filingsY && sousesY==bunsY);
    }

    @Test
    @DisplayName("Check manual scrolling in constructor section")
    public void constructorScrollingTest() {

        mainPage.scrollToElement(mainPage.getContainerBuns());
        boolean isBunsButtonActive = mainPage.isActiveButton(mainPage.getBunsButton());

        mainPage.scrollToElement(mainPage.getContainerSouses());
        boolean isSousesButtonActive = mainPage.isActiveButton(mainPage.getSousesButton());

        mainPage.scrollToElement(mainPage.getContainerFilings());
        boolean isFilingsButtonActive = mainPage.isActiveButton(mainPage.getFilingsButton());

        assertTrue(isBunsButtonActive && isSousesButtonActive && isFilingsButtonActive);
    }
}

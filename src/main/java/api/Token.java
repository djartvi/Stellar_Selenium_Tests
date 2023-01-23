package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Token {

    @Step("Store tokens to local storage")
    public void storeTokens(WebDriver driver, Response response) throws InterruptedException {
        ExtractResponse extractResponse = new ExtractResponse();

        String accessToken = extractResponse.extractValueByKey(response, "accessToken");
        String refreshToken = extractResponse.extractValueByKey(response, "refreshToken");

        ((JavascriptExecutor) driver)
                .executeScript(String.format("window.localStorage.setItem('%s','%s');", "accessToken", accessToken));

        ((JavascriptExecutor) driver)
                .executeScript(String.format("window.localStorage.setItem('%s','%s');", "refreshToken", refreshToken));
    }
}

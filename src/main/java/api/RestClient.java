package api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pom.MainPage;

import static io.restassured.RestAssured.given;

public class RestClient {
    private final int REQUEST_DELAY = 500;

    protected RequestSpecification spec() throws InterruptedException {
        Thread.sleep(REQUEST_DELAY);
        return given()
                .contentType(ContentType.JSON)
                .baseUri(MainPage.getURL());
    }
}

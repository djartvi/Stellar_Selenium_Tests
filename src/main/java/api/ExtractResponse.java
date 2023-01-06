package api;

import io.restassured.response.Response;

public class ExtractResponse {

    public String extractValueByKey(Response response, String key) {
        return response
                .then()
                .extract()
                .path(key);
    }
}
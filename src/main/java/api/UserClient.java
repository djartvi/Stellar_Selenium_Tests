package api;

import credentials.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UserClient extends RestClient {

    private final String PREFIX = "/api/auth/";

    @Step("API register user {user.email}, {user.password}")
    public void register(User user) throws InterruptedException{
        spec()
                .body(user)
                .post(PREFIX + "register");
    }

    @Step("API login user {user.email}, {user.password}")
    public Response login(User user) throws InterruptedException{
        String json = String.format("{\"email\": \"%s\", \"password\": \"%s\"}",
                user.getEmail(), user.getPassword());

        return spec()
                .body(json)
                .post(PREFIX + "login");
    }

    @Step("API delete user")
    public void delete(String token) throws InterruptedException{
        spec()
                .header("Authorization", token)
                .delete(PREFIX + "user");
    }

    @Step("API get token and delete user")
    public void getTokenAndDeleteUser(Response response) throws InterruptedException {
        String token = new ExtractResponse().extractValueByKey(response, "accessToken");

        delete(token);
    }
}

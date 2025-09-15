package credentials;

import net.datafaker.Faker;
import lombok.Getter;

@Getter
public class User {

    private String name;
    private String email;
    private String password;

    public User randomUser() {
        return randomUser(Password.VALID_LENGTH);
    }

    public User randomUser(int length) {
        Faker faker = new Faker();

        name = faker.name().firstName();
        email = faker.internet().safeEmailAddress();
        password = faker.internet().password(length, length + 1);
        System.out.println("User: " + name + ", " + email + ", " + password);

        return this;
    }
}

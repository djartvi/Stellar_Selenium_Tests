package credentials;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private final String name;
    private final String email;
    private final String password;

    public static User randomUser() {
        Faker faker = new Faker();

        String name = faker.name().firstName();
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password(Password.VALID_LENGTH, Password.VALID_LENGTH + 1);

        return new User(name, email, password);
    }

    public static User randomUser(int length) {
        Faker faker = new Faker();

        String name = faker.name().firstName();
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password(length, length + 1);

        return new User(name, email, password);
    }
}

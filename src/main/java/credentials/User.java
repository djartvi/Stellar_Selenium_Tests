package credentials;

import net.datafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private final String name;
    private final String email;
    private final String password;

    public static User randomUser() {
        return randomUser(Password.VALID_LENGTH);
    }

    public static User randomUser(int length) {
        Faker faker = new Faker();

        String name = faker.name().firstName();
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password(length, length + 1);
        System.out.println("User: " + name + ", " + email + ", " + password);

        return new User(name, email, password);
    }
}

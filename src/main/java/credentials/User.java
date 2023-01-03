package credentials;

import com.github.javafaker.Faker;

public class User {
    private String name;
    private String email;
    private String password;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

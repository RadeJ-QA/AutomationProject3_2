package model;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RegisterUser {

    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String password;

    Faker faker = new Faker (new Locale("us"));

    public RegisterUser() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.phoneNumber = faker.phoneNumber().phoneNumber();
        this.password = "123456789";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}

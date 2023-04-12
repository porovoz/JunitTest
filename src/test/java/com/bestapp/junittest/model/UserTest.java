package com.bestapp.junittest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    String login = "userTest";
    String email = "user@test.com";
    String invalidLogin = "";
    String invalidEmail = "usertestcom";
    User userTest = new User(login, email);

    @Test
    @DisplayName("Create user with parameters")
    void shouldCreateUserWithParameters() {
        Assertions.assertEquals(login, userTest.getLogin()); // There is no sense to test getters.
        Assertions.assertEquals(email, userTest.getEmail()); // There is no sense to test getters.
    }

    @Test
    @DisplayName("Create user without parameters")
    void shouldCheckUserCreationWithoutParameters() {
        User userWithNoParamsTest = new User();
        Assertions.assertNull(userWithNoParamsTest.getLogin(), "Login must be null or empty");
        Assertions.assertNull(userWithNoParamsTest.getEmail(), "E-mail must be null or empty");
    }

    @Test
    @DisplayName("E-mail validation")
    void shouldValidateCharsInEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User(login, invalidEmail);
        }, "E-mail must be invalid to throw the exception to pass the test");
    }

    @Test
    @DisplayName("Login validation")
    void shouldValidateCharsInLogin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User(invalidLogin, email);
        }, "Login must be invalid to throw the exception to pass the test");
    }

    @Test
    @DisplayName("Check that login and e-mail are not equal")
    void shouldCheckThatLoginAndEmailAreNotEqual() {
        Assertions.assertNotEquals(userTest.getLogin(), userTest.getEmail(), "Login and e-mail must be different");
    }
}
package com.bestapp.junittest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    String login = "userTest";
    String email = "user@test.com";
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
    void shouldValidateCharsInAnEmail() {
        String email = userTest.getEmail();
        Assertions.assertTrue(email.contains("@"), "E-mail must contain '@' symbol");
        Assertions.assertTrue(email.contains("."), "E-mail must contain '.' symbol");
    }

    @Test
    @DisplayName("Check that login and e-mail are not equal")
    void shouldCheckThatLoginAndEmailAreNotEqual() {
        Assertions.assertNotEquals(userTest.getLogin(), userTest.getEmail(), "Login and e-mail must be different");
    }
}
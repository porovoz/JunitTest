package com.bestapp.junittest.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class User {
    private String login;
    private String email;

    public User() {
    }

    public User(String login, String email) {
        if(!StringUtils.isAlpha(login)) {
            throw new IllegalArgumentException("The login contains invalid symbols");
        } else {
        this.login = login;
        }
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("The e-mail must contain these symbols '@', '.'");
        }
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }
}

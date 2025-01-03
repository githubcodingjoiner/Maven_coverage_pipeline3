package com.example.automation;

public class LoginPage {
    private String username;
    private String password;
    private boolean isLoggedIn;

    public LoginPage() {
        this.isLoggedIn = false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void clickLogin() {
        if ("testuser".equals(username) && "password123".equals(password)) {
            isLoggedIn = true;
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}

package com.example.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginAutomationTest {

    @Test
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername("testuser");
        loginPage.setPassword("password123");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoggedIn(), "User should be logged in successfully");
    }

    @Test
    public void testLoginFailure() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername("wronguser");
        loginPage.setPassword("wrongpassword");
        loginPage.clickLogin();

        assertTrue(!loginPage.isLoggedIn(), "User should not be logged in with incorrect credentials");
    }
}

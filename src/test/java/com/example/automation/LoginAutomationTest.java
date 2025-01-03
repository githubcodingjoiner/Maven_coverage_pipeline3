package com.example.automation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginAutomationTest {

    @Test
    public void testLogin() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C://Program Files//chromedriver//chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Initialize the LoginPage object
            LoginPage loginPage = new LoginPage(driver);

            // Navigate to the login page
            loginPage.openLoginPage("https://the-internet.herokuapp.com/login");

            // Perform login with valid credentials
            loginPage.setUsername("tomsmith");
            loginPage.setPassword("SuperSecretPassword!");
            loginPage.clickLoginButton();

            // Validate successful login
            String successMessage = loginPage.getSuccessMessage();
            assertTrue(successMessage.contains("You logged into a secure area!"),
                    "Login should be successful and a success message should be displayed.");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

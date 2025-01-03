package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginAutomationTest {

    @Test
    public void testLogin() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "C://Program Files//chromedriver//chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://the-internet.herokuapp.com/login");

            // Locate the username, password fields, and login button
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

            // Perform login
            usernameField.sendKeys("tomsmith");
            passwordField.sendKeys("SuperSecretPassword!");
            loginButton.click();

            // Validate successful login
            WebElement successMessage = driver.findElement(By.id("flash"));
            assertTrue(successMessage.getText().contains("You logged into a secure area!"),
                    "Login success message not found or incorrect!");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

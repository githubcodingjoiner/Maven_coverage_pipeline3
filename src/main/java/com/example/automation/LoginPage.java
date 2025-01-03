package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to the login page
    public void openLoginPage(String url) {
        driver.get(url);
    }

    // Enter username
    public void setUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.clear(); // Clear existing text
        usernameField.sendKeys(username);
    }

    // Enter password
    public void setPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.clear(); // Clear existing text
        passwordField.sendKeys(password);
    }

    // Click the login button
    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginButton.click();
    }

    // Get the success message for validation
    public String getSuccessMessage() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        return messageElement.getText();
    }

    // Additional functions
    // 1. Get the error message for validation
    public String getErrorMessage() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        return errorElement.getText();
    }

    // 2. Check if login button is enabled
    public boolean isLoginButtonEnabled() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        return loginButton.isEnabled();
    }

    // 3. Validate current page URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // 4. Clear all fields
    public void clearFields() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.clear();
        passwordField.clear();
    }
}

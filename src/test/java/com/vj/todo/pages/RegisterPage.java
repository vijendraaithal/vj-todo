package com.vj.todo.pages;

import com.vj.todo.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private static RegisterPage registerPage;
    private final By firstNameInp = By.cssSelector("[data-testid='first-name']");
    private final By lastNameInp = By.cssSelector("[data-testid='last-name']");
    private final By emailInp = By.cssSelector("[data-testid='email']");
    private final By passwordInp = By.cssSelector("[data-testid='password']");
    private final By confirmPasswordInp = By.cssSelector("[data-testid='confirm-password']");
    private final By submitBtn = By.cssSelector("[data-testid='submit']");

    private RegisterPage() {
    }

    public static RegisterPage getInstance() {
        if(registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    public void register(WebDriver driver, User user) {
        driver.findElement(firstNameInp).sendKeys(user.getFirstName());
        driver.findElement(lastNameInp).sendKeys(user.getLastName());
        driver.findElement(emailInp).sendKeys(user.getEmail());
        driver.findElement(passwordInp).sendKeys(user.getPassword());
        driver.findElement(confirmPasswordInp).sendKeys(user.getPassword());
        driver.findElement(submitBtn).click();
    }
}
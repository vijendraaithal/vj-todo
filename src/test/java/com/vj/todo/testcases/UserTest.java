package com.vj.todo.testcases;

import com.github.javafaker.Faker;
import com.vj.todo.base.BaseTest;
import com.vj.todo.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserTest extends BaseTest {

    @Test
    public void shouldBeAbleToRegisterToApp() {
        User user = new User();
        driver.get("https://todo.qacart.com/signup");
        driver.findElement(By.cssSelector("[data-testid='first-name']")).sendKeys(user.getFirstName());
        driver.findElement(By.cssSelector("[data-testid='last-name']")).sendKeys(user.getLastName());
        driver.findElement(By.cssSelector("[data-testid='email']")).sendKeys(user.getEmail());
        driver.findElement(By.cssSelector("[data-testid='password']")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("[data-testid='confirm-password']")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("[data-testid='submit']")).click();
        boolean isWelcomeMsgDisplayed = driver.findElement(By.cssSelector("[data-testid='welcome']")).isDisplayed();
        Assert.assertTrue(isWelcomeMsgDisplayed);
    }
}
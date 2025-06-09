package com.vj.todo.testcases;

import com.github.javafaker.Faker;
import com.vj.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserTest extends BaseTest {

    @Test
    public void shouldBeAbleToRegisterToApp() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName + "." + lastName + faker.number().numberBetween(100, 500) + "@email.com";

        driver.get("https://todo.qacart.com/signup");
        driver.findElement(By.cssSelector("[data-testid='first-name']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[data-testid='last-name']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[data-testid='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[data-testid='password']")).sendKeys("Test123!");
        driver.findElement(By.cssSelector("[data-testid='confirm-password']")).sendKeys("Test123!");
        driver.findElement(By.cssSelector("[data-testid='submit']")).click();
        boolean isWelcomeMsgDisplayed = driver.findElement(By.cssSelector("[data-testid='welcome']")).isDisplayed();
        Assert.assertTrue(isWelcomeMsgDisplayed);
    }
}
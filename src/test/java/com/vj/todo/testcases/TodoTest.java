package com.vj.todo.testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TodoTest {

    @Test
    public void shouldBeAbleToAddATodo() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

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

        driver.findElement(By.cssSelector("[aria-label='delete']")).click();
        driver.findElement(By.cssSelector("[data-testid='new-todo']")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid='submit-newTask']")).click();
        String addedTodo = driver.findElement(By.cssSelector("[data-testid='todo-item']")).getText();
        Assert.assertEquals(addedTodo, "Learn Selenium");
        driver.quit();
    }

    @Test
    public void shoudlBeAbleToDeleteAddedTodo() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

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

        driver.findElement(By.cssSelector("[aria-label='delete']")).click();
        driver.findElement(By.cssSelector("[data-testid='new-todo']")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid='submit-newTask']")).click();
        String addedTodo = driver.findElement(By.cssSelector("[data-testid='todo-item']")).getText();
        Assert.assertEquals(addedTodo, "Learn Selenium");

        driver.findElement(By.cssSelector("[data-testid='delete']")).click();
        boolean isNoTodosTextDisplayed = driver.findElement(By.cssSelector("[data-testid='no-todos']")).isDisplayed();
        Assert.assertTrue(isNoTodosTextDisplayed);
        driver.quit();
    }
 }

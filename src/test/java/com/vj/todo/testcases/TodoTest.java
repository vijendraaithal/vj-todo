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

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddATodo() {
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
        driver.findElement(By.cssSelector("[aria-label='delete']")).click();
        driver.findElement(By.cssSelector("[data-testid='new-todo']")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid='submit-newTask']")).click();
        String addedTodo = driver.findElement(By.cssSelector("[data-testid='todo-item']")).getText();
        Assert.assertEquals(addedTodo, "Learn Selenium");
    }

    @Test
    public void shoudlBeAbleToDeleteAddedTodo() {
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
        driver.findElement(By.cssSelector("[aria-label='delete']")).click();
        driver.findElement(By.cssSelector("[data-testid='new-todo']")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid='submit-newTask']")).click();
        String addedTodo = driver.findElement(By.cssSelector("[data-testid='todo-item']")).getText();
        Assert.assertEquals(addedTodo, "Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid='delete']")).click();
        boolean isNoTodosTextDisplayed = driver.findElement(By.cssSelector("[data-testid='no-todos']")).isDisplayed();
        Assert.assertTrue(isNoTodosTextDisplayed);
    }
 }

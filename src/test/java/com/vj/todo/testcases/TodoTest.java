package com.vj.todo.testcases;

import com.vj.todo.base.BaseTest;
import com.vj.todo.model.User;
import com.vj.todo.pages.NewTodoPage;
import com.vj.todo.pages.RegisterPage;
import com.vj.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddATodo() {
        User user = new User();
        driver.get("https://todo.qacart.com/signup");
        new RegisterPage().register(driver,user);
        new TodoPage().clickPlusBtn(driver);
        new NewTodoPage().enterTodo(driver, "Learn Selenium");
        new NewTodoPage().clickCreateTodoBtn(driver);
        String addedTodoText = new TodoPage().getAddedTodoText(driver);
        Assert.assertEquals(addedTodoText, "Learn Selenium");
    }

    @Test
    public void shoudlBeAbleToDeleteAddedTodo() {
        User user = new User();
        driver.get("https://todo.qacart.com/signup");
        new RegisterPage().register(driver,user);
        new TodoPage().clickPlusBtn(driver);
        new NewTodoPage().enterTodo(driver, "Learn Selenium");
        new NewTodoPage().clickCreateTodoBtn(driver);
        new TodoPage().clickDeleteIcon(driver);
        boolean isNoTodosTextDisplayed = new TodoPage().isNoTodosTextDisplayed(driver);
        Assert.assertTrue(isNoTodosTextDisplayed);
    }
 }

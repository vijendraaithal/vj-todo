package com.vj.todo.testcases;

import com.vj.todo.base.BaseTest;
import com.vj.todo.model.User;
import com.vj.todo.pages.NewTodoPage;
import com.vj.todo.pages.RegisterPage;
import com.vj.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test(priority = 0)
    public void shouldBeAbleToAddATodo() throws InterruptedException {
        User user = new User();
        RegisterPage.getInstance().load(tlDriver.get());
        RegisterPage.getInstance().registerUsingApi(tlDriver.get(), user);
        RegisterPage.getInstance().load(tlDriver.get());
        TodoPage.getInstance().clickPlusBtn(tlDriver.get());
        NewTodoPage.getInstance().addTodo(tlDriver.get(), "Learn Selenium");
        String addedTodoText = TodoPage.getInstance().getAddedTodoText(tlDriver.get());
        Assert.assertEquals(addedTodoText, "Learn Selenium");
    }

    @Test(priority = 1)
    public void shouldBeAbleToDeleteAddedTodo() throws InterruptedException {
        User user = new User();
        RegisterPage.getInstance().load(tlDriver.get());
        RegisterPage.getInstance().registerUsingApi(tlDriver.get(), user);
        NewTodoPage.getInstance().addTodoUsingApi(user, "Learn Selenium");
        RegisterPage.getInstance().load(tlDriver.get());
        TodoPage.getInstance().clickDeleteIcon(tlDriver.get());
        boolean isNoTodosTextDisplayed =TodoPage.getInstance().isNoTodosTextDisplayed(tlDriver.get());
        Assert.assertTrue(isNoTodosTextDisplayed);
    }
 }

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
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().register(driver, user);
        TodoPage.getInstance().clickPlusBtn(driver);
        NewTodoPage.getInstance().enterTodo(driver, "Learn Selenium");
        NewTodoPage.getInstance().clickCreateTodoBtn(driver);
        String addedTodoText = TodoPage.getInstance().getAddedTodoText(driver);
        Assert.assertEquals(addedTodoText, "Learn Selenium");
    }

    @Test
    public void shouldBeAbleToDeleteAddedTodo() {
        User user = new User();
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().register(driver, user);
        TodoPage.getInstance().clickPlusBtn(driver);
        NewTodoPage.getInstance().enterTodo(driver, "Learn Selenium");
        NewTodoPage.getInstance().clickCreateTodoBtn(driver);
        boolean isNoTodosTextDisplayed =TodoPage.getInstance().isNoTodosTextDisplayed(driver);
        Assert.assertTrue(isNoTodosTextDisplayed);
    }
 }

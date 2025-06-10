package com.vj.todo.pages;

import com.vj.todo.apis.TodoApi;
import com.vj.todo.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage {
    private static NewTodoPage newTodoPage;
    private final By todoInp = By.cssSelector("[data-testid='new-todo']");
    private final By createTodoBtn = By.cssSelector("[data-testid='submit-newTask']");

    private NewTodoPage(){}

    public static NewTodoPage getInstance() {
        if ( newTodoPage == null) {
            newTodoPage = new NewTodoPage();
        }
        return newTodoPage;
    }
    public void enterTodo(WebDriver driver, String todoText) {
        driver.findElement(todoInp).sendKeys(todoText);
    }

    public void clickCreateTodoBtn(WebDriver driver) {
        driver.findElement(createTodoBtn).click();
    }

    public void addTodo(WebDriver driver, String todoText) {
        enterTodo(driver, todoText);
        clickCreateTodoBtn(driver);
    }

    public void addTodoUsingApi(User user, String todoText) {
        TodoApi.getInstance().addTodo(user, todoText);
    }
}

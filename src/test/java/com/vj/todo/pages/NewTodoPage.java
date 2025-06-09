package com.vj.todo.pages;

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
}

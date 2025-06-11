package com.vj.todo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage {
    private static TodoPage todoPage;
    private final By welcomeMsg = By.cssSelector("[data-testid='welcome']");
    private final By plusBtn = By.cssSelector("[aria-label='delete']");
    private final By deleteIcon = By.cssSelector("[data-testid='delete']");
    private final By noTodosText = By.cssSelector("[data-testid='no-todos']");
    private final By addedTodoItem = By.cssSelector("[data-testid='todo-item']");

    private TodoPage(){}

    public static TodoPage getInstance() {
        if(todoPage == null) {
            todoPage = new TodoPage();
        }
        return  todoPage;
    }

    @Step("Check if Welcome Message is displayed")
    public boolean isWelcomeMsgDisplayed(WebDriver driver) {
        return driver.findElement(welcomeMsg).isDisplayed();
    }

    @Step("Click on Plus Button")
    public void clickPlusBtn(WebDriver driver) {
        driver.findElement(plusBtn).click();
        System.out.println();
    }

    @Step("Click on delete icon")
    public void clickDeleteIcon(WebDriver driver) {
        driver.findElement(deleteIcon).click();
    }

    @Step("Check if no todos message is displayed")
    public boolean isNoTodosTextDisplayed(WebDriver driver) {
        return driver.findElement(noTodosText).isDisplayed();
    }

    @Step("Get the added todo text")
    public String getAddedTodoText(WebDriver driver) {
        return driver.findElement(addedTodoItem).getText();
    }

}

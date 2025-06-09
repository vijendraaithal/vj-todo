package com.vj.todo.testcases;

import com.vj.todo.base.BaseTest;
import com.vj.todo.model.User;
import com.vj.todo.pages.RegisterPage;
import com.vj.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    @Test
    public void shouldBeAbleToRegisterToApp() {
        User user = new User();
        driver.get("https://todo.qacart.com/signup");
        RegisterPage.getInstance().register(driver, user);
        boolean isWelcomeMsgDisplayed = TodoPage.getInstance().isWelcomeMsgDisplayed(driver);
        Assert.assertTrue(isWelcomeMsgDisplayed);
    }
}
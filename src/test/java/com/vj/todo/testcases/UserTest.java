package com.vj.todo.testcases;

import com.vj.todo.base.BaseTest;
import com.vj.todo.model.User;
import com.vj.todo.pages.RegisterPage;
import com.vj.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    @Test(description = "Should Be Able To Register To App")
    public void shouldBeAbleToRegisterToApp() {
        User user = new User();
        RegisterPage.getInstance().load(tlDriver.get());
        RegisterPage.getInstance().register(tlDriver.get(), user);
        boolean isWelcomeMsgDisplayed = TodoPage.getInstance().isWelcomeMsgDisplayed(tlDriver.get());
        Assert.assertTrue(isWelcomeMsgDisplayed);
    }
}
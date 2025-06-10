package com.vj.todo.testcases;

import com.vj.todo.apis.UserApi;
import com.vj.todo.base.BaseTest;
import com.vj.todo.model.User;
import com.vj.todo.pages.RegisterPage;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class DummyTest extends BaseTest {

    @Test
    public void dummy() {
        User user = new User();
        Response res = UserApi.getInstance().register(user);
        String access_token = res.path("access_token");
        String userID = res.path("userID");
        String firstName = res.path("firstName");

        Cookie accessTokenCookie = new Cookie("access_token", access_token);
        Cookie userIDCookie = new Cookie("userID", userID);
        Cookie firstNameCookie = new Cookie("firstName", firstName);

        RegisterPage.getInstance().load(driver);
        driver.manage().addCookie(accessTokenCookie);
        driver.manage().addCookie(userIDCookie);
        driver.manage().addCookie(firstNameCookie);
        RegisterPage.getInstance().load(driver);
    }
}
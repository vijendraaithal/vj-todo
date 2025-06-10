package com.vj.todo.apis;

import com.vj.todo.model.User;
import com.vj.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserApi {
    public static void main(String[] args) {

        User user = new User();

        given()
            .baseUri(ConfigUtils.getInstance().getBaseUrl())
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .post("/api/v1/users/register")
        .then()
            .log().all();
    }
}
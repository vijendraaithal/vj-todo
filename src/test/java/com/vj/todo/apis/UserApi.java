package com.vj.todo.apis;

import com.vj.todo.model.User;
import com.vj.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {
    public static void main(String[] args) {

        User user = new User();

        Response response =
        given()
            .baseUri(ConfigUtils.getInstance().getBaseUrl())
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .post("/api/v1/users/register")
        .then()
            .extract().response();

        String access_token = response.path("access_token");
        String firstName = response.path("firstName");
        System.out.println(access_token);
        System.out.println(firstName);

    }
}
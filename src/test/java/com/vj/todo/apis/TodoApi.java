package com.vj.todo.apis;

import com.vj.todo.model.User;
import com.vj.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TodoApi {

    private static TodoApi todoApi;

    private TodoApi() {}

    public static TodoApi getInstance() {
        if (todoApi == null) {
            todoApi = new TodoApi();
        }
        return todoApi;
    }

    public Response addTodo(User user, String todoText) {
        return
            given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .contentType(ContentType.JSON)
                .body("{\"item\":\"" + todoText + "\",\"isCompleted\":false}")
                .auth().oauth2(user.getAccessToken())
            .when()
                .post("/api/v1/tasks")
            .then()
                .extract().response();
    }
}
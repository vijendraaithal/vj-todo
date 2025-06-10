package com.vj.todo.apis;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserApi {
    public static void main(String[] args) {
        given()
            .baseUri("https://todo.qacart.com")
            .contentType(ContentType.JSON)
            .body("{\"email\":\"john.smith.vj.10j25.ts2@emaill.com\",\"password\":\"Test123!\",\"firstName\":\"John\",\"lastName\":\"Smith\"}")
        .when()
            .post("/api/v1/users/register")
        .then()
            .log().all();
    }
}
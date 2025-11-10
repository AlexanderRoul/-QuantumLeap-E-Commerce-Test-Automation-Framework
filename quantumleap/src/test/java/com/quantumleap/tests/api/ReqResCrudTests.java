package com.quantumleap.tests.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReqResCrudTests {

    private static final String BASE = "https://reqres.in/api";

    @Test
    public void getUsers() {
        given().baseUri(BASE)
        .when().get("/users?page=2")
        .then().statusCode(200)
               .body("page", equalTo(2))
               .body("data", not(empty()));
    }

    @Test
    public void createUser() {
        String payload = "{\n  \"name\": \"morpheus\",\n  \"job\": \"leader\"\n}";
        given().baseUri(BASE).contentType(ContentType.JSON).body(payload)
        .when().post("/users")
        .then().statusCode(201)
               .body("name", equalTo("morpheus"))
               .body("job", equalTo("leader"))
               .body("id", not(emptyString()));
    }

    @Test
    public void updateUser() {
        String payload = "{\n  \"name\": \"neo\",\n  \"job\": \"the one\"\n}";
        given().baseUri(BASE).contentType(ContentType.JSON).body(payload)
        .when().put("/users/2")
        .then().statusCode(anyOf(is(200), is(201)))
               .body("name", equalTo("neo"))
               .body("job", equalTo("the one"));
    }
}

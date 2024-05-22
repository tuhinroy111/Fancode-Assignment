package com.fancode.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    public static Response getUsers() {
        System.out.println("Sending request to " + BASE_URL+ "/users api" );
        return RestAssured.get(BASE_URL + "/users");
    }

    public static Response getTodos() {
        System.out.println("Sending request to " + BASE_URL+ "/todos api" );
        return RestAssured.get(BASE_URL + "/todos");
    }
}

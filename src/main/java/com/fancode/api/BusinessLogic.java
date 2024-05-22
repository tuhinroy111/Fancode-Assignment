package com.fancode.api;

import com.fancode.utils.Utils;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BusinessLogic {
    public static void getUserWithValidCompletionPercentage(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Response userResponse = APIClient.getUsers();
        System.out.println("USER RESPONSE========================================" + userResponse.asString());
        Response todoResponse = APIClient.getTodos();
        System.out.println("TODO RESPONSE========================================" + todoResponse.asString());

        List<Map<String, Object>> users = mapper.readValue(userResponse.asString(), List.class);
        List<Map<String, Object>> todos = mapper.readValue(todoResponse.asString(), List.class);

        List<Map<String, Object>> fanCodeUsers = users.stream()
                .filter(Utils::isFanCodeCityUser)
                .collect(Collectors.toList());

        System.out.println("=======Users with >50% completion rate=======");
        for (Map<String, Object> user : fanCodeUsers) {
            int userId = (int) user.get("id");
            String name = (String) user.get("name");
            double completionPercentage = Utils.calculateCompletionPercentage(userId, todos);
            if(completionPercentage>50d)
            System.out.printf("User Id: %d, Name: %s, Completed Percentage: %.2f%n", userId, name, completionPercentage);
        }
    }
}

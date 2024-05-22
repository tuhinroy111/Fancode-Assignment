package com.fancode.utils;

import java.util.List;
import java.util.Map;

public class Utils {
    public static boolean isFanCodeCityUser(Map<String, Object> user) {
        Map<String, String> geo = (Map<String, String>) ((Map<String, Object>) user.get("address")).get("geo");
        double lat = Double.parseDouble(geo.get("lat"));
        double lng = Double.parseDouble(geo.get("lng"));
        return lat > -40 && lat < 5 && lng > 5 && lng < 100;
    }

    public static double calculateCompletionPercentage(int userId, List<Map<String, Object>> todos) {
        long totalTodos = todos.stream().filter(todo -> (int) todo.get("userId") == userId).count();
        long completedTodos = todos.stream().filter(todo -> (int) todo.get("userId") == userId && (boolean) todo.get("completed")).count();

        if (totalTodos == 0) {
            return 0;
        }
        return (double) completedTodos / totalTodos * 100;
    }
}

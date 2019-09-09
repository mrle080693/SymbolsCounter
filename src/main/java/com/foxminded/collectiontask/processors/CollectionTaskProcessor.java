package main.java.com.foxminded.collectiontask.processors;

import java.util.*;

public class CollectionTaskProcessor {
    public String process(String input) {
        String result = input;
        try {
            if (!input.equals("")) {
                Map sortedInput = sortString(input);
                result = mapToString(sortedInput, input);
            }
        } catch (NullPointerException e) {
            result = null;
        }
        return result;
    }

    private Map sortString(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <= input.length() - 1; i++) {
            char key = input.charAt(i);
            if (!hashMap.containsKey(key))
                hashMap.put(key, 1);
            else {
                int value = hashMap.get(key) + 1;
                hashMap.put(key, value);
            }
        }

        return hashMap;
    }

    private String mapToString(Map<Character, Integer> inputMap, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('"').append(input).append('"').append("\n");
        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()) {
            stringBuilder.append('"').append(entry.getKey()).append('"').append(" ").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString().trim();
    }
}

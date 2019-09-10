package com.foxminded.collectiontask.processors;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SymbolsCounterProcessor {
    public String process(String input) {
        String result;
        if (input == null || input.equals("")) {
            result = input;
        } else {
            Map sortedInput = countSymbols(input);
            result = mapToString(sortedInput, input);
        }

        return result;
    }

    private Map countSymbols(String input) {
        Map<Character, Integer> result = new HashMap<>();
        IntStream.range(0, input.length()).forEach(i -> {
            char character = input.charAt(i);
            if (!result.containsKey(character)) {
                result.put(character, 1);
            } else {
                int value = result.get(character) + 1;
                result.put(character, value);
            }
        });
        return result;
    }

    private String mapToString(Map<Character, Integer> inputMap, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('"').
                append(input).
                append('"').
                append("\n");
        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()) {
            stringBuilder.
                    append('"').
                    append(entry.getKey()).
                    append('"').append(" ").
                    append(entry.getValue()).
                    append("\n");
        }
        return stringBuilder.toString().trim();
    }
}

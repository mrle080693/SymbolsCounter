package com.foxminded.symbolscounter.processors;

import java.util.HashMap;
import java.util.Map;

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

    private Map<Character, Integer> countSymbols(String input) {
        Map<Character, Integer> result = new HashMap<>();

        input.chars().forEach(i -> {
            if (!result.containsKey((char) i)) {
                result.put((char) i, 1);
            } else {
                result.merge((char) i, 1, (oldVal, newVal) -> oldVal + newVal);
            }
        });

        return result;
    }

    private String mapToString(Map<Character, Integer> inputMap, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('"')
                .append(input)
                .append('"')
                .append("\n");

        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()) {
            stringBuilder
                    .append('"')
                    .append(entry.getKey())
                    .append('"').append(" ")
                    .append(entry.getValue())
                    .append("\n");
        }

        return stringBuilder.toString().trim();
    }
}


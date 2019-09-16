package com.foxminded.symbolscounter.processors;

import java.util.HashMap;
import java.util.Map;

public class SymbolsCounterProcessor {
    private Map<String, String> cache = new HashMap<>();

    public String process(String input) {
        String result;

        if (input == null || input.equals("")) {
            result = input;
        } else {
            result = findInCache(input);

            if (result == null) {
                Map sortedInput = countSymbols(input);
                result = mapToString(sortedInput, input);
                cache.put(input, result);
            }
        }

        return result;
    }

    private Map<Character, Integer> countSymbols(String input) {
        Map<Character, Integer> result = new HashMap<>();

        input.chars().forEach(i -> result.merge((char) i, 1, (oldVal, newVal) -> oldVal + newVal));

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

    private String findInCache(String input) {
        String result = null;

        if (cache.containsKey(input)) {
            result = cache.get(input);
        }

        return result;
    }

    public Map getCache() {
        return cache;
    }
}


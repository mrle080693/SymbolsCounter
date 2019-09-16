package com.foxminded.symbolscounter;

import com.foxminded.symbolscounter.processors.SymbolsCounterProcessor;

import java.util.HashMap;
import java.util.Map;

class SymbolsCounterManager {
    private Map<String, String> cache = new HashMap<>();
    private SymbolsCounterProcessor symbolsCounterProcessor = new SymbolsCounterProcessor();

    public String process(String input) {
        String result;

        if (input == null || input.equals("")) {
            result = input;
        } else {
            result = findInCache(input);

            if (result == null) {
                result = symbolsCounterProcessor.process(input);
                cache.put(input, result);
            }
        }

        return result;
    }

    private String findInCache(String input) {
        String result = null;

        if (cache.containsKey(input)) {
            result = cache.get(input);
        }

        return result;
    }

    public Map<String, String> getCache() {
        return cache;
    }
}


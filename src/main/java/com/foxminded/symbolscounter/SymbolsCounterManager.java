package com.foxminded.symbolscounter;

import com.foxminded.symbolscounter.processors.SymbolsCounterProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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
        AtomicReference<String> result = new AtomicReference<>();
        result.set(null);

        cache.keySet().stream().filter(i -> i.equals(input)).forEach(i -> {
            result.set(cache.get(i));
        });

        return result.get();
    }

    public Map<String, String> getCache() {
        return cache;
    }
}


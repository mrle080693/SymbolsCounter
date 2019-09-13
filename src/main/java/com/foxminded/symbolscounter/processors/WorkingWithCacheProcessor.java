package com.foxminded.symbolscounter.processors;

import com.foxminded.symbolscounter.pojo.Cache;

import java.io.*;
import java.util.Map;
import java.util.Objects;

public class WorkingWithCacheProcessor {

    public String findInCache(String input) {
        Cache cache = loadCache();
        String result = input;
        SymbolsCounterProcessor symbolsCounterProcessor = new SymbolsCounterProcessor();

        if (cache.getInputsResults().containsKey(input)) {
            result = cache.getInputsResults().get(input);
            cache.getInputsStatistic().merge(input, (long) 1, (oldVal, newVal) -> oldVal + newVal);
        } else {
            String counterProcessorResult = symbolsCounterProcessor.process(input);
            writeInCache(input, counterProcessorResult);
        }

        return result;
    }

    private void writeInCache(String input, String result) {
        Cache cache = loadCache();

        cache.getInputsResults().put(input, result);
        cache.getInputsStatistic().put(input, (long) 1);

        saveInCache(cache);
    }

    private void saveInCache(Cache cache) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("cache");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cache);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(objectOutputStream).close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        deleteTheLeastPopularInputs();
    }

    private Cache loadCache() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream;
        Cache cache = null;

        File file = new File("cache");

        if (file.length() == 0) {
            cache = new Cache();
        }
        if (!(file.length() == 0)) {
            try {
                fileInputStream = new FileInputStream("cache");
                objectInputStream = new ObjectInputStream(fileInputStream);
                cache = (Cache) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return cache;
    }

    private void deleteTheLeastPopularInputs() {
        Cache cache = loadCache();

        if (cache.getInputsResults().size() > 100) {
            for (int i = 0; cache.getInputsResults().size() > 100; i++) {
                Map.Entry<String, Long> minEntry = null;
                String theLeastPopularKey = null;

                for (Map.Entry<String, Long> entry : cache.getInputsStatistic().entrySet()) {
                    if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                        minEntry = entry;
                    }
                }

                if (minEntry != null) {
                    theLeastPopularKey = minEntry.getKey();
                    cache.getInputsStatistic().remove(theLeastPopularKey);
                    cache.getInputsResults().remove(theLeastPopularKey);
                }
            }

            saveInCache(cache);
        }
    }

    public void clearCache() {
        Cache cache = new Cache();
        saveInCache(cache);
    }

    public Cache getCache() {
        return loadCache();
    }
}

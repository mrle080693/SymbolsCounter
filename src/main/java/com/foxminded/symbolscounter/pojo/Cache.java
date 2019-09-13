package com.foxminded.symbolscounter.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cache implements Serializable {
    private Map<String, String> inputsResults = new HashMap<>();
    private Map<String, Long> inputsStatistic = new HashMap<>();

    public Map<String, String> getInputsResults() {
        return inputsResults;
    }

    public Map<String, Long> getInputsStatistic() {
        return inputsStatistic;
    }
}

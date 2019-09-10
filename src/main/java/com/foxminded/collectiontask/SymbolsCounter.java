package com.foxminded.collectiontask;

import com.foxminded.collectiontask.processors.SymbolsCounterProcessor;

public class SymbolsCounter {
    public static void main(String[] args) {
        SymbolsCounterProcessor symbolsCounterProcessor = new SymbolsCounterProcessor();
        String result = symbolsCounterProcessor.process("Превысокомногорассмотрительствующий");
        System.out.println(result);
    }
}

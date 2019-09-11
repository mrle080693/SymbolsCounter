package com.foxminded.symbolscounter;

import com.foxminded.symbolscounter.processors.SymbolsCounterProcessor;

public class SymbolsCounter {
    public static void main(String[] args) {
        SymbolsCounterProcessor symbolsCounterProcessor = new SymbolsCounterProcessor();
        String result = symbolsCounterProcessor.process("aabc");
        System.out.println(result);
    }
}

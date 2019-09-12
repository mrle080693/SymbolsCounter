package com.foxminded.symbolscounter;

import com.foxminded.symbolscounter.processors.WorkingWithUserProcessor;

public class SymbolsCounter {

    public static void main(String[] args) {
        WorkingWithUserProcessor workingWithUserProcessor = new WorkingWithUserProcessor();
        workingWithUserProcessor.process();
    }
}

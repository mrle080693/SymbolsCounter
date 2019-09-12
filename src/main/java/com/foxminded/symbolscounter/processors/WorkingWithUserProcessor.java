package com.foxminded.symbolscounter.processors;

import java.util.Scanner;

public class WorkingWithUserProcessor {
    private Scanner scanner = new Scanner(System.in);

    public void process() {
        String usersInput = getStringFromUser();

        WorkingWithCacheProcessor workingWithCacheProcessor = new WorkingWithCacheProcessor();
        SymbolsCounterProcessor symbolsCounterProcessor = new SymbolsCounterProcessor();
        String result = workingWithCacheProcessor.findInCache(usersInput);
        if(result == null){
            result = symbolsCounterProcessor.process(usersInput);
        }
        System.out.println();
        System.out.println(result);

        getExitOrRestartChoice();
        scanner.close();
    }

    private String getStringFromUser() {
        System.out.println("Write and press the Enter key please");
        Scanner scanner = new Scanner(System.in);
        String usersInput = scanner.nextLine();

        if (usersInput == null) {
            System.err.println("Input must not be null!!!");
            getExitOrRestartChoice();
        }
        return usersInput;
    }

    private void getExitOrRestartChoice() {
        System.out.println("Restart - 1");
        System.out.println("Exit    - Something else");

        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("1")) {
            process();
        }
    }
}

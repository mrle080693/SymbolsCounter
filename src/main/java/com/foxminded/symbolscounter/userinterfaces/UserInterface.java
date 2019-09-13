package com.foxminded.symbolscounter.userinterfaces;

import com.foxminded.symbolscounter.processors.SymbolsCounterProcessor;
import com.foxminded.symbolscounter.processors.WorkingWithCacheProcessor;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void process() {
        String usersInput = getStringFromUser();
        WorkingWithCacheProcessor workingWithCacheProcessor = new WorkingWithCacheProcessor();
        SymbolsCounterProcessor symbolsCounterProcessor = new SymbolsCounterProcessor();
        String result = workingWithCacheProcessor.findInCache(usersInput);

        if (result.equals(usersInput)) {
            result = symbolsCounterProcessor.process(usersInput);
        }
        System.out.println();
        System.out.println(result);
        getUsersChoice();

        scanner.close();
    }

    private String getStringFromUser() {
        System.out.println("Write and press the Enter key please");
        Scanner scanner = new Scanner(System.in);
        String usersInput = scanner.nextLine();

        return usersInput;
    }

    private void getUsersChoice() {
        System.out.println();
        System.out.println("Restart     - 1");
        System.out.println("Clear cache - 0 ");
        System.out.println("Exit        - Something else");

        scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("1")) {
            process();
        }
        if (input.equals("0")) {
            WorkingWithCacheProcessor workingWithCacheProcessor = new WorkingWithCacheProcessor();

            System.out.println();
            System.out.println("Are you shore?");
            System.out.println("Yes - 0");
            System.out.println("No  - Something else");
            scanner = new Scanner(System.in);
            String shoreOrNote = scanner.nextLine();

            if (shoreOrNote.equals("0")) {
                workingWithCacheProcessor.clearCache();
                System.out.println("Cache is clean");
                getUsersChoice();
            }
        }
    }
}

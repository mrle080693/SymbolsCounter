package com.foxminded.symbolscounter;

import java.util.Scanner;

public class SymbolsCounter {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SymbolsCounterManager symbolsCounterManager = new SymbolsCounterManager();
        boolean exit = false;
        String input = null;
        String result = null;

        for (int i = 0; !exit; i++) {
            input = getStringFromUser();

            result = symbolsCounterManager.process(input);

            System.out.println();
            System.out.println(result);

            exit = getUsersChoice();
        }

        scanner.close();
    }

    private static String getStringFromUser() {
        System.out.println();
        System.out.println("Write and press the enter key please");

        return scanner.nextLine();
    }

    private static boolean getUsersChoice() {
        boolean result = false;

        System.out.println();
        System.out.println("Would you like to repeat");
        System.out.println("Yes - 1");
        System.out.println("No  - Anything else");
        String choice = scanner.nextLine();

        if (!choice.equals("1")) {
            result = true;
        }

        return result;
    }
}

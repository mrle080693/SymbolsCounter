package com.foxminded.symbolscounter;

import com.foxminded.symbolscounter.processors.SymbolsCounterProcessor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SymbolsCounter {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SymbolsCounterProcessor symbolsCounterProcessor = new SymbolsCounterProcessor();
            boolean exit = false;

            for (; !exit; ) {
                String input = getStringFromUser(scanner);

                String result = symbolsCounterProcessor.process(input);

                System.out.println();
                System.out.println(result);

                exit = getUsersChoice(scanner);
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Sorry :(");
        }
    }

    private static String getStringFromUser(Scanner scanner) {
        System.out.println();
        System.out.println("Write and press the enter key please");

        return scanner.nextLine();
    }

    private static boolean getUsersChoice(Scanner scanner) {
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

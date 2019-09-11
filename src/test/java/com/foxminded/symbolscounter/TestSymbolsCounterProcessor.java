package com.foxminded.symbolscounter;

import com.foxminded.symbolscounter.processors.SymbolsCounterProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestSymbolsCounterProcessor {
    private SymbolsCounterProcessor symbolsCounterProcessor = new SymbolsCounterProcessor();

    @Test
    void processMustReturnNullIfInputIsNull() {
        assertNull(symbolsCounterProcessor.process(null));
    }

    @Test
    void processMustReturnEmptyStringIfInputIsEmptyString() {
        String expected = "";
        String actual = symbolsCounterProcessor.process("");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultIfInputIsSeparator() {
        String expected = "\" \"\n" +
                "\" \" 1";
        String actual = symbolsCounterProcessor.process(" ");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultIfInputIsSeparators() {
        String expected = "\"       \"\n" +
                "\" \" 7";
        String actual = symbolsCounterProcessor.process("       ");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsOneLetter() {
        String expected = "\"a\"\n" +
                "\"a\" 1";
        String actual = symbolsCounterProcessor.process("a");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsManySameLetters() {
        String expected = "\"aaaaa\"\n" +
                "\"a\" 5";
        String actual = symbolsCounterProcessor.process("aaaaa");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsOneLetterInUpperCase() {
        String expected = "\"A\"\n" +
                "\"A\" 1";
        String actual = symbolsCounterProcessor.process("A");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsManySameLettersInUpperCase() {
        String expected = "\"AAAAA\"\n" +
                "\"A\" 5";
        String actual = symbolsCounterProcessor.process("AAAAA");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsManySameLettersInDifferentCases() {
        String expected = "\"AaAaA\"\n" +
                "\"A\" 3\n" +
                "\"a\" 2";
        String actual = symbolsCounterProcessor.process("AaAaA");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsDifferentLetters() {
        String expected = "\"Abcde\"\n" +
                "\"A\" 1\n" +
                "\"b\" 1\n" +
                "\"c\" 1\n" +
                "\"d\" 1\n" +
                "\"e\" 1";
        String actual = symbolsCounterProcessor.process("Abcde");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsLongWord() {
        String expected = "\"Превысокомногорассмотрительствующий\"\n" +
                "\"р\" 3\n" +
                "\"с\" 4\n" +
                "\"т\" 3\n" +
                "\"у\" 1\n" +
                "\"щ\" 1\n" +
                "\"ы\" 1\n" +
                "\"ь\" 1\n" +
                "\"ю\" 1\n" +
                "\"а\" 1\n" +
                "\"в\" 2\n" +
                "\"г\" 1\n" +
                "\"е\" 2\n" +
                "\"и\" 2\n" +
                "\"й\" 1\n" +
                "\"к\" 1\n" +
                "\"л\" 1\n" +
                "\"м\" 2\n" +
                "\"н\" 1\n" +
                "\"о\" 5\n" +
                "\"П\" 1";
        String actual = symbolsCounterProcessor.process("Превысокомногорассмотрительствующий");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsNumbers() {
        String expected = "\"12345\"\n" +
                "\"1\" 1\n" +
                "\"2\" 1\n" +
                "\"3\" 1\n" +
                "\"4\" 1\n" +
                "\"5\" 1";
        String actual = symbolsCounterProcessor.process("12345");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsSymbols() {
        String expected = "\"#/*!>\"\n" +
                "\"!\" 1\n" +
                "\"#\" 1\n" +
                "\"*\" 1\n" +
                "\">\" 1\n" +
                "\"/\" 1";
        String actual = symbolsCounterProcessor.process("#/*!>");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsSameSpecialSymbols() {
        String expected = "\"∑∑∑∑∑\"\n" +
                "\"∑\" 5";
        String actual = symbolsCounterProcessor.process("∑∑∑∑∑");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsMixed() {
        String expected = "\"Hello 234 )>@!\"\n" +
                "\" \" 2\n" +
                "\"@\" 1\n" +
                "\"!\" 1\n" +
                "\"2\" 1\n" +
                "\"3\" 1\n" +
                "\"4\" 1\n" +
                "\"e\" 1\n" +
                "\"H\" 1\n" +
                "\")\" 1\n" +
                "\"l\" 2\n" +
                "\">\" 1\n" +
                "\"o\" 1";
        String actual = symbolsCounterProcessor.process("Hello 234 )>@!");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsMixedAndLong() {
        String expected = "\"HELLO JAVA!!! \" +\n" +
                "                \"I am very glad that I have chance to learn you :) \"\n" +
                "\"A\" 2\n" +
                "\"E\" 1\n" +
                "\"H\" 1\n" +
                "\"I\" 2\n" +
                "\"J\" 1\n" +
                "\"\n" +
                "\" 1\n" +
                "\"L\" 2\n" +
                "\"O\" 1\n" +
                "\"V\" 1\n" +
                "\" \" 31\n" +
                "\"!\" 3\n" +
                "\"a\" 6\n" +
                "\"\"\" 2\n" +
                "\"c\" 2\n" +
                "\"d\" 1\n" +
                "\"e\" 4\n" +
                "\"g\" 1\n" +
                "\"h\" 3\n" +
                "\")\" 1\n" +
                "\"+\" 1\n" +
                "\"l\" 2\n" +
                "\"m\" 1\n" +
                "\"n\" 2\n" +
                "\"o\" 2\n" +
                "\"r\" 2\n" +
                "\"t\" 3\n" +
                "\"u\" 1\n" +
                "\"v\" 2\n" +
                "\"y\" 2\n" +
                "\":\" 1";
        String actual = symbolsCounterProcessor.process("HELLO JAVA!!! \" +\n" +
                "                \"I am very glad that I have chance to learn you :) ");
        assertEquals(expected, actual);
    }
}


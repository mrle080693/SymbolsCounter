package test.java.com.foxminded.collectiontask;

import main.java.com.foxminded.collectiontask.processors.CollectionTaskProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestCollectionTaskProcessor {
    private CollectionTaskProcessor collectionTaskProcessor = new CollectionTaskProcessor();

    @Test
    void processMustReturnNullIfInputIsNull() {
        assertNull(collectionTaskProcessor.process(null));
    }

    @Test
    void processMustReturnEmptyStringIfInputIsEmptyString() {
        String expected = "";
        String actual = collectionTaskProcessor.process("");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultIfInputIsSeparator() {
        String expected = "\" \"\n" +
                "\" \" 1";
        String actual = collectionTaskProcessor.process(" ");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsOneLetter() {
        String expected = "\"a\"\n" +
                "\"a\" 1";
        String actual = collectionTaskProcessor.process("a");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsManySameLetters() {
        String expected = "\"aaaaa\"\n" +
                "\"a\" 5";
        String actual = collectionTaskProcessor.process("aaaaa");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsOneLetterInUpperCase() {
        String expected = "\"A\"\n" +
                "\"A\" 1";
        String actual = collectionTaskProcessor.process("A");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsManySameLettersInUpperCase() {
        String expected = "\"AAAAA\"\n" +
                "\"a\" 5";
        String actual = collectionTaskProcessor.process("AAAAA");
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
        String actual = collectionTaskProcessor.process("Abcde");
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
        String actual = collectionTaskProcessor.process("12345");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsSymbols() {
        String expected = "\"#/*!>\"\n" +
                "\"#\" 1\n" +
                "\"/\" 1\n" +
                "\"*\" 1\n" +
                "\"!\" 1\n" +
                "\">\" 1";
        String actual = collectionTaskProcessor.process("#/*!>");
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
        String actual = collectionTaskProcessor.process("Hello 234 )>@!");
        assertEquals(expected, actual);
    }

    @Test
    void processMustReturnCorrectResultWhenInputIsMixedAndLong() {
        String expected = "\"HELLO JAVA!!! I am very glad that I have chance to learn you :) \"\n" +
                "\"A\" 2\n" +
                "\"E\" 1\n" +
                "\"H\" 1\n" +
                "\"I\" 2\n" +
                "\"J\" 1\n" +
                "\"L\" 2\n" +
                "\"O\" 1\n" +
                "\"V\" 1\n" +
                "\" \" 14\n" +
                "\"!\" 3\n" +
                "\"a\" 6\n" +
                "\"c\" 2\n" +
                "\"d\" 1\n" +
                "\"e\" 4\n" +
                "\"g\" 1\n" +
                "\"h\" 3\n" +
                "\")\" 1\n" +
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
        String actual = collectionTaskProcessor.process("HELLO JAVA!!! \" +\n" +
                "                \"I am very glad that I have chance to learn you :) ");
        assertEquals(expected, actual);
    }
}

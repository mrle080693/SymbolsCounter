package com.foxminded.symbolscounter;

import com.foxminded.symbolscounter.processors.WorkingWithCacheProcessor;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestWorkingWithCacheProcessor {
    private WorkingWithCacheProcessor workingWithCacheProcessor = new WorkingWithCacheProcessor();

    @Test
    void findInCacheMustReturnNullIfInputIsNull() {
        assertNull(workingWithCacheProcessor.findInCache(null));
    }

    @Test
    void findInCacheMustReturnEmptyStringIfInputIsEmptyString() {
        String expected = "";
        String actual = workingWithCacheProcessor.findInCache("");
        assertEquals(expected, actual);
    }

    @Test
    void inputsResultsSizeMustNotBeMoreThanOneHundred() {
        for (int i = 0; i < 111; i++) {
            workingWithCacheProcessor.findInCache(String.valueOf(i));
        }

        int expected = 100;
        int actual = workingWithCacheProcessor.getCache().getInputsResults().size();

        assertEquals(expected, actual);
    }

    @Test
    void inputStatisticSizeMustNotBeMoreThanOneHundred() {
        for (int i = 0; i < 111; i++) {
            workingWithCacheProcessor.findInCache(String.valueOf(i));
        }

        int expected = 100;
        int actual = workingWithCacheProcessor.getCache().getInputsStatistic().size();

        assertEquals(expected, actual);
    }

    @Test
    void inputStatisticSizeMustBeEqualsinputsResultsSize() {
        for (int i = 0; i < 111; i++) {
            workingWithCacheProcessor.findInCache(String.valueOf(i));
        }

        boolean expected = true;
        boolean actual = true;
        int inputsStatisticSize = workingWithCacheProcessor.getCache().getInputsStatistic().size();
        int inputsResultsSize = workingWithCacheProcessor.getCache().getInputsResults().size();

        if (inputsStatisticSize != inputsResultsSize) {
            actual = false;
        }

        assertEquals(expected, actual);
    }

    @Test
    void inputsStatisticMustHasAllinputsResults() {
        for (int i = 0; i < 111; i++) {
            workingWithCacheProcessor.findInCache(String.valueOf(i));
        }

        AtomicBoolean expected = new AtomicBoolean(true);
        AtomicBoolean actual = new AtomicBoolean(true);

        workingWithCacheProcessor.getCache().getInputsStatistic().keySet().forEach(i -> {
            if (!workingWithCacheProcessor.getCache().getInputsResults().containsKey(i)) {
                actual.set(false);
            }
        });

        assertEquals(expected.get(), actual.get());
    }

    @Test
    void haveToBeDeletedTheLeastPopularInput() {
        for (int i = 0; i < 99; i++) {
            workingWithCacheProcessor.findInCache(String.valueOf(i));
        }

        workingWithCacheProcessor.getCache().getInputsStatistic().entrySet().forEach(i -> {
            i.setValue((long) 2);
        });

        workingWithCacheProcessor.getCache().getInputsStatistic().put("Hello", (long) 1);

        boolean expected = false;
        boolean actual = workingWithCacheProcessor.getCache().getInputsStatistic().containsKey("Hello");

        assertEquals(expected, actual);
    }
}

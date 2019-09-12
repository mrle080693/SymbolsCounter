package com.foxminded.symbolscounter;

import com.foxminded.symbolscounter.processors.WorkingWithCacheProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestWorkingWithCache {
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
}

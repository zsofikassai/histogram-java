package com.codecool.histogram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {
    /*
*/
    Range TestRange = new Range(1, 7);

    @Test
    void range_fromLessThan0_throwException(){
        assertThrows(IllegalArgumentException.class,() -> new Range(-1, 2));
    }

    @Test
    void range_toLessThanFrom_throwException(){
        assertThrows(IllegalArgumentException.class,() -> new Range(6, 2));
    }

    @Test
    void isInRange_lengthInRange_True(){
        assertTrue(TestRange.isInRange("test"));
    }
    @Test
    void isInRange_lengthEqualsFrom_True(){
        assertTrue(TestRange.isInRange("t"));
    }
    @Test
    void isInRange_lengthEqualsTo_True(){
        assertTrue(TestRange.isInRange("test567"));
    }
    @Test
    void isInRange_lengthOutOfRange_False(){
        assertFalse(TestRange.isInRange("test567333"));
    }

    @Test
    void toString_validRangetoString_printInterval(){
        assertEquals("1  - 7 ", TestRange.toString());
    }
}

package com.codecool.histogram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {
    /*
Range class is covered with tests, by implementing the RangeTest class.
Provide test cases for constructor. The following cases should be covered:
from < 0
to < from
Provide test cases for isInRange(). The following cases should be covered:
- word's length in range
- word's length equals to range from
- word's length equals to range to
- word's length is out of range
Provide test case for a toString() method */
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


}

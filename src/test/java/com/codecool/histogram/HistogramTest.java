package com.codecool.histogram;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HistogramTest {
    Histogram histogramUnderTest;
    Range expectedRange1 = new Range(1, 5);
    Range expectedRange2 = new Range(6, 10);
    List<Range> expectedRanges = new ArrayList<>();


    @BeforeEach
    void setUp() {
        histogramUnderTest = new Histogram();
    }

    @Test
    @Order(1)
    void generateRanges_stepLessThan0_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> histogramUnderTest.generateRanges(-1, 1));
    }
    @Test
    @Order(2)
    void generateRanges_amountLessThan0_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> histogramUnderTest.generateRanges(1, -1));
    }

    @Test
    @Order(3)
    void generateRanges_positiveIntParameters_generateRanges(){
        expectedRanges.add(expectedRange1);
        expectedRanges.add(expectedRange2);
        assertEquals(expectedRanges,
                histogramUnderTest.generateRanges(5, 2));
    }

    @Test
    @Order(4)
    void generate_wordsInRanges(){
        expectedRanges.add(expectedRange1);
        expectedRanges.add(expectedRange2);
        Map<Range, Integer> expected = new HashMap<>();
        expected.put(expectedRange1, 5);
        assertEquals(expected, histogramUnderTest.generate("Hello lkk k 44 hello hello", expectedRanges));
    }

    


}

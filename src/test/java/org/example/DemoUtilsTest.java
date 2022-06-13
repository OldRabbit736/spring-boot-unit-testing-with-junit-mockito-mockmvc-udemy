package org.example;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @DisplayName("Multiply")
    @Test
    void testMultiply() {
        assertEquals(12, demoUtils.multiply(4, 3), "4*3 must be 12");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    @Order(-1)
    void testEqualsAndNotEquals() {

        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1 + 9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {

        assertNull(demoUtils.checkNull(null), "Object should be null");
        assertNotNull(demoUtils.checkNull("null"), "Object should be null");
    }

    @Test
    @DisplayName("Same and Not Same")
    void testSameAndNotSame() {

        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to the same object.");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @Test
    @DisplayName("True and False")
    void testTrueFalse() {

        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be equal");
    }

    @Test
    @DisplayName("Iterable Equals")
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");

        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be equal to the actual list");
        assertNotSame(theList, demoUtils.getAcademyInList());
    }

    @Test
    @DisplayName("Lines Match")
    void testLinesMatch() {
        // expected
        List<String> theList = List.of("luv", "2", "code");

        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @Test
    @DisplayName("Throws and Does Not Throw")
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> {
            demoUtils.throwException(-1);
        }, "Should throw exception");

        assertDoesNotThrow(() -> {
            demoUtils.throwException(0);
        }, "Should not throw exception");
    }

    @Test
    @DisplayName("Timeout")
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            demoUtils.checkTimeout();
        }, "Method should execute in 3 seconds");
    }

//    @AfterEach
//    void tearDownAfterEach() {
//        System.out.println("Running @AfterEach");
//        System.out.println();
//    }
//
//    @BeforeAll
//    static void setupBeforeAll() {
//        System.out.println("@BeforeAll executes only once before all test methods in the class");
//        System.out.println();
//    }
//
//    @AfterAll
//    static void tearDownAfterAll() {
//        System.out.println("@AfterAll executes only once after all test methods in the class");
//    }
}
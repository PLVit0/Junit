package pl.kurs.range;

import org.junit.*;

import static org.junit.Assert.*;

public class RangeTest {

    private Range range;

    @Before
//    @After
//    @BeforeClass
//    @AfterClass
    public void init() throws IncorrectRange {
        range = new Range(10, 20);
    }

    @Test
    public void shouldReturnTrueWhenNumberIsInTheRange() {
        assertTrue(range.isInTheRange(15));
    }

    @Test
    public void shouldReturnFalseWhenNumberIsOutOfTheRange() {
        assertFalse(range.isInTheRange(21));
    }

    @Test
    public void shouldReturnCorrectRangeFromOnGetRangeFrom() {
        assertEquals(10, range.getRangeFrom());
    }

    @Test
    public void shouldReturnIncorrectRangeFromOnGetRangeFrom() {
        assertNotEquals(7, range.getRangeFrom());
    }

    @Test
    public void shouldCompareTwoDoubles() {
        double a = 3.47;
        double b = 3.47;
        assertEquals(a,b, 0.1);
    }

    @Test
    public void shouldRangeBeNull() {
        Range range = null;
        assertNull(range);
    }

    @Test
    public void shouldRangeNotBeNull() {
        assertNotNull(range);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenRangeIsNotCorrect() throws IncorrectRange {
        Range range1 = new Range(20, 10);
    }



}
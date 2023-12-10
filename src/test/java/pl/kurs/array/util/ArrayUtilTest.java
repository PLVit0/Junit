package pl.kurs.array.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {
    private int[] tab;
    private int[] emptyTab;
    private ArrayUtil arrayUtil;

    @Before
    public void init() {
        tab = new int[]{1, 2, 3, 4, 5};
        emptyTab = new int[]{};
        arrayUtil = new ArrayUtil();
    }

    @Test
    public void didSumSumCorrectly() throws ArrayIsNull {
        assertEquals(15, arrayUtil.sumArrays(tab));
    }

    @Test
    public void ifExpected15didSumSumCorrectlyIfWePutExpectedHigher() throws ArrayIsNull {
        assertNotEquals(16, arrayUtil.sumArrays(tab));
    }

    @Test
    public void ifExpected15didSumSumCorrectlyIfWePutExpectedLower() throws ArrayIsNull {
        assertNotEquals(14, arrayUtil.sumArrays(tab));
    }

    @Test //(expected = ArrayIsNull.class)
    public void testSumArraysWhenArrayIsNull() {
//        int[] array = null;
//        assertNull(arrayUtil.sumArrays(array));
        assertThrows(ArrayIsNull.class, () -> arrayUtil.sumArrays(null));
    }

    @Test
    public void testSumArraysWhenArrayIsEmpty() throws ArrayIsNull {
        assertEquals(0, arrayUtil.sumArrays(emptyTab));
    }

    @Test
    public void didMultiplyMultiplyCorrectly() throws ArrayIsNull {
        assertEquals(120, arrayUtil.productArrays(tab));
    }

    @Test
    public void ifExpected120didMultiplyMultiplyCorrectlyIfWePutExpectedHigher() throws ArrayIsNull {
        assertNotEquals(121, arrayUtil.productArrays(tab));
    }

    @Test
    public void ifExpected15didMultiplyMultiplyCorrectlyIfWePutExpectedLower() throws ArrayIsNull {
        assertNotEquals(119, arrayUtil.productArrays(tab));
    }

    @Test
    public void testMultiplyArrayWhenArrayIsEmpty() throws ArrayIsNull {
        assertEquals(1, arrayUtil.productArrays(emptyTab));
    }

    @Test //(expected = ArrayIsNull.class)
    public void testMulpiplyArraysWhenArrayIsNull() {
//        int[] array = null;
//        assertNull(arrayUtil.productArrays(array));
        assertThrows(ArrayIsNull.class, () -> arrayUtil.productArrays(null));
    }

}
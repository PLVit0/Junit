package pl.kurs.array.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {
    private int[] tab;
    private ArrayUtil arrayUtil;

    @Before
    public void init(){
        tab = new int[]{1, 2, 3, 4, 5};
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

    @Test(expected = ArrayIsNull.class)
    public void testSumArraysWhenArrayIsNull() throws ArrayIsNull {
        int[] array = null;
        assertNull(arrayUtil.sumArrays(array));
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

    @Test(expected = ArrayIsNull.class)
    public void testMulpiplyArraysWhenArrayIsNull() throws ArrayIsNull {
        int[] array = null;
        assertNull(arrayUtil.productArrays(array));
    }






}
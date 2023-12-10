package pl.kurs.array.util;


public class ArrayUtil {

    // napisz metody ktore:
    // sumuja tablice liczb
    // licza iloczyn tablicy liczb
    // obsluz przypadki gdy tablica jest nullem

    public int sumArrays(int[] array) throws ArrayIsNull {
        if (array == null) {
            throw new ArrayIsNull("Array is Null!");
        }
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public int productArrays(int[] array) throws ArrayIsNull {
        if (array == null) {
            throw new ArrayIsNull("Array is Null!");
        }
        int product = 1;
        for (int i : array) {
            product *= i;
        }
        return product;
    }
}

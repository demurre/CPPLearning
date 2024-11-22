import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testCreateRandomArray() {
        int[] array = Main.createRandomArray(10);
        assertEquals(10, array.length, "Array must contain 10 elements");

        for (int value : array) {
            assertTrue(value >= 1 && value <= 10, "Each element of the array must be in the range from 1 to 10");
        }
    }

    @Test
    public void testModifyArray() {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Main.modifyArray(array);

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                assertEquals(-1, array[i], "Values on even indexes must be -1");
            } else {
                assertNotEquals(-1, array[i], "Values on odd indexes must not be -1");
            }
        }
    }

    @Test
    public void testPrintArray() {
        int[] array = { 1, -1, 3, -1, 5, -1, 7, -1, 9, -1 };

        assertDoesNotThrow(() -> Main.printArrayFor(array), "Method printArrayFor should not throw exceptions");
        assertDoesNotThrow(() -> Main.printArrayWhile(array), "Method printArrayWhile should not throw exceptions");
    }
}

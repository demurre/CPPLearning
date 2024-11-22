import java.util.Random;

public class Main {
    public static int[] createRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10) + 1;
        }
        return array;
    }

    public static void modifyArray(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            array[i] = -1;
        }
    }

    public static void printArrayFor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printArrayWhile(int[] array) {
        int i = 0;
        while (i < array.length) {
            System.out.print(array[i] + " ");
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(10);
        System.out.println("Original array:");
        printArrayFor(array);

        modifyArray(array);

        System.out.println("Modified array (cycle for):");
        printArrayFor(array);

        System.out.println("Modified array (cycle while):");
        printArrayWhile(array);
    }
}

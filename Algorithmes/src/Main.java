import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int[] sortedArray = new int[30];
    static final int[] randomArray = new int[30];
    static final int[] invertArray = new int[30];
    static final int[] bigRndArray = new int[32768];

    public static void main(String[] args) {


        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;
        }

        for (int i = 0; i < invertArray.length; i++) {
            invertArray[i] = (invertArray.length - 1) - i;
        }

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * 100);
        }

        for (int i = 0; i < bigRndArray.length; i++) {
            bigRndArray[i] = (int) (Math.random() * 100);
        }

        insertionSortResearch();
        System.out.println();
        binaryInsertionSortResearch();
        System.out.println();
        bubbleSortResearch();
        System.out.println();
        shellSortResearch();
    }

    static void insertionSortResearch() {
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();
        int[] tmpBigRndArray = bigRndArray.clone();

        System.out.println("Сортировка вставками");
        System.out.println("Массив случайных чисел: " + printArray(tmpRandomArray));
        Sorts.insertionSort(tmpRandomArray);
        System.out.println(Arrays.toString(tmpRandomArray));
        System.out.println();

        System.out.println("Отсортированный массив: " + printArray(tmpSortedArray));
        Sorts.insertionSort(tmpSortedArray);
        System.out.println(Arrays.toString(tmpSortedArray));
        System.out.println();

        System.out.println("Инвертированный массив: " + printArray(tmpInvertArray));
        Sorts.insertionSort(tmpInvertArray);
        System.out.println(Arrays.toString(tmpInvertArray));
        System.out.println();

        System.out.println("Массив случайных чисел большого размера (2^15)");
        Sorts.insertionSort(tmpBigRndArray);
    }

    static void bubbleSortResearch() {
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();
        int[] tmpBigRndArray = bigRndArray.clone();

        System.out.println("Сортировка пузырьком");
        System.out.println("Массив случайных чисел: " + printArray(tmpRandomArray));
        Sorts.bubbleSort(tmpRandomArray);
        System.out.println(Arrays.toString(tmpRandomArray));
        System.out.println();

        System.out.println("Отсортированный массив: " + printArray(tmpSortedArray));
        Sorts.bubbleSort(tmpSortedArray);
        System.out.println(Arrays.toString(tmpSortedArray));
        System.out.println();

        System.out.println("Инвертированный массив: " + printArray(tmpInvertArray));
        Sorts.bubbleSort(tmpInvertArray);
        System.out.println(Arrays.toString(tmpInvertArray));
        System.out.println();

        System.out.println("Массив случайных чисел большого размера (2^15)");
        Sorts.bubbleSort(tmpBigRndArray);
    }

    static void binaryInsertionSortResearch() {
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();
        int[] tmpBigRndArray = bigRndArray.clone();

        System.out.println("Сортировка бинарными вставками");
        System.out.println("Массив случайных чисел: " + printArray(tmpRandomArray));
        Sorts.insertionSortWithBinarySearch(tmpRandomArray);
        System.out.println(Arrays.toString(tmpRandomArray));
        System.out.println();

        System.out.println("Отсортированный массив: " + printArray(tmpSortedArray));
        Sorts.insertionSortWithBinarySearch(tmpSortedArray);
        System.out.println(Arrays.toString(tmpSortedArray));
        System.out.println();

        System.out.println("Инвертированный массив: " + printArray(tmpInvertArray));
        Sorts.insertionSortWithBinarySearch(tmpInvertArray);
        System.out.println(Arrays.toString(tmpInvertArray));
        System.out.println();

        System.out.println("Массив случайных чисел большого размера (2^15)");
        Sorts.insertionSortWithBinarySearch(tmpBigRndArray);
    }

    static void shellSortResearch() {
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();
        int[] tmpBigRndArray = bigRndArray.clone();

        System.out.println("Сортировка Шелла");
        System.out.println("Массив случайных чисел: " + printArray(tmpRandomArray));
        Sorts.shellSort(tmpRandomArray);
        System.out.println(Arrays.toString(tmpRandomArray));
        System.out.println();

        System.out.println("Отсортированный массив: " + printArray(tmpSortedArray));
        Sorts.shellSort(tmpSortedArray);
        System.out.println(Arrays.toString(tmpSortedArray));
        System.out.println();

        System.out.println("Инвертированный массив: " + printArray(tmpInvertArray));
        Sorts.shellSort(tmpInvertArray);
        System.out.println(Arrays.toString(tmpInvertArray));
        System.out.println();

        System.out.println("Массив случайных чисел большого размера (2^15)");
        Sorts.shellSort(tmpBigRndArray);
    }

    public static String printArray(int[] array) {
        String line = "Размер массива: " + array.length + ": [";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                line += array[i];
                break;
            }
            line += array[i] + ", ";
        }
        line += "]";
        return line;
    }
}

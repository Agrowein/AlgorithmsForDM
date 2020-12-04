import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int[] sortedArray = new int[15];
    static final int[] randomArray = new int[15];
    static final int[] invertArray = new int[15];

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
        binarySearchResearch(10);
        System.out.println();
        linearSearchResearch(10);
        System.out.println();
        insertionSortResearch();
        System.out.println();
        binaryInsertionSortResearch();
        System.out.println();
        bubbleSortResearch();
        System.out.println();
        shellSortResearch();
    }

    static void binarySearchResearch(int element) {
        int[] array = {1,3,2,4,6,5,7,8,9,11,10,13,12,14,15};
        Arrays.sort(array); // для бинарного поиска требуется отсортированный массив
        System.out.println(printArray(array));
        Searches.binarySearch(array, element);
        System.out.println("Поиск не существующего элемента");
        Searches.linearSearch(array, 100);
    }
    static void linearSearchResearch(int element) {
        int[] array = {1,3,2,4,6,5,7,8,9,11,10,13,12,14,15};
        System.out.println(printArray(array));
        Searches.linearSearch(array, element);
        System.out.println("Поиск не существующего элемента");
        Searches.linearSearch(array, 100);
    }

    static void insertionSortResearch() {
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();

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
    }

    static void bubbleSortResearch() {
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();

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
    }

    static void binaryInsertionSortResearch() {
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();

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

    }

    static void shellSortResearch() {
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();

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

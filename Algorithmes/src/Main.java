import graph.Graph;

import java.util.Arrays;

public class Main {
    static final int[] sortedArray = new int[16];
    static final int[] randomArray = new int[16];
    static final int[] invertArray = new int[16];

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
//        mergeResearch();
//        System.out.println();
//        quickResearch();

        graphResearch();

    }

    static void graphResearch() {
        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(7, 8);


        System.out.println("Обход в глубину:");
        graph.passInDeep(0);
        System.out.println("Операций: " + graph.getCount());

        System.out.println();

        System.out.println("Обход в ширину:");
        graph.passInWidth(0);
        System.out.println("Операций: " + graph.getCount());

    }

    static void mergeResearch() {
        Counter counter = new Counter(0,0);
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();

        System.out.println("Сортировка слиянием");
        System.out.println("Массив случайных чисел: " + printArray(tmpRandomArray));
        System.out.println(Arrays.toString(Sorts.mergeSort(tmpRandomArray, counter)));
        System.out.println("Проходов:" + counter.count + " Слияний: " + counter.swaps);
        System.out.println();
        counter.setCounterNull();

        System.out.println("Отсортированный массив: " + printArray(tmpSortedArray));
        System.out.println(Arrays.toString(Sorts.mergeSort(tmpSortedArray,counter)));
        System.out.println("Проходов:" + counter.count + " Слияний: " + counter.swaps);
        System.out.println();
        counter.setCounterNull();

        System.out.println("Инвертированный массив: " + printArray(tmpInvertArray));
        System.out.println(Arrays.toString(Sorts.mergeSort(tmpInvertArray, counter)));
        System.out.println("Проходов:" + counter.count + " Слияний: " + counter.swaps);
        System.out.println();
        counter.setCounterNull();
    }
    static void quickResearch() {
        Counter counter = new Counter(0,0);
        int[] tmpRandomArray = randomArray.clone();
        int[] tmpSortedArray = sortedArray.clone();
        int[] tmpInvertArray = invertArray.clone();

        System.out.println("Быстрая сортировка");
        System.out.println("Массив случайных чисел: " + printArray(tmpRandomArray));
        Sorts.quickSort(tmpRandomArray, 0, tmpRandomArray.length-1, counter);
        System.out.println(Arrays.toString(tmpRandomArray));
        System.out.println("Проходов:" + counter.count + " Замен: " + counter.swaps);
        System.out.println();

        System.out.println("Отсортированный массив: " + printArray(tmpSortedArray));
        Sorts.quickSort(tmpSortedArray, 0, tmpRandomArray.length-1, counter);
        System.out.println(Arrays.toString(tmpSortedArray));
        System.out.println("Проходов:" + counter.count + " Замен: " + counter.swaps);
        System.out.println();

        System.out.println("Инвертированный массив: " + printArray(tmpInvertArray));
        Sorts.quickSort(tmpInvertArray,0, tmpRandomArray.length-1, counter);
        System.out.println(Arrays.toString(tmpInvertArray));
        System.out.println("Проходов:" + counter.count + " Замен: " + counter.swaps);
        System.out.println();
    }

    static void binarySearchResearch(int element) {
        int[] array = {1,3,2,4,6,5,7,8,9,11,10,13,12,14,15};
        Arrays.sort(array); // для бинарного поиска требуется отсортированный массив
        System.out.println(printArray(array));
        Searches.binarySearch(array, element);
        System.out.println("Поиск не существующего элемента");
        Searches.binarySearch(array, 100);
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



    //Utils


    public static class Counter {
        public int swaps;
        public int count;

        public Counter(int swaps, int count) {
            this.swaps = swaps;
            this.count = count;
        }
        void setCounterNull() {
            this.swaps = 0;
            this.count = 0;
        }
    }

    public static String printArray(int[] array) {
        StringBuilder line = new StringBuilder("Размер массива: " + array.length + ": [");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                line.append(array[i]);
                break;
            }
            line.append(array[i]).append(", ");
        }
        line.append("]");
        return line.toString();
    }
}

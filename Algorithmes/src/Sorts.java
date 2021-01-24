import java.util.Arrays;

public class Sorts {

    public static void insertionSort(int[] array) {
        int count = 0;
        int swaps = 0;

        for (int left = 0; left < array.length; left++) {
            count++;
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                count++;
                if (value < array[i]) {
                    array[i + 1] = array[i];
                    swaps++;
                } else {
                    break;
                }

            }
            array[i + 1] = value;
        }

        System.out.println("Сравнений: " + count + " Перестановок: " + swaps + " ");
        
    }

    public static void insertionSortWithBinarySearch(int[] array) {
        int count = 0;
        int swaps = 0;

        if (array.length < 2)
            return;

        for (int i = 1; i < array.length; i++) {
            int lowIndex = 0;
            int highIndex = i;
            int b = array[i];

            while(lowIndex < highIndex) {
                int middle = lowIndex + (highIndex - lowIndex)/2;
                if (b < array[middle]) {
                    highIndex = middle;
                }
                else {
                    lowIndex = middle + 1;
                }
                count++;
            }

            for (int j = i; j != lowIndex; j--) {
                array[j] = array[j-1];
                swaps++;
                count++;
            }

            array[lowIndex] = b;
            count++;
        }
        System.out.println("Сравнений: " + count + " Перестановок: " + swaps + " ");
    }



    public static void bubbleSort(int[] array) {
        int count = 0;
        int swaps = 0;

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int tmp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = tmp;
                    isSorted = false;
                    swaps++;
                }
                count++;
            }
        }
        System.out.println("Сравнений: " + count + " Перестановок: " + swaps + " ");
    }

    public static void shellSort(int[] array) {
        int count = 0;
        int swaps = 0;
        int h = 1;
        while (h*3 < array.length)
            h = h * 3 + 1;

        while(h >= 1) {
            int length = array.length;
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    count++;
                    if (array[j] < array[j - h]) {
                        int temp = array[j];
                        array[j] = array[j - h];
                        array[j - h] = temp;
                        swaps++;
                    } else {
                        break;
                    }
                }
                count++;
            }
            h = h/3;
            count++;
        }
        System.out.println("Сравнений: " + count + " Перестановок: " + swaps + " ");
    }

    public static int[] mergeSort(int[] array, Main.Counter counter) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size, counter);
                counter.swaps++;
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

            System.out.println(Arrays.toString(currentSrc));
        }
        return currentSrc;
    }



    public static void quickSort(int[] arr, int from, int to, Main.Counter counter) {
        counter.count++;
        if (from < to) {

            int divideIndex = partition(arr, from, to, counter);

            printSortStep(arr, from, to, divideIndex);

            quickSort(arr, from, divideIndex - 1, counter);

            quickSort(arr, divideIndex, to, counter);
        }
    }



    //Utils

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
                              int destStart, int size, Main.Counter counter) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            counter.count++;
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static int partition(int[] arr, int from, int to, Main.Counter counter) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                counter.swaps++;
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(Arrays.toString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + Arrays.toString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + Arrays.toString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }


    private static void swap(int[] array, int index1, int index2) {
        int tmp  = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}

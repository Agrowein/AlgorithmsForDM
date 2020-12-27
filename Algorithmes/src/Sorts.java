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

    public static int[] mergeSort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }


    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
                                       int startIndex, int endIndex) {

        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    public static void quickSort(int[] array, int low, int high) {
        int count = 0;
        int swaps = 0;
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}

import java.util.Arrays;

public class Sorts {

    public static void insertionSort(int[] array) {
        int count = 0;
        int swaps = 0;

        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                    swaps++;
                } else {
                    break;
                }
                count++;
            }
            array[i + 1] = value;
            count++;
        }

        System.out.println("Число проходов: " + count + " Число перестановок: " + swaps + " ");
        
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
        System.out.println("Число проходов: " + count + " Число перестановок: " + swaps + " ");
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
            count++;
        }
        System.out.println("Число проходов: " + count + " Число перестановок: " + swaps + " ");
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
                    if (array[j] < array[j - h]) {
                        int temp = array[j];
                        array[j] = array[j - h];
                        array[j - h] = temp;

                        swaps++;
                    } else {
                        break;
                    }
                    count++;
                }
                count++;
            }
            h = h/3;
            count++;
        }
        System.out.println("Число проходов: " + count + " Число перестановок: " + swaps + " ");
    }
}

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
}

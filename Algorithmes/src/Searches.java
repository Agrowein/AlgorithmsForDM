public class Searches {
    public static int binarySearch(int arr[], int elementToSearch) {
        int count = 0;
        int firstIndex = 0;
        int lastIndex = arr.length - 1;


        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elementToSearch) {
                count++;
                System.out.println("Бинарный поиск. Искомый элемент: " + elementToSearch + " найден на позиции: " + middleIndex + " За " + count + " шага(ов)");
                return middleIndex;
            }
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

            count++;
        }
        System.out.println("Бинарный поиск. Элемент не найден");
        return -1;
    }


    public static int linearSearch(int arr[], int elementToSearch) {
        int count = 0;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch) {
                count++;
                System.out.println("Линейный поиск. Искомый элемент: " + elementToSearch + " найден на позиции: " + index + " За " + count + " шага(ов)");
                return index;
            }
            count++;
        }
        System.out.println("Линейный поиск. Элемент не найден");
        return -1;
    }

}

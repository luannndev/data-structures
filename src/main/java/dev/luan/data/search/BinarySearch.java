package dev.luan.data.search;

/**
 * This class provides methods for performing binary search on an array of integers.
 * It contains a main method that demonstrates the usage of the search method.
 * Additionally, it includes a naiveSuche method, which performs a linear search on the array.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Index: " + search(numbers, 6));
    }

    /**
     * Performs a linear search on an array of integers to find the specified value.
     *
     * @param numbers the array of integers to search through
     * @param value the value to search for in the array
     * @return the index of the value in the array if found, or -1 if the value is not present
     */
    private static int naiveSuche(int[] numbers, int value) {
        int index = 0;
        for (int number : numbers) {
            if (number == value) {
                return index;
            }
            index++;
        }
        return -1;
    }


    /**
     * Performs a binary search on an array of integers to find the specified value.
     *
     * @param numbers the array of integers to search through in ascending order
     * @param value the value to search for in the array
     * @return the index of the value in the array if found, or -1 if the value is not present
     */
    private static int search(int[] numbers, int value) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] == value) {
                return mid;
            } else if (numbers[mid] < value) {
                low = ++mid;
            } else if (numbers[mid] > value) {
                high = --mid;
            }
        }
        return -1;
    }

}
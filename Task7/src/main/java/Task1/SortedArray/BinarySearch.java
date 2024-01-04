package Task1.SortedArray;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int binarySearchImpl(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int stepsCounter = 0;

        while (low <= high) {
            stepsCounter++;
            int mid = (low + high) / 2;

            if (array[mid] == target) { // To compare index where element can be stored with element values
                System.out.println("Amount of steps is : " + stepsCounter);
                return mid; // Element found
            }
            else if (array[mid] < target) {
                low = mid + 1; // Search in the right half
            }
            else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Element not found
    }
}


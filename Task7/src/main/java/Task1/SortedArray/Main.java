package Task1.SortedArray;

import java.util.Arrays;
import java.util.Scanner;

import static Task1.SortedArray.BinarySearch.binarySearchImpl;
import static java.util.Arrays.binarySearch;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

        System.out.print("Enter the number to find: ");
        int target = scanner.nextInt();

        int index = binarySearchImpl(sortedArray, target);

        // Display the result
        if (index != -1) {
            System.out.println("Number " + target + " found at index " + index);
        } else {
            System.out.println("Number " + target + " not found in the array");
        }
    }
}

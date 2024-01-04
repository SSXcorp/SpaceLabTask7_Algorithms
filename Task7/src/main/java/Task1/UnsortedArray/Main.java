package Task1.UnsortedArray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static Task1.UnsortedArray.Search.linearSearch;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100); // Предполагаем, что числа в массиве не превышают 100
        }

        System.out.println("Array: " + Arrays.toString(array));

        System.out.print("Enter the number to find: ");
        int target = scanner.nextInt();

        int index = linearSearch(array, target);
        if (index != -1) {
            System.out.println("Number " + target + " found at index: " + index);
            System.out.println("Steps required " + index);
        } else {
            System.out.println("Number " + target + " not found.");
        }
    }
}

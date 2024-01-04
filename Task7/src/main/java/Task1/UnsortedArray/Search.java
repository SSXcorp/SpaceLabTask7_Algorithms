package Task1.UnsortedArray;

public class Search {

    static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {

                return i;
            }
        }
        return -1;
    }
}

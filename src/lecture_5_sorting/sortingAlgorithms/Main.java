package lecture_5_sorting.sortingAlgorithms;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        InsertionSort insertsort = new InsertionSort();

        int[] numbers = {9, 3, 6, 4, 2, 4, 7};

        insertsort.insertionsSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

package lecture_5_sorting.sortingAlgorithms;

public class InsertionSort{

    public void insertionsSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) { // Continue to the end of array and aslong as the current is less than.
                array[j + 1] = array[j]; // Shift
                j--;
            }
            array[j + 1] = current;
        }
    }
}

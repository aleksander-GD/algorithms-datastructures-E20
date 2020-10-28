package mandatory_assignments.assignment1;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {
    private final int CUTOFF = 10;
    private int counter;

    public int getCounter() {
        return counter;
    }

    private int quickSelect(int[] a, int left, int right, int k) {

        if (left + CUTOFF <= right) {
            int pivot = median3(a, left, right);

            // Begin partitioning
            int i, j;
            for (i = left, j = right - 1; ; ) {
                counter++;
                while (a[++i] < pivot)
                    counter++;
                while (pivot < a[--j])
                    counter++;
                if (i >= j)
                    break;
                swapReferences(a, i, j);
            }

            // Restore pivot
            swapReferences(a, i, right - 1);

            // Recurse; only this part changes
            if (k <= i)
                quickSelect(a, left, i - 1, k);
            else if (k > i + 1)
                quickSelect(a, i + 1, right, k);
        } else {
            // Do an insertion sort on the subarray
            insertionSort(a, left, right);

        }
        return a[k - 1];

    }
    private int median3(int[] a, int left, int right) {
        counter++;
        int center = (left + right) / 2;
        if (a[center] < a[left])
            swapReferences(a, left, center);
        if (a[right] < a[left])
            swapReferences(a, left, right);
        if (a[right] < a[center])
            swapReferences(a, center, right);
        // Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private void swapReferences(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public void insertionSort(int[] a, int low, int high) {
        for (int p = low + 1; p <= high; p++) {
            int tmp = a[p];
            int j;

            for (j = p; j > low && tmp < a[j - 1]; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }
    public static void main(String[] args) {

        int numItems = 10000;
        Random random = new Random(System.currentTimeMillis());
        int[] array = random.ints(numItems, 1, 5000).toArray();

        QuickSelect qs = new QuickSelect();
        int[] testarray = {1, 5, 2, 7, 4, 9, 11, 10, 3, 9, 66, 44, 88, 6};
        System.out.println(Arrays.toString(testarray));
        //System.out.println(qs.quickSelect(testarray, 0, testarray.length - 1, 12));
        System.out.println(qs.quickSelect(array, 0, array.length - 1, 1));
        System.out.println(qs.getCounter());
        System.out.println(Arrays.toString(testarray));
    }
}

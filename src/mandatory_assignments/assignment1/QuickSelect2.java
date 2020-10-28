package mandatory_assignments.assignment1;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class QuickSelect2 {
    private final int CUTOFF = 10;
    private int counter;

    public int getCounter() {
        return counter;
    }
    public void resetCounter() {
        this.counter = 0;
    }

    private int quickSelect(int[] a, int left, int right, int k) {
        if (left + CUTOFF <= right) {
            int pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i] < pivot)
                    counter++;
                while (a[--j] > pivot)
                    counter++;
                if (i >= j)
                    break;
                swapReferences(a, i, j);
            }

            // Restore pivot
            swapReferences(a, i, right - 1);

            // Recurse; only this part changes
            if (k == pivot)
                return a[k - 1];
            else if (k <= i)
                quickSelect(a, left, i - 1, k);
            else if (k > i + 1)
                quickSelect(a, i + 1, right, k);
        } else {
            // Do an insertion sort on the subarray
            insertionSort(a, left, right);
            return a[k - 1];

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
        counter++;
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public void insertionSort(int[] a, int low, int high) {
        for (int p = low + 1; p <= high; p++) {
            counter++;
            int tmp = a[p];
            int j;

            for (j = p; j > low && tmp < a[j - 1]; j--)
                counter++;
            a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {

        int numItems = 10000;
        Random random = new Random(System.currentTimeMillis());
        int[] array = random.ints(numItems, 1, 1000).toArray();
        System.out.println(Arrays.toString(array));
        QuickSelect2 qs = new QuickSelect2();
        int[] testarray = {1, 5, 2, 7, 4, 9, 11, 10, 3, 9, 66, 44, 88, 6};
        //System.out.println(Arrays.toString(testarray));
        //System.out.println(qs.quickSelect(testarray, 0, testarray.length - 1, 12));
        System.out.println(qs.quickSelect(array, 0, array.length - 1, 500));
        System.out.println(qs.getCounter());
        System.out.println(Arrays.toString(array));
        //System.out.println(Arrays.toString(testarray));
        qs.resetCounter();
        TreeMap<Integer, Integer> dataXY = new TreeMap<>();
        for (int k = 10; k < numItems; k = k + 10) {
            qs.quickSelect(array, 0, array.length - 1, k);
            dataXY.put(k, qs.getCounter());
            qs.resetCounter();
        }
        System.out.println(Arrays.asList(dataXY));
    }
}

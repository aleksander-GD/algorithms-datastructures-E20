package mandatory_assignments.assignment1;

import java.util.*;

public class QuickSelect {
    private final int CUTOFF = 10;
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        this.counter = 0;
    }

    private int quickSelectForSmallestKth(int[] a, int left, int right, int k) {
        if (left + CUTOFF > right) {
            insertionSort(a, left, right);
        } else {
            int pivot = median3(a, left, right);

            // Patitioneringen sker her
            int i = left, j = right - 1;
            while (true) {
                while (a[++i] < pivot) {
                    counter++;
                }
                while (a[--j] > pivot) {
                    counter++;
                }
                if (i >= j) {
                    break;
                }
                swapReferences(a, i, j);
            }

            // Restore pivot
            swapReferences(a, i, right - 1);

            // Recurse; only this part changes
            if (k == pivot) {
                return a[k - 1];
            }
            if (k <= i) {
                quickSelectForSmallestKth(a, left, i - 1, k);
            } else if (k > i + 1) {
                quickSelectForSmallestKth(a, i + 1, right, k);

            }
            return a[k - 1];
        }
        return a[k - 1];
    }

    private int median3(int[] a, int left, int right) {
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

    public void insertionSort(int[] a, int left, int right) {
        for (int p = left + 1; p <= right; p++) {
            int tmp = a[p];
            int j;

            for (j = p; j > left && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
                counter++;
            }
            a[j] = tmp;
            counter++;
        }
    }

    public static void main(String[] args) {

        int numItems = 10000;
        int numberOfRuns = 200;
        int testCasesForAverage = 300;

        Utility u = new Utility();
        TreeMap<Integer, Integer> dataXY = new TreeMap<>();
        TreeMap<Integer, Integer> nResult = new TreeMap<>();
        ArrayList<Integer> data = new ArrayList<>();
        dataXY.put(0, 0); // Så det kan navngives i R, se evt. Rscript
        nResult.put(0, 0); // Så det kan navngives i R, se evt. Rscript

        for (int i = 0; i <= numberOfRuns; i++) {
            if (i > 0) {
                System.out.println(Arrays.toString(data.toArray()));
                System.out.println("numitems: " + numItems);
                System.out.println("k = N size/2 := " + numItems / 2);
                System.out.println("Average: " + data.stream().mapToInt(a -> a).sum() / data.size());
                dataXY.put(numItems, data.stream()
                        .mapToInt(a -> a)
                        .sum() / data.size());
                nResult.put(numItems, numItems);
                numItems = numItems + 10000;
                data.clear();
            }
            for (int j = 0; j <= testCasesForAverage; j++) {
                QuickSelect qs = new QuickSelect();
                int[] array = u.randomNumbers(numItems);
                qs.quickSelectForSmallestKth(array, 0, array.length - 1, numItems / 2);
                data.add(qs.getCounter());
                qs.resetCounter();
            }
        }
        u.writeCSVInt("dataNAverage", dataXY);
        u.writeCSVInt("dataN", nResult);

        System.out.println(Arrays.asList(dataXY));
        System.out.println(Arrays.asList(nResult));
    }
}

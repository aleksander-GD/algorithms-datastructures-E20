package mandatory_assignments.assignment1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PriorityQueue {
    private int currentSize;
    private int[] array;
    private int counter;

    public PriorityQueue(int[] items) {
        currentSize = items.length;
        array = new int[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (int item : items)
            array[i++] = item;
        buildHeap();
    }

    public int getCounter() {
        return this.counter;
    }

    public void resetCounter() {
        this.counter = 0;
    }

    public void setCounter(int c) {
        this.counter = c;
    }

    public int[] getArray() {
        return this.array;
    }

    public int findMin() {
        if (isEmpty())
            throw new RuntimeException("error");
        counter++;
        return array[1];
    }

    // Ikke ændre på arrayet men slet indtil det k-th mindste tal og så load arrayed in igen
    // så det ikke bliver ændret på men kun finder kth element. Det samme gælder currentSize at den
    // bliver sat tilbage til default
    public int findKthminitem(int k) {
        int minElement = 0;
        int[] temparray = array.clone();
        for (int i = 0; i < k; i++) {
            counter++;
            minElement = deleteMin();
        }
        array = temparray;
        currentSize = temparray.length - 1;
        return minElement;
    }

    public int deleteMin() {

        if (isEmpty()) {
            throw new RuntimeException("error");
        }
        int minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void percolateDown(int hole) {
        int child;
        int tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            counter++;
            child = hole * 2;
            if (child != currentSize && array[child + 1] < array[child])
                child++;
            if (array[child] < tmp)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

    // Test program
    public static void main(String[] args) {

        int numItems = 10000;
        int numberOfRuns = 100;
        int testCasesForAverage = 100;
        Utility u = new Utility();
        TreeMap<Integer, Integer> dataXY = new TreeMap<>();
        TreeMap<Integer, Double> nlognresult = new TreeMap<>();
        ArrayList<Integer> data = new ArrayList<>();
        dataXY.put(0, 0); // Så det kan navngives i R, se evt. Rscript
        nlognresult.put(0, 0.0); // Så det kan navngives i R, se evt. Rscript
        for (int i = 0; i <= numberOfRuns; i++) {
            if (i > 0) {
                System.out.println(Arrays.toString(data.toArray()));
                System.out.println("numitems: " + numItems);
                System.out.println("k = N size - 1 :=  " + (numItems - 1));
                System.out.println("Average: " + data.stream().mapToInt(a -> a).sum() / data.size());
                dataXY.put(numItems, data.stream()
                        .mapToInt(a -> a)
                        .sum() / data.size());
                nlognresult.put(numItems, u.calculateNLogN(numItems));
                numItems = numItems + 10000;
                data.clear();
            }
            for (int j = 0; j <= testCasesForAverage; j++) {
                int[] array = u.randomNumbers(numItems);
                PriorityQueue h = new PriorityQueue(array);
                int initialBuildCount = h.getCounter();
                h.findKthminitem(array.length - 1);
                data.add(h.getCounter());
                h.resetCounter();
                h.setCounter(initialBuildCount);
            }
        }
        u.writeCSVInt("dataNLogNAverage", dataXY);
        u.writeCSVDouble("dataNLogN", nlognresult);

        System.out.println(Arrays.asList(dataXY));
        System.out.println(Arrays.asList(nlognresult));
    }
}


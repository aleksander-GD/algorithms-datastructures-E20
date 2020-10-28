package mandatory_assignments.assignment1;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PriorityQueue {
    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;      // Number of elements in heap
    private int[] array; // The heap array
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

    public void setCounter(int counter) {
        this.counter = counter;
    }


    public void resetCounter() {
        this.counter = 0;
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

    private double calculateNLogN(int n) {
        return n * log(n, 2);
    }

    private double log(int x, int base) {
        return (Math.log(x) / Math.log(base));
    }

    private static String printArray(int[] arr) {
        return Arrays.toString(arr);
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "currentSize=" + currentSize +
                ", array=" + Arrays.toString(array) +
                ", counter=" + counter +
                '}';
    }

    // Test program
    public static void main(String[] args) throws UnderflowExeption {
        int numItems = 10000;
        PriorityQueue h;
        Random random = new Random(System.currentTimeMillis());
        int[] array = random.ints(numItems, 1, 500).toArray();

        h = new PriorityQueue(array);

        System.out.println("N*LogN: " + h.calculateNLogN(array.length));
        int initialBuildCount = h.getCounter();
        System.out.println("Initial build count: " + initialBuildCount);

        TreeMap<Integer, Integer> dataXY = new TreeMap<>();
        for (int k = 1000; k < numItems; k = k + 500) {
            h.findKthminitem(k);
            dataXY.put(k, h.getCounter());
            h.resetCounter();
            h.setCounter(initialBuildCount);
            // Et tjek for at få worst case med i eksperimentet
            if (k == 9500) {
                h.setCounter(initialBuildCount);
                h.findKthminitem(9999);
                dataXY.put(9999, h.getCounter());
            }
        }

        System.out.println(Arrays.asList(dataXY));
        String eol = System.getProperty("line.separator");

        try (FileWriter writer = new FileWriter("datafile.csv");) {
            for (Map.Entry<Integer, Integer> entry : dataXY.entrySet()) {
                writer.append(String.valueOf(entry.getKey()))
                        .append(',')
                        .append(String.valueOf(entry.getValue()))
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}


package lecture_2_stack_and_queue;

public class QueueExercise {

    private int[] queue = new int[8];
    private int currentSize = queue.length;
    private int front = 0;
    private int back = 0;

    public QueueExercise() {
        initialState();
    }

    public int[] getQueue() {
        return this.queue;
    }

    private void initialState() {
        queue[7] = 4;
        queue[6] = 2;
        front = 7;
        back = 8;
    }

    private void checkIfFull() {
        if (front == currentSize) {
            front = 0;
        }
        if (back == currentSize) {
            back = 0;
        }
    }

    public void enqueue(int n) {
        this.checkIfFull();
        queue[back] = n;
        back++;
        currentSize++;
    }

    public int dequeue() {
        int dequeuedItem = queue[front - 1];
        currentSize--;
        this.checkIfFull();
        front++;
        return dequeuedItem;
    }
}

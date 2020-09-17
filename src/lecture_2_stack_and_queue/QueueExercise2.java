package lecture_2_stack_and_queue;

public class QueueExercise2 {

    private int[] queue = new int[8];
    private int size = queue.length;
    private int front = 0;
    private int back = 0;

    public QueueExercise2() {

    }

    public int[] getQueue() {
        return this.queue;
    }

    private boolean checkIfFull() {
        if (front == size) {
            return true;
        }
        return false;
    }

    public void enqueue(int n) {
        if (!this.checkIfFull()) {
            queue[back] = n;
            back = (back + 1) % queue.length;
            size++;
        }
    }

    public int dequeue() {
        if (!this.checkIfFull()) {
            int dequeuedItem = queue[front];
            queue[front] = 0;
            front = (front + 1) % queue.length;
            size--;
            return dequeuedItem;
        } else {
            return -1;
        }
    }
}

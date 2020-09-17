package lecture_2_stack_and_queue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StackExercise stackExercise = new StackExercise();


        System.out.println( stackExercise.balancedPairBrackets("(()"));
        System.out.println( stackExercise.balancedPairBrackets("(("));
        System.out.println( stackExercise.balancedPairBrackets(")("));
        System.out.println( stackExercise.balancedPairBrackets("()"));
        System.out.println( stackExercise.balancedPairBrackets("(())") + "\n");

        System.out.println( stackExercise.balancedPairBrackets("[[]"));
        System.out.println( stackExercise.balancedPairBrackets("[["));
        System.out.println( stackExercise.balancedPairBrackets("]["));
        System.out.println( stackExercise.balancedPairBrackets("[]"));
        System.out.println( stackExercise.balancedPairBrackets("[[]]") + "\n");

        QueueExercise queueExercise = new QueueExercise();

        System.out.println(Arrays.toString(queueExercise.getQueue()));
        queueExercise.enqueue(1);
        System.out.println(Arrays.toString(queueExercise.getQueue()));
        queueExercise.enqueue(3);
        System.out.println(Arrays.toString(queueExercise.getQueue()));
        System.out.println(queueExercise.dequeue());
        System.out.println(Arrays.toString(queueExercise.getQueue()));
        System.out.println(queueExercise.dequeue());
        System.out.println(Arrays.toString(queueExercise.getQueue()));
        System.out.println(queueExercise.dequeue());
        System.out.println(Arrays.toString(queueExercise.getQueue()));
        System.out.println(queueExercise.dequeue());
        System.out.println(Arrays.toString(queueExercise.getQueue()));
        System.out.println("--------------------");
        QueueExercise2 queueExercise2 = new QueueExercise2();

        queueExercise2.enqueue(6);
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        queueExercise2.enqueue(9);
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        queueExercise2.enqueue(23);
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        queueExercise2.enqueue(10);
        queueExercise2.enqueue(4);
        queueExercise2.enqueue(44);
        queueExercise2.enqueue(11);
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        queueExercise2.enqueue(1);
        queueExercise2.enqueue(7);
        queueExercise2.enqueue(4);
        queueExercise2.enqueue(17);
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
        System.out.println(Arrays.toString(queueExercise2.getQueue()));
        System.out.println(queueExercise2.dequeue());
    }
}

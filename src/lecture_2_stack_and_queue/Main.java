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
        System.out.println( stackExercise.balancedPairBrackets("[[]]"));

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
    }
}

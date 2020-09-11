package lecture_2_stack_and_queue;

import java.util.Stack;

public class StackExercise {


    public boolean balancedPairBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == '(' || character == '[') {
                stack.push(character);
            } else if (character == ')' || character == ']') {
                if (stack.empty()) {
                    return false;
                }
                char poppedChar = (char) stack.pop();

                if (poppedChar != '(' && poppedChar != '[') {
                    return false;
                }

            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;

    }

}



package other;

import java.util.Arrays;

public class ShortestWord {
    public static void main(String[] args) {
        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps"));
        System.out.println(findShort("turns out random test cases are easier ib than writing out basic ones"));
    }
    public static int findShort(String s) {
        String[] wordArray = s.toLowerCase().split(" ");

        int smallest = wordArray[0].toCharArray().length;

        for (int i = 0; i < wordArray.length; i++) {
            int current = wordArray[i].toCharArray().length;
            if (current < smallest) {
                smallest = current;
            }
        }
        return smallest;
    }
}

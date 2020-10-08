package other;

import java.util.Arrays;

public class HighAndLow {
    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
    public static String highAndLow(String numbers) {
         int[] seperatedNumbers = Arrays.stream(numbers.split(" "))
                 .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(seperatedNumbers);
        return seperatedNumbers[seperatedNumbers.length - 1] + " " + seperatedNumbers[0];
    }
}

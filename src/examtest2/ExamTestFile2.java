package examtest2;

import java.util.*;

public class ExamTestFile2 {

    /*

    Write a recursive method/algorithm with the following signature:
    int getNumberEqual(int[] x, int n, int val);
    The algorithm returns the number of occurrences of a certain integer (parameter val) in an integer array (parameter x)Parameter n is the number of elements in the array.
    Called with the array {7,4,1,3,5,6,4,8} , n=8, and val=4, the correct return value is 2.
     */
    static int countOccurences = 0;

    static int getNumberEqual(int[] x, int n, int val) {

        if (n <= 0) {
            int returnValue = countOccurences;
            countOccurences = 0;
            return returnValue;
        } else if (val == x[n - 1]) {
            countOccurences++;
            return getNumberEqual(x, n - 1, val);
        } else {
            return getNumberEqual(x, n - 1, val);
        }
    }
   /*
    Write an algorithm that takes a string as input and returns the most frequently occurring word contained in the string. The string is plain text (small and capital letters),
    and words are separated with blanks, commas and full stops and combinations of these
    (see example below – you may assume that there is always a blank between two words and that the last character is always a full stop).
    Words are considered the same, even if some occurrences begin with a small letter and others with a capital letter.
    You may assume as a precondition for your algorithm that the input parameter can only contain small letters [a-z] capital letters [A-Z], blanks, commas (,) and full stops (.).
    Example:
    {The cattle were running back and forth, but there was no wolf to be seen, heard or smelled, so the shepherd decided to take a little nap in a bed of grass and early summer flowers.
    Soon he was awakened by a sound he had never heard before.}
    The correct answer in the example is the word a, which occurs three times.
    Your algorithm must be optimized for running time efficiency, and you must provide a Big-Oh running time of your solution.
    */

    static int countWordOccurence(String text, String wordToLookFor) {
        String[] words = text.split(" ");   // O(1)
        int count = 0;  // O(1)
        for (int i = 0; i < words.length; i++) {    // O(n)
            if (words[i].equalsIgnoreCase(wordToLookFor)) { // O(1)
                count++;    // O(1)
            }
            if ((words[i].contains(".") && words[i].split("\\.")[0].equalsIgnoreCase(wordToLookFor))
                    || words[i].contains(",") && words[i].split(",")[0].equalsIgnoreCase(wordToLookFor)) {  // O(1)
                count++;    // O(1)
            }
        }
        return count;
    }

    static String countWordOccurenceCorrectVersion(String text) {
        text = text.replaceAll("[.,]", "");           // O(1)
        String[] words = text.toLowerCase().split(" ");                // O(1)
        TreeMap<String, Integer> mapWordOccurences = new TreeMap<>();       // O(1)
        int count = 0;
        for (int i = 0; i < words.length; i++) {    // O(n)
            if (!mapWordOccurences.containsKey(words[i])) {
                mapWordOccurences.put(words[i], 1); // O(log(N)) for put
            } else {
                mapWordOccurences.replace(words[i], count = 1 + mapWordOccurences.get(words[i]));   // O(log(N)) for get
            }
        }
        return Collections.max(mapWordOccurences.entrySet(), Map.Entry.comparingByValue()).getKey(); // O(log(N)) for get
    }

    public static void main(String[] args) {
        int[] numberArray = {7, 4, 1, 3, 5, 6, 4, 8};
        System.out.println(getNumberEqual(numberArray, numberArray.length, 4));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        String text = "The cattle were running back and forth, but there was no wolf to be seen, heard or smelled, so the shepherd decided to take a little nap in a bed of grass and early summer flowers. Soon he was awakened by a sound he had never heard before.";
        //System.out.println(countWordOccurence(text, "flowers"));


        System.out.println(countWordOccurenceCorrectVersion(text));
    }
}

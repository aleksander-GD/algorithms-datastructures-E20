package lecture_5_sorting;

import java.util.Arrays;

/**
 * The words stale and least are anagrams,
 * i.e.they contain the exact same characters.
 * Write a method that can decide if two words (strings) are anagrams.
 */
public class Anagrams {

    public static void main(String[] args) {
        System.out.println(checkIfAnagram("stale", "least"));
        System.out.println(checkIfAnagram("silent", "lissen"));
        System.out.println(checkIfAnagram("silent", "silents"));
    }

    private static boolean checkIfAnagram(String word1, String word2) {
        char[] charsInWord1 = word1.trim().toLowerCase().toCharArray();
        char[] charsInWord2 = word2.trim().toLowerCase().toCharArray();
        Arrays.sort(charsInWord1);
        Arrays.sort(charsInWord2);

        if (charsInWord1.length != charsInWord2.length) {
            return false;
        }
        for (int i = 0; i < charsInWord1.length; i++) {
            if (charsInWord1[i] != charsInWord2[i]) {
                return false;
            }
        }
        return true;
    }


}

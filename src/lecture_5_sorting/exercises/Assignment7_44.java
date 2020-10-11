package lecture_5_sorting.exercises;

import java.util.Arrays;

/**
 * 7.44 Suppose you have an array of N elements containing only two distinct keys, true
 * and false. Give an O(N) algorithm to rearrange the list so that all false elements
 * precede (er foran) the true elements. You may use only constant extra space.
 */
public class Assignment7_44 {

    private static boolean[] boolArray = {true, false, true, true, false, false, false, true, false, true, true};
    private static boolean[] boolArray2 = {
            true, false, true, true, false, false, false, true, false, true, true,
            true, false, true, true, false, false, false, true, false, true, true};
    public static void main(String[] args) {
        System.out.println("Before sort: " + Arrays.toString(boolArray));
        rearrange(boolArray);
        System.out.println("After sort: " + Arrays.toString(boolArray));
        System.out.println("Before sort: " + Arrays.toString(boolArray2));
        rearrange(boolArray2);
        System.out.println("After sort: " + Arrays.toString(boolArray2));
    }

    private static void rearrange(boolean[] list) {
        int front = 0;
        int back = list.length - 1;
        boolean temp = false;

        while (front < back) {
            if (list[back] == false) {
                if (list[front] == true) {
                   temp = list[front];
                   list[front] = list[back];
                   list[back] = temp;
                   front++;
                   back--;
                } else {
                    front++;
                }
            } else {
                back--;
            }
        }
    }
}

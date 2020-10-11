package lecture_5_sorting.exercises;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * 7.38 Write a program that reads N points in a plane and outputs any group of four
 * or more colinear points (i.e., points on the same line). The obvious brute-force
 * algorithm requires O(N^4) time. However, there is a better algorithm that makes use
 * of sorting and runs in O(N^2 logN) time.
 * <p>
 * https://www.math.net/collinear
 */
public class Assignment7_38 {
    /*private static int[][] plane = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };*/
    private static int[][] plane;

    public static void main(String[] args) {
        plane = filled2dArray(8, 8);
        System.out.println(Arrays.deepToString(plane));
        colinearPoints(4);

    }

    private static String colinearPoints(int points) {

        for (int i = 0; i < plane.length; i++) {
            for (int j = 0; j < plane[i].length; j++) {
                if (i + j == plane[i].length) {
                    System.out.println(plane[i][j]);
                }
            }
        }
        throw new NotImplementedException();
    }

    private static int[][] filled2dArray(int rows, int columns) {

        int[][] tempArray = new int[rows][columns];
        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tempArray[i][j] = count++;
            }
        }
        return tempArray;
    }
}
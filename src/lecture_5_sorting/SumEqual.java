package lecture_5_sorting;

/**
 * A table holds N sorted numbers.
 * The task is to determine if the table contains two numbers whose sum is equal to the value of parameter x.
 * The method should be written in two versions: one with quadratic time complexity and one with linear.
 */
public class SumEqual {

    private static int[] sortedNum = {1, 4, 6, 10, 40, 60};

    public static void main(String[] args) {
        System.out.println(linearCheck(44, sortedNum));
        System.out.println(linearCheck(41, sortedNum));
        System.out.println(linearCheck(1, sortedNum) + "\n");

        System.out.println(linearChecker(44, sortedNum));
        System.out.println(linearChecker(1, sortedNum) + "\n");

        System.out.println(quadraticCheck(44, sortedNum));
        System.out.println(quadraticCheck(1, sortedNum));
        System.out.println(quadraticCheck(99, sortedNum));
        System.out.println(quadraticCheck(12, sortedNum));
    }

    // My own solution for linear check for pair sum equal to x
    private static boolean linearCheck(int checkSumX, int[] sortedArray) {
        int front = 0;
        int back = sortedArray.length - 1;

        for (int i = 0; i < sortedArray.length; i++) {
            int sum = sortedArray[front] + sortedArray[back];
            if (sum == checkSumX) {
                return true;
            }else if (sum < checkSumX) {
                front++;
            } else if (sum > checkSumX) {
                back--;
            }  else {
                front++;
                back--;
            }
        }
        return false;
    }

    // Other solution to the same problem.
    private static boolean linearChecker(int x, int[] array) {
        int front = 0;
        int back = array.length - 1;
        while (front < back) {
            int sum = array[front] + array[back];
            if (sum == x) {
                return true;
            } else if (sum < x) {
                front++;
            } else if (sum > x) {
                back--;
            }
        }
        return false;
    }

    private static boolean quadraticCheck(int checkSumX, int[] sortedArray) {
        int sum = 0;
        for (int i = 0; i < sortedNum.length; i++) {
            for (int j = i + 1; j < sortedNum.length; j++) {
                sum = sortedArray[i] + sortedArray[j];
                if (sum == checkSumX) {
                    return true;
                }
            }
        }
        return false;
    }
}

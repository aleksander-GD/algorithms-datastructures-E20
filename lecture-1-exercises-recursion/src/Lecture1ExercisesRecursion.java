public class Lecture1ExercisesRecursion {
    public static void main(String[] args) {
        System.out.println("The sum of the first 10 natural numbers is : " + sum(10));
        System.out.println("The sum of the squares of the even numbers in the first 5 numbers is: " + evenSquare(4));
        System.out.println("The fibonacci of 10 is: " + fib1(10));
        System.out.println("Find s in 'String': " + linear("string", 's', 5));
        System.out.println("Find x in 'String': " + linear("string", 'x', 5));
    }

    private static int sum(int n) {

        if (n == 0) {
            return n;
        } else {
            return sum(n - 1) + n;
        }
    }

    private static int evenSquare(int n) {

        int even = 0;
        if (n == 0) {
            return n;

        } else if ((n % 2) == 0) {
            return evenSquare(n - 1) + n * n;

        } else {
            return evenSquare(n - 1);
        }
    }

    private static int fib1(int n) {
        if (n == 0) // Base case
        {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib1(n - 1) + fib1(n - 2);
        }

    }

    private static boolean linear(String s, char c, int l) {

        if (s.charAt(l) == c) {
            return true;
        } else if (l == 0) {
            return false;
        } else {
            return linear(s, c, l - 1);
        }
    }

}

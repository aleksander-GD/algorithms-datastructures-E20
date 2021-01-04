package other;

import java.util.Arrays;

public class ProductOfConsecutiveFibNumbers {
    public static long[] productFib(long prod) {

        long prev = 0;
        long curr = 1;
        long multiplied = prev * curr;

        while (multiplied < prod) {
            long temp = curr;
            curr += prev;
            prev = temp;
            multiplied = prev * curr;
        }

        return new long[]{prev, curr, multiplied == prod ? 1 : 0};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productFib(800)));
    }
}

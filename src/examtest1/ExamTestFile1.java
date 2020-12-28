package examtest1;

import java.util.*;

public class ExamTestFile1 {
    static int counter = 0;
    static int length = 0;


    public static void main(String[] args) {
        myMethod(2000);
        /*
        Map<Integer, Long> countvalues = new TreeMap<>();
        int n = 10000;
        for (int i = 2000000; i > 0 ; i -= 10000) {
            countvalues.put(i,  myMethod(i));
        }
        System.out.println(Arrays.asList(countvalues));
        String eol = System.getProperty("line.separator");
        try (FileWriter writer = new FileWriter("test.csv");) {
            for (Map.Entry<Integer, Long> entry : countvalues.entrySet()) {
                writer.append(String.valueOf(entry.getKey()))
                        .append(',')
                        .append(String.valueOf(entry.getValue()))
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        System.out.println(counter);
        */

        int[] testarray = {5, 3, 8, 4, 1, 3, 5, 6, 4, 8};


        System.out.println(recLinSearch(testarray, 10, 2));
        System.out.println(recLinSearch(testarray, 10, 1));

        System.out.println(checkForLongestChain(13));
        System.out.println(addCountChain(13));

        System.out.println(pythTriplet(1000));
    }

    static long myMethod(int N) {
        int x = 0;
        for (int i = 1; i <= N; i++) {
            i = i * 2;
            counter++;
            for (int j = 1; j <= N; j++)
                for (int k = 1; k <= N; ) {
                    x++;
                    k *= 2;
                    counter++;
                }
        }
        return x;
    }

    static boolean recLinSearch(int[] x, int n, int val) {
        if (n <= 0) {
            return false;
        }
        if (val == x[n - 1]) {
            return true;
        }

        return recLinSearch(x, n - 1, val);

    }

    static int checkForLongestChain(int sequenceNumbers) {
        int checkHighest = 0;
        int current = 0;
        for (int i = 1; i < sequenceNumbers; i++) {
            current = addCountChain(i);

            if (current > checkHighest) {
                checkHighest = current;
            }
        }
        return checkHighest;
    }

    static int addCountChain(int n) {
        Queue<Integer> chain = new LinkedList();
        chain.add(n);

        while (n != 1) {
            if (n % 2 == 1) {
                n = n * 3 + 1;
                chain.add(n);
            }
            if ((n % 2) == 0) {
                n = n / 2;
                chain.add(n);
            }
        }

        System.out.println(Arrays.toString(chain.toArray()));
        return chain.size();
    }

    static int pythTriplet(int n) {
        /*
        b = a;
        if a, b (a <= b) and c are the Pythagorean triplet,
        then b, a (b >= a) and c - also the solution, so we can search only one case
        c = 1000 - a - b; It's one of the conditions of the problem (we don't need to scan all possible 'c': just calculate it)
         */
        int sum = n;
        int triplet = 0;
        int a;
        for (a = 1; a <= sum / 3; a++) {
            int b;
            for (b = a + 1; b <= sum / 2; b++) {
                int c = sum - a - b;
                if (a * a + b * b == c * c) {
                    //System.out.println(a + " " + b + " " + c + "   " + a * b * c);
                    triplet = a * b * c;
                }

            }
        }
        return triplet;
    }

}

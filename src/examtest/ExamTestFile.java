package examtest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ExamTestFile {
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

        int num = n;
        while (num != 1) {
            if (num % 2 == 1) {
                num = num * 3 + 1;
                chain.add(num);
            }
            if ((num % 2) == 0) {
                num = num / 2;
                chain.add(num);
            }
        }

        System.out.println(Arrays.toString(chain.toArray()));
        return chain.size();
    }


}

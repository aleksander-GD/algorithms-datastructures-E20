package algorithmAnalysis;

import java.util.PriorityQueue;

public class Analysis {
    static int count = 0;

    static void loop1(int n) {
        for (int i = 1; i < n; i++) {
            int j = 1;
            count++;
            while (j < i) {
                j = 2 * j;
                count++;
            }
        }

    }

    static void loop2(int n) {
        int i = 0;
        int j = 0;
        while (i < n) {
            if (j < n) {
                j = j + 1;
            } else {
                j = 0;
                i = i + 1;
            }
            count++;

        }
    }

    static void loop3(int n) {
        int i = 1;
        int s = i;
        while (s < n) {
            i = i + 1;
            s = s + i;
            count++;

        }
    }

    static void loop4(int n) {
        for (int i = 1; i < n; i++) {
            int s = 0;
            int j = 0;
            count++;
            while (s < i) {
                s = s + j;
                j = j + 1;
                count++;
            }
        }

    }

    static void loop5(int n) {
        int i = 1;
        while (i * i < n) {
            i = 2 * i;
            count++;
        }
    }

    static void loop6(int n) {
        for (int i = 0; i < n; i++) {
            int j = i;
            count++;
            while (j > 0) {
                j = j - 1;
                count++;
            }

        }
    }

    static void loop7(int n) {
        int i = 1;
        while (i < n * n) {
            i = 2 * i;
            count++;
        }
    }

    static void loop8(int n) {
        for (int i = 0; i < n; i++) {
            count++;
            for (int j = 0; j < i; j++) {
                count++;
                int k = 1;
                while (k < i + j) {
                    k = 2 * k;
                    count++;
                }

            }

        }
    }

    static void loop9(int n) {
        int i = 1;
        int j = 1;
        while (i < n) {
            while (j < i) {
                j = j + 1;
                count++;
            }
            i = i * 2;
            count++;
        }
    }

    static void loop10(int n) {
        int i = 1;
        while (i < n) {
            int j = 1;
            while (j < i) {
                j = j + 1;
                count++;
            }
            i = i * 2;
            count++;
        }
    }

    static void loop11(int n) {
        int i = 2;
        while (i < n) {
            i = i * i;
            count++;
        }
    }

    static void loop12(int n) {
        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                for (int k = 1; k < n; ) {
                    x++;
                    k *= 2;
                    count++;
                }
                count++;
            }
            count++;
        }
    }

    static void loop13(int N) {
        int x = 0;
        for (int i = 1; i <= N; i++) {
            i = i * 2;

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; ) {
                    x++;
                    k *= 2;
                    count++;
                }
                count++;
            }
            count++;
        }

    }

    public static void resetCount() {
        count = 0;
    }

    public static int log2(int N) {
        // calculate log2 N indirectly
        // using log() method
        int result = (int) (Math.log(N) / Math.log(2));

        return result;
    }

    /*
    Please be aware that there is a risk of mis-calculation due to imprecise floating-point arithmetic,
    as explained in this stackoverflow post.
    To completely get rid of errors, add an epsilon between 1e-11 and 1e-14 as shown below.
     */

    public static int log2Precise(int N) {
        return (int) (Math.log(N) / Math.log(2) + 1e-10);
    }

    public static void main(String[] args) {

        loop1(1024);
        System.out.println(count + "\n Calculated: " + log2(1024) * 1024);
        System.out.println();

        resetCount();
        loop2(1024);
        System.out.println(count + "\n Calculated: " + Math.pow(1024, 2));

        resetCount();
        loop3(1024);
        System.out.println(count + "\n Calculated: " + Math.sqrt(1024));

        resetCount();
        loop4(1024);
        System.out.println(count + "\n Calculated: " + Math.sqrt(1024) * 1024);

        resetCount();
        loop5(1024);
        System.out.println(count + "\n Calculated: " + log2(1024));

        resetCount();
        loop6(1024);
        System.out.println(count + "\n Calculated: " + Math.pow(1024, 2));

        resetCount();
        loop7(1024);
        System.out.println(count + "\n Calculated: " + log2(1024));

        resetCount();
        loop8(1024);
        System.out.println(count + "\n Calculated: " + Math.pow(1024, 2) * log2(1024));

        resetCount();
        loop9(1024);
        System.out.println(count + "\n Calculated: " + 1024);

        resetCount();
        loop10(1024);
        System.out.println(count + "\n Calculated: " + 1024);

        resetCount();
        loop11(1024);
        System.out.println(count + "\n Calculated: " + log2(log2(1024)));

        resetCount();
        loop12(1024);
        System.out.println(count + "\n Calculated: " + Math.pow(1024, 2) * log2(1024));

        resetCount();
        loop13(1024);
        System.out.println(count + "\n Calculated N*log(N^2): " + 1024 * log2((int) Math.pow(1024, 2)));
        System.out.println(count + "\n Calculated N*log(N)^2: " + 1024 * Math.pow(log2(1024), 2));
        /*
        Plus, the converter will accept either scientific or E notation (E or e represents "x 10^"):
        3.5E4
        3.5e4
        3.5 x 10^4

        And finally, you can select from a list of the most searched for scientific notation examples
        or standard notation examples and your selection will be converted and written out,
        while also displaying the steps used to make the conversion.
         */


    }
}

package other;

public class SumDigitDigitalRoot {

    public static void main(String[] args) {
        System.out.println(digital_root(9));
        System.out.println(digital_root(16));
        System.out.println(digital_root(456));
    }

    public static int digital_root(int n) {
        char[] convertedNumArray = String.valueOf(n).toCharArray();
        int sum = 0;
        if (n <= 9) return n;
        for (int i = 0; i < convertedNumArray.length; i++) {
            sum += Character.getNumericValue(convertedNumArray[i]);
        }
        return sum;
    }
}

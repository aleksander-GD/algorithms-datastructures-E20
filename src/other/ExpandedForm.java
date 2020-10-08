package other;

public class ExpandedForm {

    public static void main(String[] args) {
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(42));
        System.out.println(expandedForm(70304));
    }

    public static String expandedForm(int num) {
        if (num <= 0) return "Number lower or equal to 0";

        String output = "";
        for (int i = 10; i < num; i *= 10) {
            int remainder = num % i;
            if (remainder > 0) {
                output = " + " + remainder + output;
            }
            num -= remainder;
        }
        output = num + output;

        return output;
    }
}

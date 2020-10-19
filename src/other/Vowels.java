package other;

public class Vowels {
    public static void main(String[] args) {
        System.out.println(getCount("abracadabra"));
    }
    public static int getCount(String str) {
        int vowelsCount = 0;
        char[] vowelArray = {'a', 'e', 'i', 'o', 'u'};

        for(int i = 0; i < vowelArray.length; i++) {
            for (int j = 0; j < str.toCharArray().length; j++) {
                if (str.charAt(j) == vowelArray[i]) {
                    vowelsCount++;
                }
            }

        }
        return vowelsCount;
    }
}

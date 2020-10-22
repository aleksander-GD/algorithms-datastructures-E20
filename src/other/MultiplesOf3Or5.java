package other;

public class MultiplesOf3Or5 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(0));
        System.out.println(solution(-2));
    }

    public static int solution(int number) {
        if (number <= 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}

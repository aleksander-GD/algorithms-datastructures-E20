package lecture_3_ballsAndBins;

import java.util.Arrays;
import java.util.Random;

public class BallsAndBins {

    public static void main(String[] args) {
        int balls1 = 10007;
        int balls2 = 32749;
        int[] binForBallsbin1 = new int[10007];
        int[] binForBallsbin2 = new int[32749];
        int[] binForPowerOfTwo1 = new int[10007];
        int[] binForPowerOfTwo2 = new int[32749];

        System.out.println("Ballsbin with 10007 balls and bin size 10007 maxvalue: " +
                maxValue(ballsbin(balls1, binForBallsbin1)));
        System.out.println("Ballsbin with 32749 balls and bin size 32749 maxvalue: " +
                maxValue(ballsbin(balls2, binForBallsbin2)));
        System.out.println("PowerOfTwo with 10007 balls and bin size 10007 maxvalue: " +
                maxValue(powerOfTwo(balls1, binForPowerOfTwo1)));
        System.out.println("PowerOfTwo with 32749 balls and bin size 32749 maxvalue: " +
                maxValue(powerOfTwo(balls2, binForPowerOfTwo2)));
    }

    private static int[] ballsbin(int balls, int[] bin) {
        int count = 0;
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < balls; i++) {
            int randomIndex = rand.nextInt(balls);
            bin[randomIndex] += 1;
            count++;
        }
        //System.out.println("count: " + count);
        return bin;
    }

    public static int maxValue(int array[]) {
        int max = Arrays.stream(array).max().getAsInt();
        return max;
    }

    private static int[] powerOfTwo(int balls, int[] bin) {
        int count = 0;
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < balls; i++) {
            int randomIndex1 = rand.nextInt(balls);
            int randomIndex2 = rand.nextInt(balls);
            if (bin[randomIndex1] < bin[randomIndex2]) {
                bin[randomIndex1] += 1;
                count++;
            } else {
                bin[randomIndex2] += 1;
                count++;
            }
        }
        //System.out.println("count: " + count);
        return bin;
    }
}
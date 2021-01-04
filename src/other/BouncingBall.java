package other;

public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        int ball_seen = 0;
        System.out.println("h: " + h + "bounce: " + bounce + "window: " + window);
        if (h <= 0.0 || (bounce <= 0.0 || bounce >= 1.0) || window >= h) {
            return -1;
        } else {
            while (h > window) {
                if (h > window) {
                    ball_seen++;
                }
                h = h * bounce;
                if (h > window) {
                    ball_seen++;
                }
            }
        }
        return ball_seen;
    }

    public static void main(String[] args) {
        System.out.println(bouncingBall(3.0, 0.66, 1.5));
        System.out.println(bouncingBall(30.0, 0.66, 1.5));
        System.out.println(bouncingBall(3.0, 1.0, 1.5));
        System.out.println();
        System.out.println(bouncingBall(5.0, 0.83, 5.0));
    }
}

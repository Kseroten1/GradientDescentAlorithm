import java.util.Arrays;

public class Main {

    public static double function(double[] x) {
        return Math.pow(x[0], 4) + Math.pow(x[1], 2) * Math.pow(x[2], 2) - Math.pow(x[3], 2) * x[4];
    }

    public static void step(double[] x) {
        double functionFirst = function(x);
        double k = 1.4;
        for (int i = 0; i < 5; i++) {
            x[i] += k;
            if (function(x) < functionFirst) {
                while (function(x) < functionFirst) {
                    functionFirst = function(x);
                    x[i] += k;
                }
            } else {
                x[i] -= k;
                x[i] -= k;
                if (function(x) < functionFirst) {
                    while (function(x) < functionFirst) {
                        functionFirst = function(x);
                        x[i] -= k;
                    }
                }
            }
        }
    }

    public static double[] x = {1, 1, 1, 1, 1};

    public static void main(String[] args) {

        double[] x1;

        do {
            x1 = x;
            step(x1);
        } while (!Arrays.equals(x1, x));


        for (int i = 0; i < 5; i++) {
            System.out.println(" ");
            System.out.print(" ");
            System.out.print(x[i]);
        }

    }
}
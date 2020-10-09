package HW2;

public class Problem1 {
    public static double Ta(double n) {
        if (n == 2.0) return 1.0;

        double x = Math.sqrt(n);
        return 2 * x * Ta(x) + n;
    }

    public static double Tb(double n) {
        if (n ==1.0) return 1.0;

        double logn = Math.log(n) / Math.log(2);
        return 2 * Tb(n / 2) + n * logn;
    }

    public static void main(String[] args) {
        // test Ta:
//        for (double k = 0; k <= 8.0; ++k) {
//            System.out.println("k: " + k);
//
//            double n = Math.pow(2.0, Math.pow(2.0, k));
//            System.out.println(Ta(n));
//
//            double logn = Math.log(n) / Math.log(2);
//            double cal = n * (2 * logn - logn / 2 - 1);
//            System.out.println(cal);
//        }

        // test Tb:
        for (double k = 10; k <= 25.0; ++k) {
            System.out.println("k: " + k);

            double n = Math.pow(2.0, k);
            System.out.println(Tb(n));

            double logn = Math.log(n) / Math.log(2);
            double cal = n / 2 * (logn * logn + logn + 2);
            System.out.println(cal);
        }
    }
}

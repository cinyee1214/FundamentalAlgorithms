package HW4;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // problem1Test();
        // problem3Test();
        // Problem4Test();
        Problem5Test();
    }

    private static void Problem5Test() {
        Problem5 test = new Problem5();
//        int[] cuts = {3,16,19,28,37,44,47,48,51,52,62};
//        int length = 67;
        int[] cuts = {2, 4, 7};
        int length = 10;
        System.out.println("The minimum cost for cuts[2, 4, 7] with length = 10: ");
        System.out.println(test.minCost(cuts, length));
    }

    private static void Problem4Test() {
        Problem4 test = new Problem4();
        int[] a = new int[] {0, 100, 350, 500};
        System.out.println(test.minPenalty(a, 3));
    }

    private static void problem3Test() {
        Problem3 test = new Problem3();
        int[] D = new int[] {50,20,1,10,100};
        int[][] r = test.optMatricesMultiply(D, 4);
        System.out.println((Arrays.deepToString(r)));
        test.ConstructTree(r, 4);
    }

    private static void problem1Test() {
        Problem1 test = new Problem1();
        double[] p = new double[] {0.75, 0.125, 0.125};
        System.out.println((Arrays.deepToString(test.optimalBST(p, 3))));
    }
}

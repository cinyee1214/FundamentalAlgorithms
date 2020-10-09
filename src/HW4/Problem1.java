package HW4;

public class Problem1 {
    public int[][] optimalBST(double[] p, int n) {
        double[][] D = new double[n][n];
        double[] P = new double[n + 1];
        int[][] root = new int[n][n];

        for (int i = 1; i <= n; ++i) {
            P[i] = P[i - 1] + p[i - 1];
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int k = 0; k < n; ++k) {
                if (i == n - 1 || k == 0) {
                    if (i == k) {
                        D[i][k] = p[i];
                        root[i][k] = i;
                    }
                    continue;
                }
                D[i][k] = Integer.MAX_VALUE;
                for (int j = i; j <= k; ++j) {
                    double tmp1 = j - 1 >= 0 ? D[i][j - 1] : 0;
                    double tmp2 = j + 1 < n ? D[j + 1][k] : 0;
                    double tmp = tmp1 + tmp2;
                    if (tmp < D[i][k]) {
                        D[i][k] = tmp;
                        root[i][k] = j;
                    }
                }
                D[i][k] += P[k + 1] - P[i];
            }
        }
        return root;
    }
}

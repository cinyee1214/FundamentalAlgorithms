package HW5;

import java.util.Arrays;

public class Problem1Iterative {
    public int minDistance(String word1, String word2, int k) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = Math.max(0, i - k); j <= Math.min(i + k, m); ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i, j);
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[n][m];
    }
}

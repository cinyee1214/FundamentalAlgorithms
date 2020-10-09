package HW5;

import javax.swing.*;
import java.util.Arrays;

public class Problem1 {
    public int minDistance(String word1, String word2, int k) {
        int n = word1.length();
        int m = word2.length();

        int[][] memo = new int[n + 1][m + 1];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }

        return stringEdit(word1, n, word2, m, memo, k);
    }

    private static final int IMPOSSIBLE = Integer.MAX_VALUE;
    private int stringEdit(String word1, int i, String word2,
                           int j, int[][] memo, int k) {
        if (memo[i][j] != -1) return memo[i][j];

        if (Math.abs(i - j) > k) {
            memo[i][j] = IMPOSSIBLE;
            return memo[i][j];
        }

        if (i == 0 || j == 0) {
            memo[i][j] = Math.max(i, j);
            return memo[i][j];
        }

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = stringEdit(word1, i - 1, word2, j - 1, memo, k);
        } else {
            memo[i][j] = Math.min(stringEdit(word1, i, word2, j - 1, memo, k), stringEdit(word1, i - 1, word2, j, memo, k));
            memo[i][j] = Math.min(memo[i][j], stringEdit(word1, i - 1, word2, j - 1, memo, k));

            memo[i][j] += 1;
        }

        return memo[i][j];
    }
}

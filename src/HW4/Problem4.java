package HW4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem4 {
    public int minPenalty(int[] a, int n) {
        int[] dp = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int k = 0; k < i; ++k) {
                int tmp = (200 - (a[i] - a[k])) * (200 - (a[i] - a[k])) + dp[k];
                // dp[i] = Math.min(dp[i], tmp);
                if (dp[i] > tmp) {
                    dp[i] = tmp;
                    path[i] = k;
                }
            }
        }
        print(path);
        return dp[n];
    }

    private void print(int[] path) {
        int i = path.length - 1;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(i);

        while (path[i] != 0) {
            i = path[i];
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

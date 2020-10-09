package HW4;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem5 {
    public int minCost(int[] cuts, int length) {
        int m = cuts.length;
        int[] A = new int[m + 2];
        System.arraycopy(cuts, 0, A, 1, m);
        A[m + 1] = length;

        int[][] dp = new int[m + 2][m + 2];
        int[][] order = new int[m + 2][m + 2];
        // dp[i][j] = min(dp[i][k] + dp[k][j] + A[j] - A[i]), over i<k<j
        // dp[i][i+1] = 0
        // res: dp[0][m+1]

        for (int i = m + 1; i >= 0; --i) {
            for (int j = 0; j <= m + 1; ++j) {
                if (i + 1 >= j) continue;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    int tmp = dp[i][k] + dp[k][j] + A[j] - A[i];
                    if (dp[i][j] > tmp) {
                        dp[i][j] = Math.min(dp[i][j], tmp);
                        order[i][j] = k;
                    }
                }
            }
        }
        ConstructTree(order, A, m);
        return dp[0][m + 1];
    }

    static class Node {
        String val;
        Node left, right;
        Node(String val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    private void ConstructTree(int[][] order, int[] cuts, int m) {
        Node root = construct(order, cuts, 0, m + 1);
        print(root);
    }

    private Node construct(int[][] order, int[] cuts, int i, int j) {
        if (i + 1 == j) {
            String str = "Done";
            return new Node(str);
        }

        int k = order[i][j];
        String str = "cut at position: " + cuts[k];
        Node node = new Node(str);
        node.left = construct(order, cuts, i, k);
        node.right = construct(order, cuts, k, j);
        return node;
    }

    private void print(Node v) {
        // level order traversal
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(v);
        int i = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("The cutting position at level " + i + ":");
            i++;
            while (size > 0) {
                size--;
                Node cur = queue.poll();
                System.out.println(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }
}

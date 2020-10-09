package HW4;

import HW1.binaryNode;

import java.util.Arrays;

public class Problem3 {
    public int[][] optMatricesMultiply(int[] D, int n) {
        int[][] Cost = new int[n + 1][n + 1];
        int[][] r = new int[n + 1][n + 1];

        for (int[] co : Cost) {
            Arrays.fill(co, -1);
        }

        OptMM(1, n, Cost, r, D);
        return r;
    }

    private void OptMM(int i, int k, int[][] Cost, int[][] r, int[] D) {
        if (i == k) {
            Cost[i][k] = 0;
            r[i][k] = i;
        } else {
            if (Cost[i + 1][k] == -1) OptMM(i + 1, k, Cost, r, D);
            Cost[i][k] = Cost[i + 1][k] + D[i - 1] * D[i] * D[k];
            r[i][k] = i + 1;

            for (int j = i + 2; j <= k; ++j) {
                if (Cost[i][j - 1] == -1) OptMM(i, j - 1, Cost, r, D);
                if (Cost[j][k] == -1) OptMM(j, k, Cost, r, D);

                int tmp = Cost[i][j-1] + Cost[j][k] + D[i-1] * D[j-1] * D[k];
                if (Cost[i][k] > tmp) {
                    Cost[i][k] = tmp;
                    r[i][k] = j;
                }
            }

        }
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

    public void ConstructTree(int[][] r, int n) {
        Node root = construct(1, n, r);
        print(root);
    }

    private Node construct(int i, int k, int[][] r) {
        if (i == k) {
            String str = "A" + i;
            return new Node(str);
        }

        int j = r[i][k];
        String str = "A" + i + ".." + "A" + k;
        Node node = new Node(str);
        node.left = construct(i, j - 1, r);
        node.right = construct(j, k, r);
        return node;
    }

    private void print(Node v) {
        if (v == null) return;
        print(v.left);
        System.out.println(v.val);
        print(v.right);
    }
}

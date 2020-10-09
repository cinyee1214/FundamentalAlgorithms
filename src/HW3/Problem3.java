package HW3;

public class Problem3 {
    private int cnt;
    public int cntOfInversion(int[] A) {
        int n = A.length;
        cnt = 0;
        helper(A, 0, n - 1, new int[n]);
        return cnt;
    }

    private void helper(int[] A, int start, int end, int[] tmp) {
        if (start == end) return;

        int mid = start + (end - start) / 2;
        helper(A, start, mid, tmp);
        helper(A, mid + 1, end, tmp);

        merge(A, start, mid, end, tmp);
    }

    private void merge(int[] A, int start, int mid, int end, int[] tmp) {
        for (int k = start; k <= end; ++k) {
            tmp[k] = A[k];
        }

        int i = start, j = mid + 1, k = start;
        while (i <= mid) {
            if (j > end || tmp[i] < tmp[j]) {
                cnt += j - mid - 1;
                A[k++] = tmp[i++];
            } else {
                A[k++] = tmp[j++];
            }
        }
    }
}

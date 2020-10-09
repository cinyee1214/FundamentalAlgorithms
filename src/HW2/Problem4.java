package HW2;

public class Problem4 {
    public int findIdx(int[] A, int l, int u) {
        if (l > u) return 0;
        int mid = l + (u - l) / 2;

        if (A[mid] == mid) return mid;

        if (A[mid] > mid) return findIdx(A, l, mid - 1);

        return findIdx(A, mid + 1, u);
    }
}

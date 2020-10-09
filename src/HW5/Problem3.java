package HW5;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public void sort(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int k = map.size(), i = 0;

        Map.Entry<Integer, Integer>[] buckets = new Map.Entry[k];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets[i++] = entry;
        }

        mergeSort(buckets, 0, k - 1, new Map.Entry[k]);

        int idx = 0;
        for (int j = 0; j < k; ++j) {
            int num = buckets[j].getKey();
            int cnt = buckets[j].getValue();
            while (cnt > 0) {
                A[idx++] = num;
                cnt--;
            }
        }
    }

    private void mergeSort(Map.Entry<Integer, Integer>[] buckets, int start, int end, Map.Entry<Integer, Integer>[] tmp) {
        if (start == end) return;

        int mid = start + (end - start) / 2;
        mergeSort(buckets, start, mid, tmp);
        mergeSort(buckets, mid + 1, end, tmp);

        merge(buckets, start, mid, end, tmp);
    }

    private void merge(Map.Entry<Integer, Integer>[] buckets, int start, int mid, int end, Map.Entry<Integer, Integer>[] tmp) {
        for (int k = start; k <= end; ++k) {
            tmp[k] = buckets[k];
        }

        int i = start, j = mid + 1, k = start;
        while (i <= mid) {
            if (j > end || tmp[i].getKey() < tmp[j].getKey()) {
                buckets[k++] = tmp[i++];
            } else {
                buckets[k++] = tmp[j++];
            }
        }
    }
}

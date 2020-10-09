package HW3;

import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;

import java.util.ArrayList;
import java.util.List;

public class Problem4Plus {
    public List<List<Integer>> sorting(List<List<Integer>> A) {
        int n = A.size();
        return mergeSort(A, 0, n - 1);
    }

    private List<List<Integer>> mergeSort(List<List<Integer>> A, int start, int end) {
        if (start == end) {
            List<List<Integer>> bucket = new ArrayList<>();
            bucket.add(new ArrayList<>(A.get(start)));
            return bucket;
        }

        int mid = start + (end - start) / 2;
        List<List<Integer>> left = mergeSort(A, start, mid);
        List<List<Integer>> right = mergeSort(A, mid + 1, end);

        return merge(left, right);
    }

    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> buckets = new ArrayList<>();

        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).get(0).equals(right.get(j).get(0))) {
                left.get(i).addAll(right.get(j));
                buckets.add(new ArrayList<>(left.get(i)));
                i++;
                j++;
            } else if (left.get(i).get(0) < right.get(j).get(0)) {
                buckets.add(new ArrayList<>(left.get(i)));
                i++;
            } else {
                buckets.add(new ArrayList<>(right.get(j)));
                j++;
            }
        }
        while (i < left.size()) {
            buckets.add(new ArrayList<>(left.get(i++)));
        }
        while (j < right.size()) {
            buckets.add(new ArrayList<>(right.get(j++)));
        }
        return buckets;
    }
}

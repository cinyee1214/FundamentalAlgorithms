package HW3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
//        Problem4 test = new Problem4();
//        int[] A = new int[]{4, 1,5,5, 6, 2, 5, 3,3,3,2,3,6};
//        test.sort(A);
//        for (int a : A) {
//            System.out.println(a);
//        }

        Problem4Plus test = new Problem4Plus();
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(4));
        A.add(Arrays.asList(1));
        A.add(Arrays.asList(5));
        A.add(Arrays.asList(5));
        A.add(Arrays.asList(3));
        A.add(Arrays.asList(4));
        A.add(Arrays.asList(1));
        A.add(Arrays.asList(4));
        A.add(Arrays.asList(1));
        A.add(Arrays.asList(4));
        A.add(Arrays.asList(3));

        List<List<Integer>> ordered = test.sorting(A);

        for (List<Integer> list : ordered) {
            System.out.println("ele: " + list.get(0));
            System.out.println("size: " + list.size());
        }
    }
}

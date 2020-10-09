package HW3;

public class Test3 {
    public static void main(String[] args) {
        Problem3 test = new Problem3();
        int[] A = new int[] {4,1,6,2,5,3};
        System.out.println(test.cntOfInversion(A));

        int[] B = new int[] {7,1,4,2};
        System.out.println(test.cntOfInversion(B));

        int[] C = new int[] {1,3,5,7,2,4,6,8};
        System.out.println(test.cntOfInversion(C));

        int[] D = new int[] {4,13,2,1};
        System.out.println(test.cntOfInversion(D));
    }
}

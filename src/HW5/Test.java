package HW5;

public class Test {
    public static void main(String[] args) {
//        problem1Test();
//        Problem1IterativeTest();
        // problem3Test();
        // Problem4Test();
        // Problem5Test();

    }

    private static void Problem1IterativeTest() {
        Problem1Iterative test = new Problem1Iterative();

        System.out.println(test.minDistance("intention", "execution", 5)); // 5
        System.out.println(test.minDistance("horseyffvnvt", "ros", 10)); // 10
    }

    private static void problem1Test() {
        Problem1 test = new Problem1();

        System.out.println(test.minDistance("horse", "ros", 3)); // 3
        System.out.println(test.minDistance("intention", "execution", 5)); // 5
        System.out.println(test.minDistance("horseyffvnvt", "ros", 10)); // 10
    }
}

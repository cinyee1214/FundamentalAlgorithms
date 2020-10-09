package HW1;

public class Test6 {
    public static void main(String[] args) {
        Problem6 test6 = new Problem6();
        binaryNode T = new binaryNode(5);

        binaryNode n1 = new binaryNode(1);
        binaryNode n2 = new binaryNode(2);
        binaryNode n3 = new binaryNode(3);
        binaryNode n4 = new binaryNode(4);
        binaryNode n6 = new binaryNode(6);
        binaryNode n7 = new binaryNode(7);
        binaryNode n8 = new binaryNode(8);

        T.left = n3;
        T.right = n6;
        n3.left = n2;
        n3.right = n4;
        n2.left = n1;
        n6.right = n8;
        n8.left = n7;

        print(T);
        System.out.println("rotate:");

        test6.rotate(T);

        print(T);
    }

    private static void print(binaryNode v) {
        if (v == null) return;
        print(v.left);
        System.out.println(v.val);
        print(v.right);
    }
}

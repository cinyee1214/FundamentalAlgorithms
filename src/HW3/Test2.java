package HW3;

public class Test2 {
    public static void main(String[] args) {
        Node T = new Node(0, "T");
        Node n2 = new Node(1, "2");
        Node n3 = new Node(2, "3");
        Node n4 = new Node(1, "4");
        Node n5 = new Node(2, "5");
        Node n6 = new Node(3, "6");
        Node n7 = new Node(3, "7");
        Node n8 = new Node(3, "8");
        Node n9 = new Node(5, "9");
        Node n10 = new Node(1, "10");
        Node n11 = new Node(3, "11");
        Node n12 = new Node(2, "12");
        Node n13 = new Node(1, "13");
        Node n14 = new Node(10, "14");
        Node n15 = new Node(1, "15");

        T.children.add(n2);
        T.children.add(n3);
        T.children.add(n4);

        n2.children.add(n5);
        n2.children.add(n6);

        n3.children.add(n7);

        n4.children.add(n8);
        n4.children.add(n9);

        n5.children.add(n15);

        n9.children.add(n10);
        n9.children.add(n11);

        n10.children.add(n12);
        n12.children.add(n13);
        n13.children.add(n14);

        Problem2 test = new Problem2();
        test.traverse(T);
    }
}

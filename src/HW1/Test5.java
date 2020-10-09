package HW1;

public class Test5 {
    public static void main(String[] args) {
        Node T = new Node("blue", 1);
        Node n2 = new Node("blue", 2);
        Node n3 = new Node("red", 3);
        Node n4 = new Node("red", 4);
        Node n5 = new Node("blue", 5);
        Node n6 = new Node("red", 6);
        Node n7 = new Node("blue", 7);
        Node n8 = new Node("red", 8);
        Node n9 = new Node("blue", 9);
        Node n10 = new Node("blue", 10);
        Node n11 = new Node("red", 11);

        T.children.add(n2);
        T.children.add(n3);

        n2.children.add(n4);
        n2.children.add(n5);
        n3.children.add(n6);

        n4.children.add(n7);
        n5.children.add(n8);

        n8.children.add(n9);
        n8.children.add(n10);

        n10.children.add(n11);

        Problem5 test5 = new Problem5();
        test5.traverse(T);
    }
}
